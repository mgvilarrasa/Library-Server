package com.mgv.libraryserver.backend.users.application.find;

import com.mgv.libraryserver.backend.users.application.response.UserResponse;
import com.mgv.libraryserver.backend.users.domain.exceptions.UserNotExists;
import com.mgv.libraryserver.backend.users.domain.vo.UserEmail;
import com.mgv.libraryserver.shared.domain.bus.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class FindUserEmailQueryHandler implements QueryHandler<UserResponse, FindUserEmailQuery> {
    private final UserFinder userFinder;

    public FindUserEmailQueryHandler(UserFinder finder){
        this.userFinder = finder;
    }

    @Override
    public UserResponse ask(FindUserEmailQuery query) throws UserNotExists {
        return userFinder.findByEmail(new UserEmail(query.email()));
    }
}
