package com.mgv.libraryserver.backend.bookings.domain.exceptions;

import com.mgv.libraryserver.backend.bookings.domain.vo.BookingBookTitle;
import com.mgv.libraryserver.backend.bookings.domain.vo.BookingUserName;
import com.mgv.libraryserver.backend.bookings.domain.vo.BookingUuid;
import com.mgv.libraryserver.shared.domain.DomainError;

public class BookAlreadyBooked extends DomainError {
    public BookAlreadyBooked(BookingBookTitle bookTitle, BookingUserName userName) {
        super("book_already_booked", String.format("The book <%s> is already booked by <%s>", bookTitle.value(), userName.value()));
    }
}
