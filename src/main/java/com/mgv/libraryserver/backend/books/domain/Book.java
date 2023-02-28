package com.mgv.libraryserver.backend.books.domain;

import com.mgv.libraryserver.backend.books.domain.vo.*;

public final class Book {
    private final BookUuid uuid;
    private BookTitle title;
    private BookAuthor  author;
    private BookGenre genre;
    private BookEditorial editorial;
    private BookId bookId;
    private BookInternalId internalId;
    private BookBooking booking;

    public Book(
            BookUuid uuid, BookTitle title, BookAuthor author, BookGenre genre, BookEditorial editorial, BookId bookId, BookInternalId internalId, BookBooking booking
    ) {
        this.uuid = uuid;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.editorial = editorial;
        this.bookId = bookId;
        this.internalId = internalId;
        this.booking = booking;
    }

    public static Book create(BookUuid uuid, BookTitle title, BookAuthor author, BookGenre genre, BookEditorial editorial, BookId bookId, BookInternalId internalId){
        return new Book(uuid, title, author, genre, editorial, bookId, internalId, null);
    }

    public void update(BookTitle title, BookAuthor author, BookGenre genre, BookEditorial editorial, BookId bookId, BookInternalId internalId){
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.editorial = editorial;
        this.bookId = bookId;
        this.internalId = internalId;
    }

    public void createBooking(BookBooking booking){
        this.booking = booking;
    }

    public void bookReturned(){
        this.booking = new BookBooking(null);
    }

    public BookUuid uuid() {
        return uuid;
    }

    public BookTitle title() {
        return title;
    }

    public BookAuthor author() {
        return author;
    }

    public BookGenre genre() {
        return genre;
    }

    public BookEditorial editorial() {
        return editorial;
    }

    public BookId bookId() {
        return bookId;
    }

    public BookInternalId internalId() {
        return internalId;
    }

    public BookBooking booking() {
        return booking;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        Book book = (Book) obj;
        return uuid.equals(book.uuid) && title.equals(book.title) && author.equals(book.author) &&
                genre.equals(book.genre) && editorial.equals(book.editorial) && bookId.equals(book.bookId) && internalId.equals(book.internalId);
    }
}
