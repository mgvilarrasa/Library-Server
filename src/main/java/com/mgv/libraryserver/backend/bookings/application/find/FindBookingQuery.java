package com.mgv.libraryserver.backend.bookings.application.find;

import com.mgv.libraryserver.backend.bookings.application.response.BookingResponse;
import com.mgv.libraryserver.shared.domain.bus.Query;

public class FindBookingQuery extends Query<BookingResponse> {
    private final String uuid;

    public FindBookingQuery(String uuid){
        this.uuid = uuid;
    }

    public String uuid() {
        return uuid;
    }
}
