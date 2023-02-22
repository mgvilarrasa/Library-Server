package com.mgv.libraryserver.backend.users.application.response;

import com.mgv.libraryserver.shared.domain.bus.Response;

import java.util.List;

public class UsersResponse implements Response {
    private final List<UserResponse> users;

    public UsersResponse(List<UserResponse> users) {
        this.users = users;
    }

    public List<UserResponse> getUsers() {
        return users;
    }
}
