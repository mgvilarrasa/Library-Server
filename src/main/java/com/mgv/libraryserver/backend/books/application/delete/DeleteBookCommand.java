package com.mgv.libraryserver.backend.books.application.delete;

import com.mgv.libraryserver.shared.domain.bus.Command;

public class DeleteBookCommand extends Command {
    private final String uuid;

    public DeleteBookCommand(String uuid) {
        this.uuid = uuid;
    }

    public String uuid() {
        return uuid;
    }
}
