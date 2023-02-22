package com.mgv.libraryserver.backend.books.domain.exceptions;

import com.mgv.libraryserver.backend.books.domain.vo.BookUuid;
import com.mgv.libraryserver.shared.domain.DomainError;

public class BookNotExists extends DomainError {
    public BookNotExists(BookUuid uuid) {
        super("book_not_exists", String.format("The book <%s> doesn't exist", uuid.value()));
    }
}
