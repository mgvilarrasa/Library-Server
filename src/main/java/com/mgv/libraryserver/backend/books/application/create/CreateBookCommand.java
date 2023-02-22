package com.mgv.libraryserver.backend.books.application.create;

import com.mgv.libraryserver.shared.domain.bus.Command;

public class CreateBookCommand extends Command {
    private final String uuid;
    private final String title;
    private final String author;
    private final String genre;
    private final String editorial;
    private final String bookId;
    private final String internalId;

    public CreateBookCommand(String uuid, String title, String author, String genre, String editorial, String bookId, String internalId) {
        this.uuid = uuid;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.editorial = editorial;
        this.bookId = bookId;
        this.internalId = internalId;
    }

    public String uuid() {
        return uuid;
    }

    public String title() {
        return title;
    }

    public String author() {
        return author;
    }

    public String genre() {
        return genre;
    }

    public String editorial() {
        return editorial;
    }

    public String bookId() {
        return bookId;
    }

    public String internalId() {
        return internalId;
    }
}
