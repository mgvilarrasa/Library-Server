package com.mgv.libraryserver.backend.users.application.response;

import com.mgv.libraryserver.backend.users.domain.User;
import com.mgv.libraryserver.shared.domain.bus.Response;

public final class UserResponse implements Response {
    private final String uuid;
    private final String name;
    private final String lastName;
    private final String lastName2;
    private final String email;
    private final String internalId;

    public UserResponse(String uuid, String name, String lastName, String lastName2, String email, String internalId) {
        this.uuid = uuid;
        this.name = name;
        this.lastName = lastName;
        this.lastName2 = lastName2;
        this.email = email;
        this.internalId = internalId;
    }

    public static UserResponse fromAggregate(User user){
        return new UserResponse(
                user.uuid().value(), user.name().value(), user.lastName().value(), user.lastName2().value(), user.email().value(), user.internalId().value()
        );
    }

    public String getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getLastName2() {
        return lastName2;
    }

    public String getEmail() {
        return email;
    }

    public String getInternalId() {
        return internalId;
    }
}
