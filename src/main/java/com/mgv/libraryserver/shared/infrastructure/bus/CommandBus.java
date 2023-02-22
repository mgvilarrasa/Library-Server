package com.mgv.libraryserver.shared.infrastructure.bus;

import com.mgv.libraryserver.shared.domain.bus.Command;

public interface CommandBus {
    void dispatch(Command command) throws Exception;
}
