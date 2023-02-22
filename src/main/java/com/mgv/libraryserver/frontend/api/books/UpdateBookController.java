package com.mgv.libraryserver.frontend.api.books;

import com.mgv.libraryserver.backend.books.application.update.UpdateBookCommand;
import com.mgv.libraryserver.frontend.api.books.requests.UpdateBookRequest;
import com.mgv.libraryserver.shared.domain.bus.Command;
import com.mgv.libraryserver.shared.infrastructure.ResponseError;
import com.mgv.libraryserver.shared.infrastructure.bus.CommandBus;
import com.mgv.libraryserver.shared.infrastructure.bus.QueryBus;
import com.mgv.libraryserver.shared.infrastructure.spring.ApiController;
import com.mgv.libraryserver.shared.utils.ErrorMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UpdateBookController extends ApiController {
    public UpdateBookController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @CrossOrigin
    @PutMapping(value = "/books/{uuid}")
    public ResponseEntity updateBook(@PathVariable(value = "uuid") String uuid, @RequestBody UpdateBookRequest request){
        Command command = new UpdateBookCommand(
                uuid,
                request.getTitle(),
                request.getAuthor(),
                request.getGenre(),
                request.getEditorial(),
                request.getBookId(),
                request.getInternalId());
        try{
            dispatch(command);
        } catch (Exception e){
            ResponseError error = ErrorMapper.mapDomainError(e);
            return new ResponseEntity<>(error.errorBody(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
