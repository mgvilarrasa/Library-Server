package com.mgv.libraryserver.backend.users.application.update;

import com.mgv.libraryserver.backend.users.domain.User;
import com.mgv.libraryserver.backend.users.domain.UserRepository;
import com.mgv.libraryserver.backend.users.domain.exceptions.EmailAlreadyExists;
import com.mgv.libraryserver.backend.users.domain.exceptions.UserNotExists;
import com.mgv.libraryserver.backend.users.domain.exceptions.WrongEmailFormat;
import com.mgv.libraryserver.backend.users.domain.vo.*;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public final class UserUpdater {
    private final static Logger LOG = Logger.getLogger(String.valueOf(UserUpdater.class));

    private final UserRepository repository;

    public UserUpdater(UserRepository repository){
        this.repository = repository;
    }

    public void updateUser(
            UserUuid uuid,
            UserName name,
            UserLastName lastName,
            UserLastName2 lastName2,
            UserEmail email,
            UserInternalId internalId
    ) throws UserNotExists, EmailAlreadyExists, WrongEmailFormat {
        Optional<User> optUser = repository.searchById(uuid);
        if(optUser.isEmpty()) throw new UserNotExists(uuid);
        if(repository.searchByEmail(email).isPresent() && !optUser.get().email().value().equals(email.value())) throw new EmailAlreadyExists(email);
        User user = optUser.get();
        user.update(name, lastName, lastName2, email, internalId);
        repository.save(user);
    }
}
