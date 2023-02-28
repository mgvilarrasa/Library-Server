package com.mgv.libraryserver.backend.bookings.application.update;

import com.mgv.libraryserver.backend.bookings.domain.vo.BookingEndDate;
import com.mgv.libraryserver.backend.bookings.domain.vo.BookingUuid;
import com.mgv.libraryserver.shared.domain.bus.CommandHandler;
import org.springframework.stereotype.Component;

@Component
public class DelayReturnBookingCommandHandler implements CommandHandler<DelayReturnBookingCommand> {
    private final BookingUpdater updater;

    public DelayReturnBookingCommandHandler(BookingUpdater updater) {
        this.updater = updater;
    }

    @Override
    public void handle(DelayReturnBookingCommand command) throws Exception {
        updater.delayReturn(new BookingUuid(command.uuid()), new BookingEndDate(command.newEndDate()));
    }
}
