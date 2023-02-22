package com.mgv.libraryserver.backend.books.infrastructure.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepositoryDao extends JpaRepository<BookDao, String> {

}
