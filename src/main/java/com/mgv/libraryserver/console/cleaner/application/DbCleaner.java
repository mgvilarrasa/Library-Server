package com.mgv.libraryserver.console.cleaner.application;

import com.mgv.libraryserver.backend.bookings.application.delete.BookingDeleter;
import com.mgv.libraryserver.backend.books.application.delete.BookDeleter;
import com.mgv.libraryserver.backend.users.application.delete.UserDeleter;
import com.mgv.libraryserver.console.cleaner.domain.NotProperEntity;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class DbCleaner {
    private static Logger LOG = Logger.getLogger(String.valueOf(DbCleaner.class));

    private final BookDeleter bookDeleter;
    private final UserDeleter userDeleter;
    private final BookingDeleter bookingDeleter;

    public DbCleaner(
            BookDeleter bookDeleter,
            UserDeleter userDeleter,
            BookingDeleter bookingDeleter
    ){
        this.bookDeleter = bookDeleter;
        this.userDeleter = userDeleter;
        this.bookingDeleter = bookingDeleter;
    }

    public void cleanDb(String entity) throws NotProperEntity{
        switch (entity) {
            case "book":
                bookDeleter.deleteAll();
                break;
            case "user":
                userDeleter.deleteAll();
                break;
            case "booking":
                bookingDeleter.deleteAll();
                break;
            case "all":
                bookDeleter.deleteAll();
                userDeleter.deleteAll();
                bookingDeleter.deleteAll();
                break;
            default:
                throw new NotProperEntity(entity);
        }
    }
}
