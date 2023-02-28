package com.mgv.libraryserver.backend.books.application.update;

import com.mgv.libraryserver.backend.books.domain.vo.BookUuid;
import com.mgv.libraryserver.shared.domain.bus.CommandHandler;
import org.springframework.stereotype.Component;

@Component
public class BookReturnedCommandHandler implements CommandHandler<BookReturnedCommand> {
    private final BookUpdater updater;

    public BookReturnedCommandHandler(BookUpdater updater) {
        this.updater = updater;
    }

    @Override
    public void handle(BookReturnedCommand command) throws Exception {
        updater.bookReturned(new BookUuid(command.uuid()));
    }
}
