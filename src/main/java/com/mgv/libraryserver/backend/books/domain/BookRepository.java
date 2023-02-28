package com.mgv.libraryserver.backend.books.domain;

import com.mgv.libraryserver.backend.books.domain.vo.BookBooking;
import com.mgv.libraryserver.backend.books.domain.vo.BookUuid;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    void save(Book book);
    Optional<Book> searchById(BookUuid uuid);
    List<Book> findAll();
    void delete(BookUuid uuid);
}
