package com.mgv.libraryserver.backend.bookings.application.search_all;

import com.mgv.libraryserver.backend.bookings.application.response.BookingsResponse;
import com.mgv.libraryserver.shared.domain.bus.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class SearchAllBookingsQueryHandler implements QueryHandler<BookingsResponse, SearchAllBookingsQuery> {
    private AllBookingsSearcher searcher;

    public SearchAllBookingsQueryHandler(AllBookingsSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public BookingsResponse ask(SearchAllBookingsQuery query) throws Exception {
        return searcher.findAll();
    }
}
