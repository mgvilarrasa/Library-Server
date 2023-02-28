package com.mgv.libraryserver.backend.bookings.application.search_filtered;

import com.mgv.libraryserver.backend.bookings.application.response.BookingsResponse;
import com.mgv.libraryserver.backend.bookings.domain.vo.BookingUserId;
import com.mgv.libraryserver.shared.domain.bus.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class SearchFilteredBookingsQueryHandler implements QueryHandler<BookingsResponse, SearchFilteredBookingsQuery> {
    private FilteredBookingSearcher searcher;

    public SearchFilteredBookingsQueryHandler(FilteredBookingSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public BookingsResponse ask(SearchFilteredBookingsQuery query) throws Exception {
        if((query.userId() != null && !query.userId().isEmpty()) && query.pending()){
            BookingUserId userId = new BookingUserId(query.userId());
            return searcher.findPendingByUser(userId);
        }
        if((query.userId() != null && !query.userId().isEmpty()) && !query.pending()){
            BookingUserId userId = new BookingUserId(query.userId());
            return searcher.findByUser(userId);
        }
        return searcher.findPending();
    }
}
