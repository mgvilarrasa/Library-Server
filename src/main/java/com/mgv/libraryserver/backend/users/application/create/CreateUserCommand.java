package com.mgv.libraryserver.backend.users.application.create;

import com.mgv.libraryserver.shared.domain.bus.Command;

public final class CreateUserCommand extends Command {
    private final String uuid;
    private final String name;
    private final String lastName;
    private final String lastName2;
    private final String email;
    private final String internalId;

    public CreateUserCommand(String uuid, String name, String lastName, String lastName2, String email, String internalId) {
        this.uuid = uuid;
        this.name = name;
        this.lastName = lastName;
        this.lastName2 = lastName2;
        this.email = email;
        this.internalId = internalId;
    }

    public String uuid() {
        return uuid;
    }

    public String name() {
        return name;
    }

    public String lastName() {
        return lastName;
    }

    public String lastName2() {
        return lastName2;
    }

    public String email() {
        return email;
    }

    public String internalId() {
        return internalId;
    }
}
