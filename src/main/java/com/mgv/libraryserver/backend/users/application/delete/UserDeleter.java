package com.mgv.libraryserver.backend.users.application.delete;

import com.mgv.libraryserver.backend.users.domain.User;
import com.mgv.libraryserver.backend.users.domain.UserRepository;
import com.mgv.libraryserver.backend.users.domain.exceptions.UserNotExists;
import com.mgv.libraryserver.backend.users.domain.vo.UserUuid;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public final class UserDeleter {
    private final static Logger LOG = Logger.getLogger(String.valueOf(UserDeleter.class));
    private final UserRepository repository;

    public UserDeleter(UserRepository repository){
        this.repository = repository;
    }

    public void deleteUser(UserUuid uuid) throws UserNotExists {
        Optional<User> optUser = repository.searchById(uuid);
        if(optUser.isEmpty()) throw new UserNotExists(uuid);

        repository.delete(optUser.get().uuid());
    }

    public void deleteAll() {
        repository.deleteAll();
    }
}
