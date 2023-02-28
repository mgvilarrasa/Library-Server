package com.mgv.libraryserver.backend.bookings.application.search_all;

import com.mgv.libraryserver.backend.bookings.application.response.BookingResponse;
import com.mgv.libraryserver.backend.bookings.application.response.BookingsResponse;
import com.mgv.libraryserver.backend.bookings.domain.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class AllBookingsSearcher {
    private final static Logger LOG = Logger.getLogger(String.valueOf(AllBookingsSearcher.class));

    private BookingRepository repository;

    public AllBookingsSearcher(BookingRepository repository) {
        this.repository = repository;
    }

    public BookingsResponse findAll(){
        return new BookingsResponse(repository.findAll().stream().map(BookingResponse::fromAggregate).collect(Collectors.toList()));
    }
}
