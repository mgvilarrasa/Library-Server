package com.mgv.libraryserver.frontend.api.bookings;

import com.mgv.libraryserver.backend.bookings.application.delete.DeleteBookingCommand;
import com.mgv.libraryserver.shared.domain.bus.Command;
import com.mgv.libraryserver.shared.infrastructure.ResponseError;
import com.mgv.libraryserver.shared.infrastructure.bus.CommandBus;
import com.mgv.libraryserver.shared.infrastructure.bus.QueryBus;
import com.mgv.libraryserver.shared.infrastructure.spring.ApiController;
import com.mgv.libraryserver.shared.utils.ErrorMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteBookingController extends ApiController {
    public DeleteBookingController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @CrossOrigin
    @DeleteMapping(value = "/bookings/{uuid}")
    public ResponseEntity deleteBooking(@PathVariable String uuid){
        Command command = new DeleteBookingCommand(uuid);
        try{
            dispatch(command);
        } catch (Exception e){
            ResponseError error = ErrorMapper.mapDomainError(e);
            return new ResponseEntity<>(error.errorBody(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
