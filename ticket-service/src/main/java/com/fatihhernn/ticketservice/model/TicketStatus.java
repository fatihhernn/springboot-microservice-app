package com.fatihhernn.ticketservice.model;

import lombok.Getter;

@Getter
public enum TicketStatus {
    OPEN("Açık"),
    IN_PROGRESS("Üzerinde Çalışılıyor"),
    RESOLVED("Çözüldü"),
    CLOSED("Kapandı");

    private String label;

    TicketStatus(String label) {
        this.label = label;
    }


}
