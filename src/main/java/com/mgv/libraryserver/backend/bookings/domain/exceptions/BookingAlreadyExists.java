package com.mgv.libraryserver.backend.bookings.domain.exceptions;

import com.mgv.libraryserver.backend.bookings.domain.vo.BookingUuid;
import com.mgv.libraryserver.shared.domain.DomainError;

public class BookingAlreadyExists extends DomainError {
    public BookingAlreadyExists(BookingUuid uuid) {
        super("booking_already_exists", String.format("The booking <%s> already exist", uuid.value()));
    }
}
