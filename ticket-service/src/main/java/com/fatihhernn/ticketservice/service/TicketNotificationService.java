package com.fatihhernn.ticketservice.service;

import com.fatihhernn.messaging.TicketNotification;
import com.fatihhernn.ticketservice.model.Ticket;

public interface TicketNotificationService {
    void sendToQueue(Ticket ticket);
}
