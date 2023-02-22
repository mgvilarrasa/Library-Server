package com.mgv.libraryserver.shared.infrastructure;

import java.io.Serializable;
import java.util.HashMap;

public class ResponseError {
    private final HashMap<String, Serializable> errorBody;

    public ResponseError(HashMap<String, Serializable> errorBody) {
        this.errorBody = errorBody;
    }
    public HashMap<String, Serializable> errorBody() {
        return errorBody;
    }
}
