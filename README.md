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

## Interview Highlights
- Handles race conditions
- Scalable backend design
- Production-ready concurrency strategy
