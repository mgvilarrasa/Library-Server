package com.mgv.libraryserver.backend.bookings.application.response;

import com.mgv.libraryserver.shared.domain.bus.Response;

import java.util.List;

public class BookingsResponse implements Response {
    private final List<BookingResponse> bookings;

    public BookingsResponse(List<BookingResponse> bookings){
        this.bookings = bookings;
    }

    public List<BookingResponse> getBookings() {
        return bookings;
    }
}
