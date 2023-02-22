package com.mgv.libraryserver.frontend.api.books;

import com.mgv.libraryserver.backend.books.application.response.BooksResponse;
import com.mgv.libraryserver.backend.books.application.search_all.SearchAllBooksQuery;
import com.mgv.libraryserver.shared.infrastructure.ResponseError;
import com.mgv.libraryserver.shared.infrastructure.bus.CommandBus;
import com.mgv.libraryserver.shared.infrastructure.bus.QueryBus;
import com.mgv.libraryserver.shared.infrastructure.spring.ApiController;
import com.mgv.libraryserver.shared.utils.ErrorMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchAllBooksController extends ApiController {
    public SearchAllBooksController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @CrossOrigin
    @GetMapping(value = "/books")
    public ResponseEntity searchAllBooks(){
        try{
            BooksResponse response = ask(new SearchAllBooksQuery());
            return new ResponseEntity<>(response.getBooks(), HttpStatus.OK);
        } catch (Exception e){
            ResponseError error = ErrorMapper.mapDomainError(e);
            return new ResponseEntity<>(error.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }
}
