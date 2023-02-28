package com.mgv.libraryserver.frontend.api.bookings;

import com.mgv.libraryserver.backend.bookings.application.update.DelayReturnBookingCommand;
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
public class DelayReturnDateController extends ApiController {
    public DelayReturnDateController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @CrossOrigin
    @PutMapping(value = "/bookings/{uuid}/delay")
    public ResponseEntity delayBookingEndDate(@PathVariable(value = "uuid") String uuid, @RequestParam(value = "newEndDate") String newEndDate){
        Command command = new DelayReturnBookingCommand(uuid, newEndDate);
        try{
            dispatch(command);
        } catch (Exception e){
            ResponseError error = ErrorMapper.mapDomainError(e);
            return new ResponseEntity<>(error.errorBody(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
