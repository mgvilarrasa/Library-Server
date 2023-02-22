package com.mgv.libraryserver.backend.users.application.delete;

import com.mgv.libraryserver.backend.users.domain.vo.UserUuid;
import com.mgv.libraryserver.shared.domain.bus.CommandHandler;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class DeleteUserCommandHandler implements CommandHandler<DeleteUserCommand> {
    private static Logger LOG = Logger.getLogger(String.valueOf(DeleteUserCommandHandler.class));

    private final UserDeleter deleter;

    public DeleteUserCommandHandler(UserDeleter deleter){
        this.deleter = deleter;
    }

    @Override
    public void handle(DeleteUserCommand command) throws Exception {
        UserUuid uuid = new UserUuid(command.uuid());

        deleter.deleteUser(uuid);
    }
}
