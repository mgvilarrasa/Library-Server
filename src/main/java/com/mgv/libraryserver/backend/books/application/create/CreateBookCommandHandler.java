package com.mgv.libraryserver.backend.books.application.create;

import com.mgv.libraryserver.backend.books.domain.vo.*;
import com.mgv.libraryserver.shared.domain.bus.CommandHandler;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class CreateBookCommandHandler implements CommandHandler<CreateBookCommand> {
    private static Logger LOG = Logger.getLogger(String.valueOf(CreateBookCommandHandler.class));

    private final BookCreator creator;

    public CreateBookCommandHandler(BookCreator creator){
        this.creator = creator;
    }
    @Override
    public void handle(CreateBookCommand command) throws Exception {
        BookUuid uuid = new BookUuid(command.uuid());
        BookTitle title = new BookTitle(command.title());
        BookAuthor author = new BookAuthor(command.author());
        BookGenre genre = new BookGenre(command.genre());
        BookEditorial editorial = new BookEditorial(command.editorial());
        BookId bookId = new BookId(command.bookId());
        BookInternalId internalId = new BookInternalId(command.internalId());

        creator.createBook(uuid, title, author, genre, editorial, bookId, internalId);
    }
}
