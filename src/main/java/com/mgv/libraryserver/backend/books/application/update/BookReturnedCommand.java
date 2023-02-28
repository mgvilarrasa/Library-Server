package com.mgv.libraryserver.backend.books.application.update;

import com.mgv.libraryserver.shared.domain.bus.Command;

public final class BookReturnedCommand extends Command {
    private final String uuid;

    public BookReturnedCommand(String uuid) {
        this.uuid = uuid;
    }

    public String uuid() {
        return uuid;
    }
}
