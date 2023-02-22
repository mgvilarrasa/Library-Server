package com.mgv.libraryserver.backend.users.application.find;

import com.mgv.libraryserver.backend.users.application.response.UserResponse;
import com.mgv.libraryserver.shared.domain.bus.Query;

public final class FindUserQuery extends Query<UserResponse> {
    private final String uuid;

    public FindUserQuery(String uuid){
        this.uuid = uuid;
    }

    public String uuid(){
        return this.uuid;
    }
}
