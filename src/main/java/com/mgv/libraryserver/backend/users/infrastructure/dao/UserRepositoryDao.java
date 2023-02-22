package com.mgv.libraryserver.backend.users.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryDao extends JpaRepository<UserDao, String> {
    Optional<UserDao> findByEmail(String email);
}
