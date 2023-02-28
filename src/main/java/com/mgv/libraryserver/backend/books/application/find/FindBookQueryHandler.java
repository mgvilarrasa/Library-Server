package com.mgv.libraryserver.backend.books.application.find;

import com.mgv.libraryserver.backend.books.application.response.BookResponse;
import com.mgv.libraryserver.backend.books.domain.exceptions.BookNotExists;
import com.mgv.libraryserver.backend.books.domain.vo.BookUuid;
import com.mgv.libraryserver.shared.domain.bus.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class FindBookQueryHandler implements QueryHandler<BookResponse, FindBookQuery> {
    private final BookFinder finder;

    public FindBookQueryHandler(BookFinder finder){
        this.finder = finder;
    }

    @Override
    public BookResponse ask(FindBookQuery query) throws BookNotExists {
        return finder.findById(new BookUuid(query.uuid()));
    }
}
