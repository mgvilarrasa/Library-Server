package com.mgv.libraryserver.backend.bookings.application.search_by_book;

import com.mgv.libraryserver.backend.bookings.application.response.BookingResponse;
import com.mgv.libraryserver.shared.domain.bus.Query;

public class SearchBookingByBookQuery extends Query<BookingResponse> {
    private final String bookId;

    public SearchBookingByBookQuery(String bookId) {
        this.bookId = bookId;
    }

    public String bookId() {
        return bookId;
    }
}
