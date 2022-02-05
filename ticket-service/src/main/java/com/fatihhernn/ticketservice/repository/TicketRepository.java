package com.fatihhernn.ticketservice.repository;

import com.fatihhernn.ticketservice.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,String> {
}
