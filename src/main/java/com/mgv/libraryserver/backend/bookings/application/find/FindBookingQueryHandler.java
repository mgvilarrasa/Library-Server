package com.mgv.libraryserver.backend.bookings.application.find;

import com.mgv.libraryserver.backend.bookings.application.response.BookingResponse;
import com.mgv.libraryserver.backend.bookings.domain.exceptions.BookingNotExists;
import com.mgv.libraryserver.backend.bookings.domain.vo.BookingUuid;
import com.mgv.libraryserver.shared.domain.bus.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class FindBookingQueryHandler implements QueryHandler<BookingResponse, FindBookingQuery> {
    private final BookingFinder finder;

    public FindBookingQueryHandler(BookingFinder finder){
        this.finder = finder;
    }

    @Override
    public BookingResponse ask(FindBookingQuery query) throws BookingNotExists {
        return finder.findById(new BookingUuid(query.uuid()));
    }
}
