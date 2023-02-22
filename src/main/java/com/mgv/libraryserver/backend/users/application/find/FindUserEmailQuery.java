package com.mgv.libraryserver.backend.users.application.find;

import com.mgv.libraryserver.backend.users.application.response.UserResponse;
import com.mgv.libraryserver.shared.domain.bus.Query;

public class FindUserEmailQuery extends Query<UserResponse> {
    private final String email;

    public FindUserEmailQuery(String email) {
        this.email = email;
    }

    public String email() {
        return email;
    }
}
