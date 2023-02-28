package com.mgv.libraryserver.backend.bookings.application.search_by_book;

import com.mgv.libraryserver.backend.bookings.application.response.BookingResponse;
import com.mgv.libraryserver.backend.bookings.domain.vo.BookingBookId;
import com.mgv.libraryserver.shared.domain.bus.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class SearchBookingByBookQueryHandler implements QueryHandler<BookingResponse, SearchBookingByBookQuery> {
    private ByBookBookingSearcher searcher;

    public SearchBookingByBookQueryHandler(ByBookBookingSearcher searcher) {
        this.searcher = searcher;
    }

    @Override
    public BookingResponse ask(SearchBookingByBookQuery query) throws Exception {
        return searcher.findByBook(new BookingBookId(query.bookId()));
    }
}
