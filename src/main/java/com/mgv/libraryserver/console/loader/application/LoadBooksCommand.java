package com.mgv.libraryserver.console.loader.application;

import com.mgv.libraryserver.shared.domain.bus.Command;
import org.springframework.web.multipart.MultipartFile;

public class LoadBooksCommand extends Command {
    private MultipartFile booksFile;

    public LoadBooksCommand(MultipartFile booksFile) {
        this.booksFile = booksFile;
    }

    public MultipartFile booksFile() {
        return booksFile;
    }
}
