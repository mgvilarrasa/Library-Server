package com.mgv.libraryserver.backend.bookings.application.find;

import com.mgv.libraryserver.backend.bookings.application.response.BookingResponse;
import com.mgv.libraryserver.backend.bookings.domain.BookingRepository;
import com.mgv.libraryserver.backend.bookings.domain.exceptions.BookingNotExists;
import com.mgv.libraryserver.backend.bookings.domain.vo.BookingUuid;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class BookingFinder {
    private final static Logger LOG = Logger.getLogger(String.valueOf(BookingFinder.class));

    private BookingRepository repository;

    public BookingFinder(BookingRepository repository) {
        this.repository = repository;
    }

    public BookingResponse findById(BookingUuid uuid) throws BookingNotExists {
        return repository.searchById(uuid).map(BookingResponse::fromAggregate).orElseThrow(() -> new BookingNotExists(uuid));
    }
}
