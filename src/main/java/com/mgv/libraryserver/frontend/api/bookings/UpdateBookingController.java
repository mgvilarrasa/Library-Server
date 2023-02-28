package com.mgv.libraryserver.frontend.api.bookings;

import com.mgv.libraryserver.backend.bookings.application.update.UpdateBookingCommand;
import com.mgv.libraryserver.frontend.api.bookings.requests.UpdateBookingRequest;
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
public class UpdateBookingController extends ApiController {
    public UpdateBookingController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @CrossOrigin
    @PutMapping(value = "/bookings/{uuid}")
    public ResponseEntity updateBooking(@PathVariable(value = "uuid") String uuid, @RequestBody UpdateBookingRequest request){
        Command command = new UpdateBookingCommand(
                uuid,
                request.getUserId(),
                request.getBookId(),
                request.getStartDate(),
                request.getEndDate());
        try{
            dispatch(command);
        } catch (Exception e){
            ResponseError error = ErrorMapper.mapDomainError(e);
            return new ResponseEntity<>(error.errorBody(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
