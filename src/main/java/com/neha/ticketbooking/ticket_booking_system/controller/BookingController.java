package com.neha.ticketbooking.ticket_booking_system.controller;

import com.neha.ticketbooking.ticket_booking_system.dto.BookingRequest;
import com.neha.ticketbooking.ticket_booking_system.entity.Booking;
import com.neha.ticketbooking.ticket_booking_system.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public Booking book(@RequestBody BookingRequest request) {
        return bookingService.bookTicket(
                request.getEventId(),
                request.getUserId(),
                request.getSeats()
        );
    }
}

