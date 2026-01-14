package com.neha.ticketbooking.ticket_booking_system.repository;

import com.neha.ticketbooking.ticket_booking_system.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface EventRepository extends JpaRepository<Event, Long> {

    @Modifying
    @Query("""
        UPDATE Event e
        SET e.availableSeats = e.availableSeats - :seats
        WHERE e.id = :eventId AND e.availableSeats >= :seats
    """)
    int updateSeats(Long eventId, int seats);
}
