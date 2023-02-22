package com.mgv.libraryserver.backend.books.infrastructure;

import com.mgv.libraryserver.backend.books.domain.Book;
import com.mgv.libraryserver.backend.books.domain.vo.*;
import com.mgv.libraryserver.backend.books.infrastructure.dao.BookDao;
import org.springframework.stereotype.Service;

@Service
public final class BookMapper {
    public BookDao book2Dao(String uuid, String title, String author, String genre, String editorial, String bookId, String internalId){
        return new BookDao(uuid, title, author, genre, editorial, bookId, internalId);
    }

    public Book dao2Book(BookDao dao){
        return new Book(
                new BookUuid(dao.getUuid()),
                new BookTitle(dao.getTitle()),
                new BookAuthor(dao.getAuthor()),
                new BookGenre(dao.getGenre()),
                new BookEditorial(dao.getEditorial()),
                new BookId(dao.getBookId()),
                new BookInternalId(dao.getInternalId())
        );
    }
}
