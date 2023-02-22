package com.mgv.libraryserver.frontend.api.books;

import com.mgv.libraryserver.backend.books.application.create.CreateBookCommand;
import com.mgv.libraryserver.frontend.api.books.requests.CreateBookRequest;
import com.mgv.libraryserver.shared.domain.bus.Command;
import com.mgv.libraryserver.shared.infrastructure.ResponseError;
import com.mgv.libraryserver.shared.infrastructure.bus.CommandBus;
import com.mgv.libraryserver.shared.infrastructure.bus.QueryBus;
import com.mgv.libraryserver.shared.infrastructure.spring.ApiController;
import com.mgv.libraryserver.shared.utils.ErrorMapper;
import com.mgv.libraryserver.shared.utils.JavaUuidGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateBookController extends ApiController {
    @Autowired
    private JavaUuidGenerator uuidGenerator;

    public CreateBookController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @CrossOrigin
    @PostMapping(value = "/books")
    public ResponseEntity createBook(@RequestBody CreateBookRequest request){
        if(request.getUuid() == null || request.getUuid().isEmpty()){
            String newUuid = uuidGenerator.generate();
            request.setUuid(newUuid);
        }
        Command command = new CreateBookCommand(
                request.getUuid(),
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
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
