package com.fatihhernn.ticketservice.service.impl;

import com.fatihhernn.client.AccountServiceClient;
import com.fatihhernn.client.contract.AccountDto;
import com.fatihhernn.ticketservice.dto.TicketDto;
import com.fatihhernn.ticketservice.model.PriorityType;
import com.fatihhernn.ticketservice.model.Ticket;
import com.fatihhernn.ticketservice.model.TicketStatus;
import com.fatihhernn.ticketservice.model.elastic.TicketModel;
import com.fatihhernn.ticketservice.repository.TicketRepository;
import com.fatihhernn.ticketservice.repository.elastic.TicketElasticRepository;
import com.fatihhernn.ticketservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketElasticRepository ticketElasticRepository;
    private final TicketRepository ticketRepository;
    private final ModelMapper modelMapper;
    private final AccountServiceClient accountServiceClient;

    @Override
    @Transactional
    public TicketDto save(TicketDto ticketDto) {

        //ticket entity.
        Ticket ticket=new Ticket();

        ResponseEntity<AccountDto> accountDtoResponseEntity = accountServiceClient.get(ticketDto.getAssignee());


        if (ticketDto.getDescription()==null)
            throw new IllegalArgumentException("Description bış olamaz");

        ticket.setDescription(ticketDto.getDescription());
        ticket.setNotes(ticketDto.getNotes());
        ticket.setTicketDate(ticketDto.getTicketDate());
        ticket.setTicketStatus(TicketStatus.valueOf(ticketDto.getTicketStatus()));
        ticket.setPriorityType(PriorityType.valueOf(ticketDto.getPriorityType()));
        ticket.setAssignee(accountDtoResponseEntity.getBody().getId());

        //mysql kaydet.
        ticket=ticketRepository.save(ticket);

        //ticket model nesnesi yarat. - elastic search için
        TicketModel ticketModel= TicketModel.builder()
                            .description(ticket.getDescription())
                            .notes(ticket.getNotes())
                            .id(ticket.getId())
                            .assignee(accountDtoResponseEntity.getBody().getNameSurname())
                            .priorityType(ticket.getPriorityType().getLabel())
                            .ticketStatus(ticket.getTicketStatus().getLabel())
                            .ticketDate(ticket.getTicketDate())
                            .build();

        //elastic kaydet.
        ticketElasticRepository.save(ticketModel);

        //oluşan nesneyi döndür.
        ticketDto.setId(ticket.getId());

        return ticketDto;
    }

    @Override
    public TicketDto update(String id,TicketDto ticketDto) {
        return null;
    }

    @Override
    public TicketDto getById(String id) {
        return null;
    }

    @Override
    public Page<TicketDto> getPagination(Pageable pageable) {
        return null;
    }
}
