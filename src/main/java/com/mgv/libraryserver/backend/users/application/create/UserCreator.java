package com.mgv.libraryserver.backend.users.application.create;

import com.mgv.libraryserver.backend.users.domain.User;
import com.mgv.libraryserver.backend.users.domain.UserRepository;
import com.mgv.libraryserver.backend.users.domain.exceptions.EmailAlreadyExists;
import com.mgv.libraryserver.backend.users.domain.exceptions.UserAlreadyExists;
import com.mgv.libraryserver.backend.users.domain.vo.*;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public final class UserCreator {
    private final static Logger LOG = Logger.getLogger(String.valueOf(UserCreator.class));
    private final UserRepository repository;

    public UserCreator(UserRepository repository){
        this.repository = repository;
    }

    public void createUser(
            UserUuid uuid, UserName name, UserLastName lastName, UserLastName2 lastName2, UserEmail email, UserInternalId internalId
    ){
        if(repository.searchById(uuid).isPresent()){
            throw new UserAlreadyExists(uuid);
        }
        if(repository.searchByEmail(email).isPresent()){
            throw new EmailAlreadyExists(email);
        }
        User user = User.create(uuid, name, lastName, lastName2, email, internalId);
        repository.save(user);
    }
}
