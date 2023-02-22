package com.mgv.libraryserver.backend.users.application.find;

import com.mgv.libraryserver.backend.users.application.response.UserResponse;
import com.mgv.libraryserver.backend.users.domain.UserRepository;
import com.mgv.libraryserver.backend.users.domain.exceptions.UserNotExists;
import com.mgv.libraryserver.backend.users.domain.vo.UserEmail;
import com.mgv.libraryserver.backend.users.domain.vo.UserUuid;
import org.springframework.stereotype.Service;

@Service
public final class UserFinder {
    private final UserRepository repository;

    public UserFinder(UserRepository repository){
        this.repository = repository;
    }

    public UserResponse findById(UserUuid uuid) throws UserNotExists {
        return repository.searchById(uuid).map(UserResponse::fromAggregate).orElseThrow(() -> new UserNotExists(uuid));
    }

    public UserResponse findByEmail(UserEmail email) throws UserNotExists {
        return repository.searchByEmail(email).map(UserResponse::fromAggregate).orElseThrow(() -> new UserNotExists(email));
    }
}
