package com.mgv.libraryserver.frontend.api.users;

import com.mgv.libraryserver.backend.users.application.response.UsersResponse;
import com.mgv.libraryserver.backend.users.application.search_all.SearchAllUsersQuery;
import com.mgv.libraryserver.shared.infrastructure.ResponseError;
import com.mgv.libraryserver.shared.infrastructure.bus.CommandBus;
import com.mgv.libraryserver.shared.infrastructure.bus.QueryBus;
import com.mgv.libraryserver.shared.infrastructure.spring.ApiController;
import com.mgv.libraryserver.shared.utils.ErrorMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchAllUsersController extends ApiController {
    public SearchAllUsersController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @CrossOrigin
    @GetMapping(value = "/users")
    public ResponseEntity searchAllUsers(){
        try{
            UsersResponse response = ask(new SearchAllUsersQuery());
            return new ResponseEntity<>(response.getUsers(), HttpStatus.OK);
        } catch (Exception e){
            ResponseError error = ErrorMapper.mapDomainError(e);
            return new ResponseEntity<>(error.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }
}
