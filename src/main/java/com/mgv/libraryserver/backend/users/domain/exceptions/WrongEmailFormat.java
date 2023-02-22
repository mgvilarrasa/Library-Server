package com.mgv.libraryserver.backend.users.domain.exceptions;

import com.mgv.libraryserver.backend.users.domain.vo.UserEmail;
import com.mgv.libraryserver.shared.domain.DomainError;

public class WrongEmailFormat extends DomainError {
    public WrongEmailFormat(UserEmail email){
        super("wrong_error format", String.format("Email <%s> doesn't match correct pattern", email.value()));
    }
}
