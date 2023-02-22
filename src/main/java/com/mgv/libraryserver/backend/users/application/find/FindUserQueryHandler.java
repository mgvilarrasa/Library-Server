package com.mgv.libraryserver.backend.users.application.find;

import com.mgv.libraryserver.backend.users.application.response.UserResponse;
import com.mgv.libraryserver.backend.users.domain.exceptions.UserNotExists;
import com.mgv.libraryserver.backend.users.domain.vo.UserUuid;
import com.mgv.libraryserver.shared.domain.bus.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class FindUserQueryHandler implements QueryHandler<UserResponse, FindUserQuery> {
    private final UserFinder userFinder;

    public FindUserQueryHandler(UserFinder finder){
        this.userFinder = finder;
    }

    @Override
    public UserResponse ask(FindUserQuery query) throws UserNotExists {
        return userFinder.findById(new UserUuid(query.uuid()));
    }
}
