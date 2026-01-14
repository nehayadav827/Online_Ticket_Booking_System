# Online Ticket Booking System

## Tech Stack
- Spring Boot
- PostgreSQL
- Spring Data JPA

## Features
- Create events
- View seat availability
- Concurrent ticket booking
- Prevents overbooking using atomic SQL updates

## Concurrency Handling
- PostgreSQL row-level locking
- Atomic update queries
- @Transactional consistency

## APIs
POST /events  
GET /events  
POST /bookings


## How to Run in your system
Download the zip file
extract it and run TicketBookingSystemApplication.java
and run this site http://localhost:9090/ in your browser


