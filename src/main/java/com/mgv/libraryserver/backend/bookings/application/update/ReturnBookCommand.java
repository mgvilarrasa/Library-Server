package com.mgv.libraryserver.backend.bookings.application.update;

import com.mgv.libraryserver.shared.domain.bus.Command;

public class ReturnBookCommand extends Command {
    private final String uuid;

    public ReturnBookCommand(String uuid) {
        this.uuid = uuid;
    }

    public String uuid() {
        return uuid;
    }
}
