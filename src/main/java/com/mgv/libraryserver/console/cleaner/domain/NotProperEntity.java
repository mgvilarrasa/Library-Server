package com.mgv.libraryserver.console.cleaner.domain;

import com.mgv.libraryserver.shared.domain.DomainError;

public class NotProperEntity extends DomainError {
    public NotProperEntity(String entity) {
        super("not_proper_entity", "Entity <" + entity + "> not found");
    }
}
