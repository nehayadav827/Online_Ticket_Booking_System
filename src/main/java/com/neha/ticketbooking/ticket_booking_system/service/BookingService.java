package com.neha.ticketbooking.ticket_booking_system.service;

import com.neha.ticketbooking.ticket_booking_system.entity.Booking;
import com.neha.ticketbooking.ticket_booking_system.repository.BookingRepository;
import com.neha.ticketbooking.ticket_booking_system.repository.EventRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Transactional
    public Booking bookTicket(Long eventId, Long userId, int seats) {

        int updated = eventRepository.updateSeats(eventId, seats);

        if (updated == 0) {
            throw new RuntimeException("Not enough seats available");
        }

        Booking booking = new Booking();
        booking.setEventId(eventId);
        booking.setUserId(userId);
        booking.setSeatCount(seats);
        booking.setStatus("CONFIRMED");

        return bookingRepository.save(booking);
    }
}

