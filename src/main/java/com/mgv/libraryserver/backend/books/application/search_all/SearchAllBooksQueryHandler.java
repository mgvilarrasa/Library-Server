package com.mgv.libraryserver.backend.books.application.search_all;

import com.mgv.libraryserver.backend.books.application.response.BooksResponse;
import com.mgv.libraryserver.shared.domain.bus.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class SearchAllBooksQueryHandler implements QueryHandler<BooksResponse, SearchAllBooksQuery> {
    private final AllBooksSearcher searcher;

    public SearchAllBooksQueryHandler(AllBooksSearcher searcher){
        this.searcher = searcher;
    }

    @Override
    public BooksResponse ask(SearchAllBooksQuery query) throws Exception {
        return searcher.findAll();
    }
}
