package com.mgv.libraryserver.backend.bookings.application.create;

import com.mgv.libraryserver.backend.bookings.domain.vo.*;
import com.mgv.libraryserver.shared.domain.bus.CommandHandler;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class CreateBookingCommandHandler implements CommandHandler<CreateBookingCommand> {
    private static Logger LOG = Logger.getLogger(String.valueOf(CreateBookingCommandHandler.class));

    private final BookingCreator creator;

    public CreateBookingCommandHandler(BookingCreator creator){
        this.creator = creator;
    }

    @Override
    public void handle(CreateBookingCommand command) throws Exception {
        BookingUuid uuid = new BookingUuid(command.uuid());
        BookingUserId userId = new BookingUserId(command.userId());
        BookingBookId bookId = new BookingBookId(command.bookId());
        BookingStartDate startDate = new BookingStartDate(command.startDate());
        BookingEndDate endDate = new BookingEndDate(command.endDate());

        creator.createBooking(uuid, userId, bookId, startDate, endDate);
    }
}
