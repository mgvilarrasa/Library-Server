package com.mgv.libraryserver.shared.infrastructure.bus;

import com.mgv.libraryserver.shared.domain.bus.Query;

public interface QueryBus {
    <T> T ask(Query<T> query) throws Exception;
}
