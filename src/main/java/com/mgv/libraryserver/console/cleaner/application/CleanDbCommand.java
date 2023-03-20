package com.mgv.libraryserver.console.cleaner.application;

import com.mgv.libraryserver.shared.domain.bus.Command;

public class CleanDbCommand extends Command {
    private String entity;

    public CleanDbCommand(String entity) {
        this.entity = entity;
    }

    public String entity() {
        return entity;
    }
}
