package com.mgv.libraryserver.backend.bookings.infrastructure.dao;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bookings")
public class BookingDao {
    @Id
    private String uuid;
    private String userId;
    private String userName;
    private String bookId;
    private String bookTitle;
    private String bookInternalId;
    private String startDate;
    private String endDate;
    private String returnDate;

    public BookingDao() {
    }

    public BookingDao(
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookInternalId() {
        return bookInternalId;
    }

    public void setBookInternalId(String bookInternalId) {
        this.bookInternalId = bookInternalId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }
}
