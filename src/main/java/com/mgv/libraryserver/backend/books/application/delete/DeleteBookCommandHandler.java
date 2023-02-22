package com.mgv.libraryserver.backend.books.application.delete;
import com.mgv.libraryserver.backend.books.domain.vo.*;
import com.mgv.libraryserver.shared.domain.bus.CommandHandler;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class DeleteBookCommandHandler implements CommandHandler<DeleteBookCommand> {
    private static Logger LOG = Logger.getLogger(String.valueOf(DeleteBookCommandHandler.class));

    private final BookDeleter deleter;

    public DeleteBookCommandHandler(BookDeleter deleter){
        this.deleter = deleter;
    }

    @Override
    public void handle(DeleteBookCommand command) throws Exception {
        BookUuid uuid = new BookUuid(command.uuid());

        deleter.deleteBook(uuid);
    }
}
