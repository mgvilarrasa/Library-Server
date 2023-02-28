package com.mgv.libraryserver.backend.bookings.domain.exceptions;

import com.mgv.libraryserver.backend.bookings.domain.vo.BookingUuid;
import com.mgv.libraryserver.shared.domain.DomainError;

public class BookingNotExists extends DomainError {
    public BookingNotExists(BookingUuid uuid) {
        super("booking_not_exists", String.format("The booking <%s> doesn't exist", uuid.value()));
    }
}
