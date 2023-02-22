package com.mgv.libraryserver.backend.books.application.response;

import com.mgv.libraryserver.shared.domain.bus.Response;

import java.util.List;

public class BooksResponse implements Response {
    private final List<BookResponse> books;

    public BooksResponse(List<BookResponse> books){
        this.books = books;
    }

    public List<BookResponse> getBooks() {
        return books;
    }
}
