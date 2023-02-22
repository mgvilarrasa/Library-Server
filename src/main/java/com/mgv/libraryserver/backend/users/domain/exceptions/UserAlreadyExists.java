package com.mgv.libraryserver.backend.users.domain.exceptions;

import com.mgv.libraryserver.backend.users.domain.vo.UserUuid;
import com.mgv.libraryserver.shared.domain.DomainError;

public class UserAlreadyExists extends DomainError {

    public UserAlreadyExists(UserUuid uuid) {
        super("user_already_exists", String.format("The user <%s> already exist", uuid.value()));
    }
}
