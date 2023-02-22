package com.mgv.libraryserver.frontend.api.books.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class CreateBookRequest {
    private String uuid;
    private String title;
    private String author;
    private String genre;
    private String editorial;
    private String bookId;
    private String internalId;

    public CreateBookRequest(String uuid, String title, String author, String genre, String editorial, String bookId, String internalId) {
        this.uuid = uuid;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.editorial = editorial;
        this.bookId = bookId;
        this.internalId = internalId;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getInternalId() {
        return internalId;
    }

    public void setInternalId(String internalId) {
        this.internalId = internalId;
    }
}
