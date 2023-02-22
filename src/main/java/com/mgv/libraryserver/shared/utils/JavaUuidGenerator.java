package com.mgv.libraryserver.shared.utils;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class JavaUuidGenerator implements UuidGenerator{
    @Override
    public String generate() {
        return UUID.randomUUID().toString();
    }
}
