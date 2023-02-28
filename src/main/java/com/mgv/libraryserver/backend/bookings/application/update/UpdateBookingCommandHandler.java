package com.mgv.libraryserver.backend.bookings.application.update;

import com.mgv.libraryserver.backend.bookings.domain.vo.*;
import com.mgv.libraryserver.shared.domain.bus.CommandHandler;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class UpdateBookingCommandHandler implements CommandHandler<UpdateBookingCommand> {
    private static Logger LOG = Logger.getLogger(String.valueOf(UpdateBookingCommandHandler.class));

    private final BookingUpdater updater;

    public UpdateBookingCommandHandler(BookingUpdater updater){
        this.updater = updater;
    }

    @Override
    public void handle(UpdateBookingCommand command) throws Exception {
        BookingUuid uuid = new BookingUuid(command.uuid());
        BookingUserId userId = new BookingUserId(command.userId());
        BookingBookId bookId = new BookingBookId(command.bookId());
        BookingStartDate startDate = new BookingStartDate(command.startDate());
        BookingEndDate endDate = new BookingEndDate(command.endDate());

        updater.updateBooking(uuid, userId, bookId, startDate, endDate);
    }
}
