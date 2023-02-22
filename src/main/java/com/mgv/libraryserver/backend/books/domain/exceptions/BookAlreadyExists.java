package com.mgv.libraryserver.backend.books.domain.exceptions;

import com.mgv.libraryserver.backend.books.domain.vo.BookUuid;
import com.mgv.libraryserver.shared.domain.DomainError;

public class BookAlreadyExists extends DomainError {
    public BookAlreadyExists(BookUuid uuid) {
        super("book_already_exists", String.format("The book <%s> already exist", uuid.value()));
    }
}
