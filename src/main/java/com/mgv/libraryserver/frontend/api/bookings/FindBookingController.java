package com.mgv.libraryserver.frontend.api.bookings;

import com.mgv.libraryserver.backend.bookings.application.find.FindBookingQuery;
import com.mgv.libraryserver.backend.bookings.application.response.BookingResponse;
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
public class FindBookingController extends ApiController {
    public FindBookingController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @CrossOrigin
    @GetMapping(value = "/bookings/{uuid}")
    public ResponseEntity findBooking(@PathVariable String uuid){
        try{
            BookingResponse bookingResponse = ask(new FindBookingQuery(uuid));
            return new ResponseEntity<>(bookingResponse, HttpStatus.OK);
        } catch (Exception e){
            ResponseError error = ErrorMapper.mapDomainError(e);
            return new ResponseEntity<>(error.errorBody(), HttpStatus.NOT_FOUND);
        }
    }
}
