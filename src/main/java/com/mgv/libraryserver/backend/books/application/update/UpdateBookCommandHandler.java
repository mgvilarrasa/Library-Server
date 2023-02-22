package com.mgv.libraryserver.backend.books.application.update;

import com.mgv.libraryserver.backend.books.domain.vo.*;
import com.mgv.libraryserver.shared.domain.bus.CommandHandler;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class UpdateBookCommandHandler implements CommandHandler<UpdateBookCommand> {
    private static Logger LOG = Logger.getLogger(String.valueOf(UpdateBookCommandHandler.class));

    private final BookUpdater updater;

    public UpdateBookCommandHandler(BookUpdater updater){
        this.updater = updater;
    }

    @Override
    public void handle(UpdateBookCommand command) throws Exception {
        BookUuid uuid = new BookUuid(command.uuid());
        BookTitle title = new BookTitle(command.title());
        BookAuthor author = new BookAuthor(command.author());
        BookGenre genre = new BookGenre(command.genre());
        BookEditorial editorial = new BookEditorial(command.editorial());
        BookId bookId = new BookId(command.bookId());
        BookInternalId internalId = new BookInternalId(command.internalId());

        updater.updateBook(uuid, title, author, genre, editorial, bookId, internalId);
    }
}
