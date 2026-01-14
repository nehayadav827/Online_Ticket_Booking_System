package com.neha.ticketbooking.ticket_booking_system.controller;

import com.neha.ticketbooking.ticket_booking_system.entity.Event;
import com.neha.ticketbooking.ticket_booking_system.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping
    public Event create(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @GetMapping
    public List<Event> getAll() {
        return eventService.getAllEvents();
    }
}

