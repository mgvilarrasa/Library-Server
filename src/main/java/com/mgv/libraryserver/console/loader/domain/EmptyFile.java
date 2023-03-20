package com.mgv.libraryserver.console.loader.domain;

import com.mgv.libraryserver.shared.domain.DomainError;

public class EmptyFile extends DomainError {
    public EmptyFile() {
        super("empty_file", "Books file is empty. No books to import");
    }
}
