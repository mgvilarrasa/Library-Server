package com.mgv.libraryserver.backend.users.application.update;

import com.mgv.libraryserver.backend.users.domain.vo.*;
import com.mgv.libraryserver.shared.domain.bus.CommandHandler;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class UpdateUserCommandHandler implements CommandHandler<UpdateUserCommand> {
    private static Logger LOG = Logger.getLogger(String.valueOf(UpdateUserCommandHandler.class));

    private final UserUpdater updater;

    public UpdateUserCommandHandler(UserUpdater updater){
        this.updater = updater;
    }

    @Override
    public void handle(UpdateUserCommand command) throws Exception {
        UserUuid uuid = new UserUuid(command.uuid());
        UserName name = new UserName(command.name());
        UserLastName lastName = new UserLastName(command.lastName());
        UserLastName2 lastName2 = new UserLastName2(command.lastName2());
        UserEmail email = new UserEmail(command.email());
        UserInternalId internalId = new UserInternalId(command.internalId());
        updater.updateUser(uuid, name, lastName, lastName2, email, internalId);
    }
}
