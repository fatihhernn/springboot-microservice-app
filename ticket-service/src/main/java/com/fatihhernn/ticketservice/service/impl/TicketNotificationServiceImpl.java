package com.fatihhernn.ticketservice.service.impl;

import com.fatihhernn.messaging.TicketNotification;
import com.fatihhernn.ticketservice.model.Ticket;
import com.fatihhernn.ticketservice.service.TicketNotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Source.class)
@RequiredArgsConstructor
public class TicketNotificationServiceImpl implements TicketNotificationService {

    private final Source source;

    @Override
    public void sendToQueue(Ticket ticket) {
        TicketNotification ticketNotification=new TicketNotification();
        ticketNotification.setAccountId(ticket.getAssignee());
        ticketNotification.setTicketDescription(ticket.getDescription());
        ticketNotification.setTicketId(ticket.getId());

        source.output().send(MessageBuilder.withPayload(ticketNotification).build());
    }
}
