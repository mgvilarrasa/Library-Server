package com.mgv.libraryserver.backend.bookings.application.search_by_book;

import com.mgv.libraryserver.backend.bookings.application.response.BookingResponse;
import com.mgv.libraryserver.backend.bookings.domain.BookingRepository;
import com.mgv.libraryserver.backend.bookings.domain.vo.BookingBookId;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class ByBookBookingSearcher {
    private final static Logger LOG = Logger.getLogger(String.valueOf(ByBookBookingSearcher.class));

    private BookingRepository repository;

    public ByBookBookingSearcher(BookingRepository repository) {
        this.repository = repository;
    }

    public BookingResponse findByBook(BookingBookId bookId){
        return repository.searchByBook(bookId).map(BookingResponse::fromAggregate).orElse(null);
    }
}
