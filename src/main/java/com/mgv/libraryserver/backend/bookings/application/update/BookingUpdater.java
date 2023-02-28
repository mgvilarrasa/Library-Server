package com.mgv.libraryserver.backend.bookings.application.update;

import com.mgv.libraryserver.backend.bookings.domain.Booking;
import com.mgv.libraryserver.backend.bookings.domain.BookingRepository;
import com.mgv.libraryserver.backend.bookings.domain.exceptions.BookingNotExists;
import com.mgv.libraryserver.backend.bookings.domain.vo.*;
import com.mgv.libraryserver.backend.books.application.find.FindBookQuery;
import com.mgv.libraryserver.backend.books.application.response.BookResponse;
import com.mgv.libraryserver.backend.users.application.find.FindUserQuery;
import com.mgv.libraryserver.backend.users.application.response.UserResponse;
import com.mgv.libraryserver.shared.infrastructure.bus.QueryBus;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class BookingUpdater {
    private final static Logger LOG = Logger.getLogger(String.valueOf(BookingUpdater.class));

    private BookingRepository repository;
    private QueryBus queryBus;

    public BookingUpdater(BookingRepository repository, QueryBus queryBus){
        this.repository = repository;
        this.queryBus = queryBus;
    }

    public void updateBooking(
            BookingUuid uuid,
            BookingUserId userId,
            BookingBookId bookId,
            BookingStartDate startDate,
            BookingEndDate endDate
    ) throws Exception{
        Optional<Booking> optBooking = repository.searchById(uuid);
        if(optBooking.isEmpty()) throw new BookingNotExists(uuid);
        Booking booking = optBooking.get();
        BookingUserName userName;
        BookingBookTitle bookTitle;
        BookingBookInternalId bookInternalId;
        if(!userId.equals(booking.userId())){
            UserResponse user = queryBus.ask(new FindUserQuery(userId.value()));
            userName = new BookingUserName(user.getName() + " " + user.getLastName() + " " + user.getLastName2());
        } else{
            userName = booking.userName();
        }
        if(!bookId.equals(booking.bookId())){
            BookResponse book = queryBus.ask(new FindBookQuery(bookId.value()));
            bookTitle = new BookingBookTitle(book.getTitle());
            bookInternalId = new BookingBookInternalId(book.getInternalId());
        } else{
            bookTitle = booking.bookTitle();
            bookInternalId = booking.bookInternalId();
        }
        booking.update(userId, userName, bookId, bookTitle, bookInternalId, startDate, endDate);
        repository.save(booking);
    }

    public void returnBook(BookingUuid uuid) throws Exception{
        Optional<Booking> optBooking = repository.searchById(uuid);
        if(optBooking.isEmpty()) throw new BookingNotExists(uuid);
        Booking booking = optBooking.get();
        booking.returnBook();
        repository.save(booking);
    }

    public void delayReturn(BookingUuid uuid, BookingEndDate newEndDate) throws Exception{
        Optional<Booking> optBooking = repository.searchById(uuid);
        if(optBooking.isEmpty()) throw new BookingNotExists(uuid);
        Booking booking = optBooking.get();
        booking.delayReturn(newEndDate);
        repository.save(booking);
    }
}
