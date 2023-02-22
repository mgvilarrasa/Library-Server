package com.mgv.libraryserver.shared.infrastructure.spring;

import com.mgv.libraryserver.shared.domain.bus.Command;
import com.mgv.libraryserver.shared.domain.bus.Query;
import com.mgv.libraryserver.shared.infrastructure.bus.CommandBus;
import com.mgv.libraryserver.shared.infrastructure.bus.QueryBus;
import org.springframework.beans.factory.annotation.Autowired;

public class ApiController {
    @Autowired
    private QueryBus queryBus;
    @Autowired
    private CommandBus commandBus;

    public ApiController(QueryBus queryBus, CommandBus commandBus) {
        this.queryBus   = queryBus;
        this.commandBus = commandBus;
    }

    protected void dispatch(Command command) throws Exception {
        commandBus.dispatch(command);
    }

    protected <T> T ask(Query<T> query) throws Exception {
        return queryBus.ask(query);
    }
}
