package com.mgv.libraryserver.backend.bookings.application.search_filtered;

import com.mgv.libraryserver.backend.bookings.application.response.BookingsResponse;
import com.mgv.libraryserver.shared.domain.bus.Query;

public class SearchFilteredBookingsQuery extends Query<BookingsResponse> {
    private final String userId;
    private final Boolean pending;

    public SearchFilteredBookingsQuery(String userId, Boolean pending) {
        this.userId = userId;
        this.pending = pending;
    }

    public String userId() {
        return userId;
    }

    public Boolean pending() {
        return pending;
    }
}
