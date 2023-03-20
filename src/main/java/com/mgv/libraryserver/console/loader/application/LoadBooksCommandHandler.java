package com.mgv.libraryserver.console.loader.application;

import com.mgv.libraryserver.shared.domain.bus.CommandHandler;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class LoadBooksCommandHandler implements CommandHandler<LoadBooksCommand> {
    private static Logger LOG = Logger.getLogger(String.valueOf(LoadBooksCommandHandler.class));

    private final XlsxBookLoader loader;

    public LoadBooksCommandHandler(XlsxBookLoader loader) {
        this.loader = loader;
    }

    @Override
    public void handle(LoadBooksCommand command) throws Exception {
        loader.loadBooksFromXlsxFile(command.booksFile());
    }
}
