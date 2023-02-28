package com.mgv.libraryserver.backend.bookings.application.search_delayed;

import com.mgv.libraryserver.backend.bookings.application.response.BookingResponse;
import com.mgv.libraryserver.backend.bookings.application.response.BookingsResponse;
import com.mgv.libraryserver.backend.bookings.domain.BookingRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class DelayedBookingSearcher {
    private final static Logger LOG = Logger.getLogger(String.valueOf(DelayedBookingSearcher.class));

    private BookingRepository repository;

    public DelayedBookingSearcher(BookingRepository repository) {
        this.repository = repository;
    }

    public BookingsResponse findDelayed(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = df.format(new Date());
        return new BookingsResponse(repository.findDelayed(currentDate).stream().map(BookingResponse::fromAggregate).collect(Collectors.toList()));
    }
}
