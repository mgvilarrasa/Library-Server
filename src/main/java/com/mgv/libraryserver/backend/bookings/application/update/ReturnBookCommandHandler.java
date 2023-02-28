package com.mgv.libraryserver.backend.bookings.application.update;

import com.mgv.libraryserver.backend.bookings.domain.vo.BookingUuid;
import com.mgv.libraryserver.shared.domain.bus.CommandHandler;
import org.springframework.stereotype.Component;

@Component
public class ReturnBookCommandHandler implements CommandHandler<ReturnBookCommand> {
    private final BookingUpdater updater;

    public ReturnBookCommandHandler(BookingUpdater updater) {
        this.updater = updater;
    }

    @Override
    public void handle(ReturnBookCommand command) throws Exception {
        updater.returnBook(new BookingUuid(command.uuid()));
    }
}