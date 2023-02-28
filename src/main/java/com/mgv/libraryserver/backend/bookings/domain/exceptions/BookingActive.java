package com.mgv.libraryserver.backend.bookings.domain.exceptions;

import com.mgv.libraryserver.shared.domain.DomainError;

public class BookingActive extends DomainError {
    public BookingActive() {
        super("booking_active", "The user has already booked this book");
    }
}
