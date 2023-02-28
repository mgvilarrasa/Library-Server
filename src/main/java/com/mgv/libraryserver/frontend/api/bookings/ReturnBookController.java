package com.mgv.libraryserver.frontend.api.bookings;

import com.mgv.libraryserver.backend.bookings.application.find.FindBookingQuery;
import com.mgv.libraryserver.backend.bookings.application.response.BookingResponse;
import com.mgv.libraryserver.backend.bookings.application.update.ReturnBookCommand;
import com.mgv.libraryserver.backend.books.application.update.BookReturnedCommand;
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
public class ReturnBookController extends ApiController {
    public ReturnBookController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @CrossOrigin
    @PutMapping(value = "/bookings/{uuid}/return")
    public ResponseEntity returnBook(
            @PathVariable(value = "uuid") String uuid
    ){
        Command command = new ReturnBookCommand(uuid);
        try{
            dispatch(command);
            BookingResponse booking = ask(new FindBookingQuery(uuid));
            Command bookReturnedCommand = new BookReturnedCommand(booking.getBookId());
            dispatch(bookReturnedCommand);
        } catch (Exception e){
            ResponseError error = ErrorMapper.mapDomainError(e);
            return new ResponseEntity<>(error.errorBody(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
