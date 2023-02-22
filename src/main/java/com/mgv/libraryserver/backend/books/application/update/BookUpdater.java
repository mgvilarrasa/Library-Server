package com.mgv.libraryserver.backend.books.application.update;

import com.mgv.libraryserver.backend.books.domain.Book;
import com.mgv.libraryserver.backend.books.domain.BookRepository;
import com.mgv.libraryserver.backend.books.domain.exceptions.BookNotExists;
import com.mgv.libraryserver.backend.books.domain.vo.*;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.logging.Logger;

@Service
public class BookUpdater {
    private final static Logger LOG = Logger.getLogger(String.valueOf(BookUpdater.class));
    private final BookRepository repository;

    public BookUpdater(BookRepository repository){
        this.repository = repository;
    }

    public void updateBook(
            BookUuid uuid,
            BookTitle title,
            BookAuthor author,
            BookGenre genre,
            BookEditorial editorial,
            BookId bookId,
            BookInternalId internalId
    ) throws BookNotExists {
        Optional<Book> optBook = repository.searchById(uuid);
        if(optBook.isEmpty()) throw new BookNotExists(uuid);
        Book book = optBook.get();
        book.update(title, author, genre, editorial, bookId, internalId);
        repository.save(book);
    }
}
