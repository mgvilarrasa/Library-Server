package com.mgv.libraryserver.backend.bookings.domain.exceptions;

import com.mgv.libraryserver.shared.domain.DomainError;

public class BookingNotAllowedDelete extends DomainError {
    public BookingNotAllowedDelete() {
        super("booking_active", "A user has already booked this book. Return it before deleting this booking");
    }
}
