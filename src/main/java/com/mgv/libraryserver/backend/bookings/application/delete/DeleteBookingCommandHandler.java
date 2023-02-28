package com.mgv.libraryserver.backend.bookings.application.delete;

import com.mgv.libraryserver.backend.bookings.domain.vo.BookingUuid;
import com.mgv.libraryserver.shared.domain.bus.CommandHandler;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class DeleteBookingCommandHandler implements CommandHandler<DeleteBookingCommand> {
    private static Logger LOG = Logger.getLogger(String.valueOf(DeleteBookingCommandHandler.class));

    private BookingDeleter deleter;

    public DeleteBookingCommandHandler(BookingDeleter deleter) {
        this.deleter = deleter;
    }

    @Override
    public void handle(DeleteBookingCommand command) throws Exception {
        BookingUuid uuid = new BookingUuid(command.uuid());
        deleter.deleteBooking(uuid);
    }
}
