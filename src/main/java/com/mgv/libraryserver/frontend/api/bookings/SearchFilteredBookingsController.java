package com.mgv.libraryserver.frontend.api.bookings;

import com.mgv.libraryserver.backend.bookings.application.response.BookingsResponse;
import com.mgv.libraryserver.backend.bookings.application.search_delayed.SearchDelayedBookingsQuery;
import com.mgv.libraryserver.backend.bookings.application.search_filtered.SearchFilteredBookingsQuery;
import com.mgv.libraryserver.shared.infrastructure.ResponseError;
import com.mgv.libraryserver.shared.infrastructure.bus.CommandBus;
import com.mgv.libraryserver.shared.infrastructure.bus.QueryBus;
import com.mgv.libraryserver.shared.infrastructure.spring.ApiController;
import com.mgv.libraryserver.shared.utils.ErrorMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchFilteredBookingsController extends ApiController {
    public SearchFilteredBookingsController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @CrossOrigin
    @GetMapping(value = "/bookings/filtered")
    public ResponseEntity searchFilteredBookings(
            @RequestParam(value = "userId", required = false) String userId,
            @RequestParam(value = "pending") Boolean pending
    ){
        try{
            BookingsResponse response = ask(new SearchFilteredBookingsQuery(userId, pending));
            return new ResponseEntity<>(response.getBookings(), HttpStatus.OK);
        } catch (Exception e){
            ResponseError error = ErrorMapper.mapDomainError(e);
            return new ResponseEntity<>(error.errorBody(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
