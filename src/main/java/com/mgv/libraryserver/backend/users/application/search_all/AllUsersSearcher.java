package com.mgv.libraryserver.backend.users.application.search_all;

import com.mgv.libraryserver.backend.users.application.response.UserResponse;
import com.mgv.libraryserver.backend.users.application.response.UsersResponse;
import com.mgv.libraryserver.backend.users.domain.UserRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public final class AllUsersSearcher {
    private final UserRepository repository;

    public AllUsersSearcher(UserRepository repository){
        this.repository = repository;
    }

    public UsersResponse findAll(){
        return new UsersResponse(repository.findAll().stream().map(UserResponse::fromAggregate).collect(Collectors.toList()));
    }
}
