package com.mgv.libraryserver.backend.bookings.infrastructure;

import com.mgv.libraryserver.backend.bookings.domain.Booking;
import com.mgv.libraryserver.backend.bookings.domain.vo.*;
import com.mgv.libraryserver.backend.bookings.infrastructure.dao.BookingDao;
import org.springframework.stereotype.Service;

@Service
public final class BookingMapper {
    public BookingDao booking2Dao(
            String uuid, String userId, String userName,
            String bookId, String bookTitle, String bookInternalId,
            String startDate, String endDate, String returnDate
    ){
        return new BookingDao(uuid, userId, userName, bookId, bookTitle, bookInternalId, startDate, endDate, returnDate);
    }

    public Booking dao2Booking(BookingDao dao){
        return new Booking(
                new BookingUuid(dao.getUuid()),
                new BookingUserId(dao.getUserId()),
                new BookingUserName(dao.getUserName()),
                new BookingBookId(dao.getBookId()),
                new BookingBookTitle(dao.getBookTitle()),
                new BookingBookInternalId(dao.getBookInternalId()),
                new BookingStartDate(dao.getStartDate()),
                new BookingEndDate(dao.getEndDate()),
                new BookingReturnDate(dao.getReturnDate())
        );
    }
}
