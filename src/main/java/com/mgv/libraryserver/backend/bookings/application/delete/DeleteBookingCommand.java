package com.mgv.libraryserver.backend.bookings.application.delete;

import com.mgv.libraryserver.shared.domain.bus.Command;

public class DeleteBookingCommand extends Command {
    private final String uuid;

    public DeleteBookingCommand(String uuid){
        this.uuid = uuid;
    }

    public String uuid() {
        return uuid;
    }
}
