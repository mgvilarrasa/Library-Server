package com.mgv.libraryserver.backend.bookings.application.delete;

import com.mgv.libraryserver.backend.bookings.domain.Booking;
import com.mgv.libraryserver.backend.bookings.domain.BookingRepository;
import com.mgv.libraryserver.backend.bookings.domain.exceptions.BookingActive;
import com.mgv.libraryserver.backend.bookings.domain.exceptions.BookingNotAllowedDelete;
import com.mgv.libraryserver.backend.bookings.domain.exceptions.BookingNotExists;
import com.mgv.libraryserver.backend.bookings.domain.vo.BookingUuid;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class BookingDeleter {
    private final static Logger LOG = Logger.getLogger(String.valueOf(BookingDeleter.class));

    private final BookingRepository repository;

    public BookingDeleter(BookingRepository repository){
        this.repository = repository;
    }

    public void deleteBooking(BookingUuid uuid) throws Exception{
        Optional<Booking> optBooking =  repository.searchById(uuid);
        if(optBooking.isEmpty()) throw new BookingNotExists(uuid);
        if(optBooking.get().returnDate().value() == null) throw new BookingNotAllowedDelete();
        repository.delete(uuid);
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
