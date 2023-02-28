package com.mgv.libraryserver.backend.books.application.update;

import com.mgv.libraryserver.backend.books.domain.vo.BookBooking;
import com.mgv.libraryserver.backend.books.domain.vo.BookUuid;
import com.mgv.libraryserver.shared.domain.bus.CommandHandler;
import org.springframework.stereotype.Component;

@Component
public class BookBookedCommandHandler implements CommandHandler<BookBookedCommand> {
    private final BookUpdater updater;

    public BookBookedCommandHandler(BookUpdater updater) {
        this.updater = updater;
    }

    @Override
    public void handle(BookBookedCommand command) throws Exception {
        updater.createBooking(
                new BookUuid(command.uuid()),
                new BookBooking(command.booking())
        );
    }
}
