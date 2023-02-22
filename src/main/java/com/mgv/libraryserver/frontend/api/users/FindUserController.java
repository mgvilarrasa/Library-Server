package com.mgv.libraryserver.frontend.api.users;

import com.mgv.libraryserver.backend.users.application.find.FindUserEmailQuery;
import com.mgv.libraryserver.backend.users.application.find.FindUserQuery;
import com.mgv.libraryserver.backend.users.application.response.UserResponse;
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
public class FindUserController extends ApiController {
    public FindUserController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @CrossOrigin
    @GetMapping(value = "/users/{uuid}")
    public ResponseEntity findUser(@PathVariable String uuid){
        try{
            UserResponse userResponse = ask(new FindUserQuery(uuid));
            return new ResponseEntity<>(userResponse, HttpStatus.OK);
        } catch (Exception e){
            ResponseError error = ErrorMapper.mapDomainError(e);
            return new ResponseEntity<>(error.errorBody(), HttpStatus.NOT_FOUND);
        }
    }

    @CrossOrigin
    @GetMapping(value = "/users/email/{email}")
    public ResponseEntity findUserByEmail(@PathVariable String email){
        try{
            UserResponse userResponse = ask(new FindUserEmailQuery(email));
            return new ResponseEntity<>(userResponse, HttpStatus.OK);
        } catch (Exception e){
            ResponseError error = ErrorMapper.mapDomainError(e);
            return new ResponseEntity<>(error.errorBody(), HttpStatus.NOT_FOUND);
        }
    }
}
