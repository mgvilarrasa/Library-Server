package com.mgv.libraryserver.backend.users.application.create;

import com.mgv.libraryserver.backend.users.domain.vo.*;
import com.mgv.libraryserver.shared.domain.bus.CommandHandler;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class CreateUserCommandHandler implements CommandHandler<CreateUserCommand> {
    private static Logger LOG = Logger.getLogger(String.valueOf(CreateUserCommandHandler.class));
    private final UserCreator userCreator;
    public CreateUserCommandHandler(UserCreator creator){
        this.userCreator = creator;
    }

    @Override
    public void handle(CreateUserCommand command) throws Exception {
        UserUuid uuid = new UserUuid(command.uuid());
        UserName name = new UserName(command.name());
        UserLastName lastName = new UserLastName(command.lastName());
        UserLastName2 lastName2 = new UserLastName2(command.lastName2());
        UserEmail email = new UserEmail(command.email());
        UserInternalId internalId = new UserInternalId(command.internalId());
        userCreator.createUser(uuid, name, lastName, lastName2, email, internalId);
    }
}
