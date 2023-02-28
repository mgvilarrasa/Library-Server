package com.mgv.libraryserver.backend.bookings.application.search_delayed;

import com.mgv.libraryserver.backend.bookings.application.response.BookingsResponse;
import com.mgv.libraryserver.shared.domain.bus.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class SearchDelayedBookingsQueryHandler implements QueryHandler<BookingsResponse, SearchDelayedBookingsQuery> {
    private DelayedBookingSearcher searcher;

    public SearchDelayedBookingsQueryHandler(DelayedBookingSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public BookingsResponse ask(SearchDelayedBookingsQuery query) throws Exception {
        return searcher.findDelayed();
    }
}
