package com.mgv.libraryserver.frontend.api.bookings.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class UpdateBookingRequest {
    private String userId;
    private String bookId;
    private String startDate;
    private String endDate;
    private String returnDate;

    public UpdateBookingRequest(String userId, String bookId, String startDate, String endDate, String returnDate) {
        this.userId = userId;
        this.bookId = bookId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.returnDate = returnDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
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
