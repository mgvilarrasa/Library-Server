package com.mgv.libraryserver.frontend.api.books;

import com.mgv.libraryserver.backend.books.application.find.FindBookQuery;
import com.mgv.libraryserver.backend.books.application.response.BookResponse;
import com.mgv.libraryserver.backend.books.application.response.BooksResponse;
import com.mgv.libraryserver.shared.infrastructure.ResponseError;
import com.mgv.libraryserver.shared.infrastructure.bus.CommandBus;
import com.mgv.libraryserver.shared.infrastructure.bus.QueryBus;
import com.mgv.libraryserver.shared.infrastructure.spring.ApiController;
import com.mgv.libraryserver.shared.utils.ErrorMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindBookController extends ApiController {
    public FindBookController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @CrossOrigin
    @GetMapping(value = "/books/{uuid}")
    public ResponseEntity findBook(@PathVariable String uuid){
        try{
            BookResponse bookResponse = ask(new FindBookQuery(uuid));
            return new ResponseEntity<>(bookResponse, HttpStatus.OK);
        } catch (Exception e){
            ResponseError error = ErrorMapper.mapDomainError(e);
            return new ResponseEntity<>(error.errorBody(), HttpStatus.NOT_FOUND);
        }
    }
}
