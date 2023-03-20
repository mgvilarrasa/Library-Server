package com.mgv.libraryserver.console.cleaner.application;

import com.mgv.libraryserver.shared.domain.bus.CommandHandler;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class CleanDbCommandHandler implements CommandHandler<CleanDbCommand> {
    private static Logger LOG = Logger.getLogger(String.valueOf(CleanDbCommandHandler.class));

    private DbCleaner cleaner;

    public CleanDbCommandHandler(DbCleaner cleaner){
        this.cleaner = cleaner;
    }

    @Override
    public void handle(CleanDbCommand command) throws Exception {
        cleaner.cleanDb(command.entity());
    }
}
