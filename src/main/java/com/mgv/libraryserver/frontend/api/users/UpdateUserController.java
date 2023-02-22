package com.mgv.libraryserver.frontend.api.users;

import com.mgv.libraryserver.backend.users.application.update.UpdateUserCommand;
import com.mgv.libraryserver.frontend.api.users.requests.UpdateUserRequest;
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
public class UpdateUserController extends ApiController {
    public UpdateUserController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @CrossOrigin
    @PutMapping(value = "/users/{uuid}")
    public ResponseEntity updateUser(@PathVariable(value = "uuid") String uuid, @RequestBody UpdateUserRequest request){
        Command command = new UpdateUserCommand(
                uuid,
                request.getName(),
                request.getLastName(),
                request.getLastName2(),
                request.getEmail(),
                request.getInternalId());
        try{
            dispatch(command);
        } catch (Exception e){
            ResponseError error = ErrorMapper.mapDomainError(e);
            return new ResponseEntity<>(error.errorBody(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
