package com.mgv.libraryserver.backend.books.application.response;

import com.mgv.libraryserver.backend.books.domain.Book;
import com.mgv.libraryserver.shared.domain.bus.Response;

public class BookResponse implements Response {
    private final String uuid;
    private final String title;
    private final String author;
    private final String genre;
    private final String editorial;
    private final String bookId;
    private final String internalId;

    public BookResponse(String uuid, String title, String author, String genre, String editorial, String bookId, String internalId) {
        this.uuid = uuid;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.editorial = editorial;
        this.bookId = bookId;
        this.internalId = internalId;
    }

    public static BookResponse fromAggregate(Book book){
        return new BookResponse(
                book.uuid().value(),
                book.title().value(),
                book.author().value(),
                book.genre().value(),
                book.editorial().value(),
                book.bookId().value(),
                book.internalId().value()
        );
    }

    public String getUuid() {
        return uuid;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getBookId() {
        return bookId;
    }

    public String getInternalId() {
        return internalId;
    }
}
