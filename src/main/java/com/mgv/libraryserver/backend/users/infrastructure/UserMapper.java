package com.mgv.libraryserver.backend.users.infrastructure;

import com.mgv.libraryserver.backend.users.domain.User;
import com.mgv.libraryserver.backend.users.domain.vo.*;
import com.mgv.libraryserver.backend.users.infrastructure.dao.UserDao;
import org.springframework.stereotype.Service;

@Service
public final  class UserMapper {
    public UserDao user2Dao(String uuid, String name, String lastName, String lastName2, String email, String internalId){
        return new UserDao(uuid, name, lastName, lastName2, email, internalId);
    }

    public User dao2User(UserDao dao){
        return new User(
                new UserUuid(dao.getUuid()),
                new UserName(dao.getName()),
                new UserLastName(dao.getLastName()),
                new UserLastName2(dao.getLastName2()),
                new UserEmail(dao.getEmail()),
                new UserInternalId(dao.getInternalId())
        );
    }
}
