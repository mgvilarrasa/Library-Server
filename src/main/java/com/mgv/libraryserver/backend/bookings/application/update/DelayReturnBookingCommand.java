package com.mgv.libraryserver.backend.bookings.application.update;

import com.mgv.libraryserver.shared.domain.bus.Command;

public class DelayReturnBookingCommand extends Command {
    private final String uuid;
    private final String newEndDate;

    public DelayReturnBookingCommand(String uuid, String newEndDate) {
        this.uuid = uuid;
        this.newEndDate = newEndDate;
    }

    public String uuid() {
        return uuid;
    }

    public String newEndDate() {
        return newEndDate;
    }
}
