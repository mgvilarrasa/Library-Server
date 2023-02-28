package com.mgv.libraryserver.backend.books.application.update;

import com.mgv.libraryserver.shared.domain.bus.Command;

public final class BookBookedCommand extends Command {
    private final String uuid;
    private final String booking;

    public BookBookedCommand(String uuid, String booking) {
        this.uuid = uuid;
        this.booking = booking;
    }

    public String uuid() {
        return uuid;
    }

    public String booking() {
        return booking;
    }
}
