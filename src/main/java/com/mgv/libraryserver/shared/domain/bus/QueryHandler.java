package com.mgv.libraryserver.shared.domain.bus;

public interface QueryHandler <T, U extends Query<T>> {
    T ask(U query) throws Exception;
}
