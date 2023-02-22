package com.mgv.libraryserver.backend.users.application.delete;

import com.mgv.libraryserver.shared.domain.bus.Command;

public class DeleteUserCommand extends Command {
    private final String uuid;

    public DeleteUserCommand(String uuid) {
        this.uuid = uuid;
    }

    public String uuid() {
        return uuid;
    }
}
