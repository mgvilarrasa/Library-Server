package com.mgv.libraryserver.backend.books.application.find;

import com.mgv.libraryserver.backend.books.application.response.BookResponse;
import com.mgv.libraryserver.shared.domain.bus.Query;

public class FindBookQuery extends Query<BookResponse> {
    private final String uuid;

    public FindBookQuery(String uuid){
        this.uuid = uuid;
    }

    public String uuid() {
        return uuid;
    }
}
