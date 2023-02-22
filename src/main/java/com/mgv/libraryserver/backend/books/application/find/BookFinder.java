package com.mgv.libraryserver.backend.books.application.find;

import com.mgv.libraryserver.backend.books.application.response.BookResponse;
import com.mgv.libraryserver.backend.books.domain.BookRepository;
import com.mgv.libraryserver.backend.books.domain.exceptions.BookNotExists;
import com.mgv.libraryserver.backend.books.domain.vo.BookUuid;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class BookFinder {
    private final static Logger LOG = Logger.getLogger(String.valueOf(BookFinder.class));

    private final BookRepository repository;

    public BookFinder(BookRepository repository){
        this.repository = repository;
    }

    public BookResponse findById(BookUuid uuid) throws BookNotExists {
        return repository.searchById(uuid).map(BookResponse::fromAggregate).orElseThrow(() -> new BookNotExists(uuid));
    }
}
