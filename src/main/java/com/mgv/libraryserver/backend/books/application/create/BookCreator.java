package com.mgv.libraryserver.backend.books.application.create;

import com.mgv.libraryserver.backend.books.domain.Book;
import com.mgv.libraryserver.backend.books.domain.BookRepository;
import com.mgv.libraryserver.backend.books.domain.exceptions.BookAlreadyExists;
import com.mgv.libraryserver.backend.books.domain.vo.*;
import org.springframework.stereotype.Service;
import java.util.logging.Logger;

@Service
public final class BookCreator {
    private final static Logger LOG = Logger.getLogger(String.valueOf(BookCreator.class));

    private BookRepository repository;

    public BookCreator(BookRepository repository){
        this.repository = repository;
    }

    public void createBook(
            BookUuid uuid,
            BookTitle title,
            BookAuthor author,
            BookGenre genre,
            BookEditorial editorial,
            BookId bookId,
            BookInternalId internalId
    ) throws BookAlreadyExists {
        if(repository.searchById(uuid).isPresent()){
            throw new BookAlreadyExists(uuid);
        }
        Book book = Book.create(uuid, title, author, genre, editorial, bookId, internalId);
        repository.save(book);
    }
}
