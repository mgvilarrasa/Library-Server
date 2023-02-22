package com.mgv.libraryserver.backend.books.application.delete;

import com.mgv.libraryserver.backend.books.domain.Book;
import com.mgv.libraryserver.backend.books.domain.BookRepository;
import com.mgv.libraryserver.backend.books.domain.exceptions.BookNotExists;
import com.mgv.libraryserver.backend.books.domain.vo.BookUuid;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class BookDeleter {
    private static Logger LOG = Logger.getLogger(String.valueOf(BookDeleter.class));

    private final BookRepository repository;

    public BookDeleter(BookRepository repository){
        this.repository = repository;
    }

    public void deleteBook(BookUuid uuid) throws BookNotExists {
        Optional<Book> optBook = repository.searchById(uuid);
        if(optBook.isEmpty()) throw new BookNotExists(uuid);

        repository.delete(optBook.get().uuid());
    }
}
