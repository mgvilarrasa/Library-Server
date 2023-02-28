package com.mgv.libraryserver.frontend.api.bookings.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class CreateBookingRequest {
    private String uuid;
    private String userId;
    private String bookId;
    private String startDate;
    private String endDate;

    public CreateBookingRequest(String uuid, String userId, String bookId, String startDate, String endDate) {
        this.uuid = uuid;
        this.userId = userId;
        this.bookId = bookId;
        this.startDate = startDate;
        this.endDate = endDate;
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
}
