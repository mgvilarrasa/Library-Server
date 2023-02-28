package com.mgv.libraryserver.backend.bookings.application.response;

import com.mgv.libraryserver.backend.bookings.domain.Booking;
import com.mgv.libraryserver.shared.domain.bus.Response;

public class BookingResponse implements Response {
    private final String uuid;
    private final String userId;
    private final String userName;
    private final String bookId;
    private final String bookTitle;
    private final String bookInternalId;
    private final String startDate;
    private final String endDate;
    private final String returnDate;

    public BookingResponse(
            String uuid, String userId, String userName,
            String bookId, String bookTitle, String bookInternalId,
            String startDate, String endDate, String returnDate
    ) {
        this.uuid = uuid;
        this.userId = userId;
        this.userName = userName;
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookInternalId = bookInternalId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.returnDate = returnDate;
    }

    public static BookingResponse fromAggregate(Booking booking){
        return new BookingResponse(
                booking.uuid().value(),
                booking.userId().value(),
                booking.userName().value(),
                booking.bookId().value(),
                booking.bookTitle().value(),
                booking.bookInternalId().value(),
                booking.startDate().value(),
                booking.endDate().value(),
                booking.returnDate().value()
        );
    }

    public String getUuid() {
        return uuid;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getBookId() {
        return bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public String getBookInternalId() {
        return bookInternalId;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getReturnDate() {
        return returnDate;
    }
}
