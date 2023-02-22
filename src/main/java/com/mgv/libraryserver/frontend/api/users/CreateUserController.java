package com.mgv.libraryserver.frontend.api.users;

import com.mgv.libraryserver.backend.users.application.create.CreateUserCommand;
import com.mgv.libraryserver.frontend.api.users.requests.CreateUserRequest;
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
public class CreateUserController extends ApiController {
    @Autowired
    private JavaUuidGenerator uuidGenerator;

    public CreateUserController(QueryBus queryBus, CommandBus commandBus) {
        super(queryBus, commandBus);
    }

    @CrossOrigin
    @PostMapping(value = "/users")
    public ResponseEntity createUser(@RequestBody CreateUserRequest request){
        if(request.getUuid() == null || request.getUuid().isEmpty()){
            String newUuid = uuidGenerator.generate();
            request.setUuid(newUuid);
        }
        Command command = new CreateUserCommand(
                request.getUuid(),
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
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
