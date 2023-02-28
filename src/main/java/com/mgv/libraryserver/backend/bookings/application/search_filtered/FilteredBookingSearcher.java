package com.mgv.libraryserver.backend.bookings.application.search_filtered;

import com.mgv.libraryserver.backend.bookings.application.response.BookingResponse;
import com.mgv.libraryserver.backend.bookings.application.response.BookingsResponse;
import com.mgv.libraryserver.backend.bookings.domain.BookingRepository;
import com.mgv.libraryserver.backend.bookings.domain.vo.BookingUserId;
import org.springframework.stereotype.Service;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class FilteredBookingSearcher {
    private final static Logger LOG = Logger.getLogger(String.valueOf(FilteredBookingSearcher.class));

    private BookingRepository repository;

    public FilteredBookingSearcher(BookingRepository repository) {
        this.repository = repository;
    }

    public BookingsResponse findByUser(BookingUserId userId){
        return new BookingsResponse(repository.findByUser(userId).stream().map(BookingResponse::fromAggregate).collect(Collectors.toList()));
    }

    public BookingsResponse findPendingByUser(BookingUserId userId){
        return new BookingsResponse(repository.findPendingByUser(userId).stream().map(BookingResponse::fromAggregate).collect(Collectors.toList()));
    }

    public BookingsResponse findPending(){
        return new BookingsResponse(repository.findPending().stream().map(BookingResponse::fromAggregate).collect(Collectors.toList()));
    }
}
