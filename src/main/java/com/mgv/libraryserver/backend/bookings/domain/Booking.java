package com.mgv.libraryserver.backend.bookings.domain;

import com.mgv.libraryserver.backend.bookings.domain.exceptions.DatesNotCorrect;
import com.mgv.libraryserver.backend.bookings.domain.vo.*;
import com.mgv.libraryserver.shared.domain.DomainError;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Booking {
    private final BookingUuid uuid;
    private BookingUserId userId;
    private BookingUserName userName;
    private BookingBookId bookId;
    private BookingBookTitle bookTitle;
    private BookingBookInternalId bookInternalId;
    private BookingStartDate startDate;
    private BookingEndDate endDate;
    private BookingReturnDate returnDate;


    public Booking(
            BookingUuid uuid, BookingUserId userId, BookingUserName userName,
            BookingBookId bookId, BookingBookTitle bookTitle, BookingBookInternalId bookInternalId,
            BookingStartDate startDate, BookingEndDate endDate, BookingReturnDate returnDate
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

    public static Booking create(
            BookingUuid uuid, BookingUserId userId, BookingUserName userName,
            BookingBookId bookId, BookingBookTitle bookTitle, BookingBookInternalId bookInternalId,
            BookingStartDate startDate, BookingEndDate endDate, BookingReturnDate returnDate
    ){
        validateDate(startDate, endDate);
        return new Booking(uuid, userId, userName, bookId, bookTitle, bookInternalId, startDate, endDate, returnDate);
    }

    public void update(
            BookingUserId userId, BookingUserName userName,
            BookingBookId bookId, BookingBookTitle bookTitle, BookingBookInternalId bookInternalId,
            BookingStartDate startDate, BookingEndDate endDate
    ){
        validateDate(startDate, endDate);
        this.userId = userId;
        this.userName = userName;
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.bookInternalId = bookInternalId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public void returnBook(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        this.returnDate = new BookingReturnDate(df.format(new Date()));
    }

    public static void validateDate(BookingStartDate startDate, BookingEndDate endDate) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if(df.parse(startDate.value()).after(df.parse(endDate.value()))){
                throw new DatesNotCorrect();
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void delayReturn(BookingEndDate newEndDate){
        validateDate(this.startDate, newEndDate);
        this.endDate = newEndDate;
    }

    public BookingUuid uuid() {
        return uuid;
    }

    public BookingUserId userId() {
        return userId;
    }

    public BookingUserName userName() {
        return userName;
    }

    public BookingBookId bookId() {
        return bookId;
    }

    public BookingBookTitle bookTitle() {
        return bookTitle;
    }

    public BookingBookInternalId bookInternalId() {
        return bookInternalId;
    }

    public BookingStartDate startDate() {
        return startDate;
    }

    public BookingEndDate endDate() {
        return endDate;
    }

    public BookingReturnDate returnDate() {
        return returnDate;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        Booking booking = (Booking) obj;
        return uuid.equals(booking.uuid) && userId.equals(booking.userId)  && userName.equals(booking.userName)
                && bookId.equals(booking.bookId) && bookTitle.equals(booking.bookTitle) && bookInternalId.equals(booking.bookInternalId) &&
                startDate.equals(booking.startDate) && endDate.equals(booking.endDate) && returnDate.equals(booking.returnDate);
    }
}
