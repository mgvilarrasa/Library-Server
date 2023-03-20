package com.mgv.libraryserver.backend.users.infrastructure;

import com.mgv.libraryserver.backend.users.domain.User;
import com.mgv.libraryserver.backend.users.domain.UserRepository;
import com.mgv.libraryserver.backend.users.domain.vo.UserEmail;
import com.mgv.libraryserver.backend.users.domain.vo.UserUuid;
import com.mgv.libraryserver.backend.users.infrastructure.dao.UserDao;
import com.mgv.libraryserver.backend.users.infrastructure.dao.UserRepositoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class MySqlUserRepository implements UserRepository {
    private static Logger LOG = Logger.getLogger(String.valueOf(MySqlUserRepository.class));

    @Autowired
    private UserMapper mapper;
    @Autowired
    private UserRepositoryDao repositoryDao;

    @Override
    public void save(User user) {
        UserDao dao = mapper.user2Dao(
                user.uuid().value(), user.name().value(), user.lastName().value(), user.lastName2().value(), user.email().value(), user.internalId().value()
        );
        repositoryDao.save(dao);
    }

    @Override
    public Optional<User> searchById(UserUuid uuid) {
        Optional<UserDao> userDao =  repositoryDao.findById(uuid.value());
        return userDao.map(dao -> mapper.dao2User(dao));
    }

    @Override
    public Optional<User> searchByEmail(UserEmail email) {
        Optional<UserDao> userDao = repositoryDao.findByEmail(email.value());
        return userDao.map(dao -> mapper.dao2User(dao));
    }

    @Override
    public List<User> findAll() {
        return repositoryDao.findAll().stream().map(p -> mapper.dao2User(p)).collect(Collectors.toList());
    }

    @Override
    public void delete(UserUuid uuid) {
        repositoryDao.deleteById(uuid.value());
    }

    @Override
    public void deleteAll(){
        repositoryDao.deleteAll();
    }
}
