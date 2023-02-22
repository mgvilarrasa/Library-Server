package com.mgv.libraryserver.backend.users.domain;

import com.mgv.libraryserver.backend.users.domain.vo.UserEmail;
import com.mgv.libraryserver.backend.users.domain.vo.UserUuid;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    void save(User user);
    Optional<User> searchById(UserUuid uuid);
    Optional<User> searchByEmail(UserEmail email);
    List<User> findAll();
    void delete(UserUuid uuid);
}
