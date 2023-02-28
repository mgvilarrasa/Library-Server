package com.mgv.libraryserver.frontend.api.bookings;

import com.mgv.libraryserver.backend.bookings.application.create.CreateBookingCommand;
import com.mgv.libraryserver.backend.books.application.update.BookBookedCommand;
import com.mgv.libraryserver.frontend.api.bookings.requests.CreateBookingRequest;
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
public class CreateBookingController extends ApiController {
    @Autowired
    private JavaUuidGenerator uuidGenerator;

    public CreateBookingController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @CrossOrigin
    @PostMapping(value = "/bookings")
    public ResponseEntity createBooking(@RequestBody CreateBookingRequest request){
        if(request.getUuid() == null || request.getUuid().isEmpty()){
            String newUuid = uuidGenerator.generate();
            request.setUuid(newUuid);
        }
        Command command = new CreateBookingCommand(
                request.getUuid(),
                request.getUserId(),
                request.getBookId(),
                request.getStartDate(),
                request.getEndDate());
        try{
            dispatch(command);
            Command updateBookCommand = new BookBookedCommand(request.getBookId(), request.getUuid());
            dispatch(updateBookCommand);
        } catch (Exception e){
            ResponseError error = ErrorMapper.mapDomainError(e);
            return new ResponseEntity<>(error.errorBody(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
