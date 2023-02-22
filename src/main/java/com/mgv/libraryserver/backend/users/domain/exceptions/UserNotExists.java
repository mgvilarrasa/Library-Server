package com.mgv.libraryserver.backend.users.domain.exceptions;

import com.mgv.libraryserver.backend.users.domain.vo.UserEmail;
import com.mgv.libraryserver.backend.users.domain.vo.UserUuid;
import com.mgv.libraryserver.shared.domain.DomainError;

public class UserNotExists extends DomainError {
    public UserNotExists(UserUuid uuid) {
        super("user_not_exists", String.format("The user <%s> doesn't exist", uuid.value()));
    }
    public UserNotExists(UserEmail email) {
        super("user_not_exists", String.format("User mail <%s> doesn't exist", email.value()));
    }
}
