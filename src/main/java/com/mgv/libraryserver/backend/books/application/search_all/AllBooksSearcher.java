package com.mgv.libraryserver.backend.books.application.search_all;

import com.mgv.libraryserver.backend.books.application.response.BookResponse;
import com.mgv.libraryserver.backend.books.application.response.BooksResponse;
import com.mgv.libraryserver.backend.books.domain.BookRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class AllBooksSearcher {
    private final BookRepository repository;

    public AllBooksSearcher(BookRepository repository){
        this.repository = repository;
    }

    public BooksResponse findAll(){
        return new BooksResponse(repository.findAll().stream().map(BookResponse::fromAggregate).collect(Collectors.toList()));
    }
}
