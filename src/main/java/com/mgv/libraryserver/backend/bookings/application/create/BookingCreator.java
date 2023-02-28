package com.mgv.libraryserver.backend.bookings.application.create;

import com.mgv.libraryserver.backend.bookings.domain.Booking;
import com.mgv.libraryserver.backend.bookings.domain.BookingRepository;
import com.mgv.libraryserver.backend.bookings.domain.exceptions.BookAlreadyBooked;
import com.mgv.libraryserver.backend.bookings.domain.exceptions.BookingActive;
import com.mgv.libraryserver.backend.bookings.domain.exceptions.BookingAlreadyExists;
import com.mgv.libraryserver.backend.bookings.domain.vo.*;
import com.mgv.libraryserver.backend.books.application.find.FindBookQuery;
import com.mgv.libraryserver.backend.books.application.response.BookResponse;
import com.mgv.libraryserver.backend.users.application.find.FindUserQuery;
import com.mgv.libraryserver.backend.users.application.response.UserResponse;
import com.mgv.libraryserver.shared.infrastructure.bus.CommandBus;
import com.mgv.libraryserver.shared.infrastructure.bus.QueryBus;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class BookingCreator {
    private final static Logger LOG = Logger.getLogger(String.valueOf(BookingCreator.class));

    private final BookingRepository repository;
    private final QueryBus queryBus;

    public BookingCreator(
            BookingRepository repository,
            QueryBus queryBus
    ){
        this.repository = repository;
        this.queryBus = queryBus;
    }

    public void createBooking(
            BookingUuid uuid,
            BookingUserId userId,
            BookingBookId bookId,
            BookingStartDate startDate,
            BookingEndDate endDate
    ) throws Exception {
        if(repository.searchById(uuid).isPresent()) throw new BookingAlreadyExists(uuid);
        if(repository.searchByUserAndBook(userId, bookId).isPresent()) throw new BookingActive();
        Optional<Booking> anotherUserBooking = repository.searchByBook(bookId);
        if(anotherUserBooking.isPresent()) throw new BookAlreadyBooked(anotherUserBooking.get().bookTitle(), anotherUserBooking.get().userName());
        UserResponse user = queryBus.ask(new FindUserQuery(userId.value()));
        BookResponse book = queryBus.ask(new FindBookQuery(bookId.value()));
        BookingUserName userName = new BookingUserName(user.getName() + " " + user.getLastName() + " " + user.getLastName2());
        BookingBookTitle bookTitle = new BookingBookTitle(book.getTitle());
        BookingBookInternalId bookInternalId = new BookingBookInternalId(book.getInternalId());

        Booking booking = Booking.create(
                uuid, userId, userName, bookId, bookTitle, bookInternalId, startDate, endDate, new BookingReturnDate(null)
        );
        repository.save(booking);
    }
}
