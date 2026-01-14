package com.neha.ticketbooking.ticket_booking_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookingRequest {
    private Long eventId;
    private Long userId;
    private int seats;
}
