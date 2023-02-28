package com.mgv.libraryserver.backend.bookings.application.create;

import com.mgv.libraryserver.shared.domain.bus.Command;

public class CreateBookingCommand extends Command {
    private final String uuid;
    private final String userId;
    private final String bookId;
    private final String startDate;
    private final String endDate;

    public CreateBookingCommand(String uuid, String userId, String bookId, String startDate, String endDate) {
        this.uuid = uuid;
        this.userId = userId;
        this.bookId = bookId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String uuid() {
        return uuid;
    }

    public String userId() {
        return userId;
    }

    public String bookId() {
        return bookId;
    }

    public String startDate() {
        return startDate;
    }

    public String endDate() {
        return endDate;
    }
}
