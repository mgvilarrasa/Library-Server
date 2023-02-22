package com.mgv.libraryserver.shared.utils;

import com.mgv.libraryserver.shared.domain.DomainError;
import com.mgv.libraryserver.shared.infrastructure.ResponseError;

import java.io.Serializable;
import java.util.HashMap;

public class ErrorMapper {
    public static ResponseError mapDomainError(Exception e){
        HashMap<String, Serializable> errorMap = new HashMap<>();
        if(e instanceof DomainError){
            errorMap.put("code", ((DomainError) e).errorCode());
            errorMap.put("message", ((DomainError) e).errorMessage());
            return new ResponseError(errorMap);
        }
        errorMap.put("code", "generic_error");
        errorMap.put("message", e.getMessage());
        return new ResponseError(errorMap);
    }
}
