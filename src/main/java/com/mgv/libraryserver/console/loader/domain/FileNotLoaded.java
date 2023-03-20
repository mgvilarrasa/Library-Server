package com.mgv.libraryserver.console.loader.domain;

import com.mgv.libraryserver.shared.domain.DomainError;

public class FileNotLoaded extends DomainError {

    public FileNotLoaded() {
        super("file_not_loaded", "Books file not loaded properly");
    }
}
