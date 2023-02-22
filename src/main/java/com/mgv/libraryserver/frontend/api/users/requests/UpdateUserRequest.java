package com.mgv.libraryserver.frontend.api.users.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
public class UpdateUserRequest {
    private String name;
    private String lastName;
    private String lastName2;
    private String email;
    private String internalId;

    public UpdateUserRequest(String name, String lastName, String lastName2, String email, String internalId) {
        this.name = name;
        this.lastName = lastName;
        this.lastName2 = lastName2;
        this.email = email;
        this.internalId = internalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName2() {
        return lastName2;
    }

    public void setLastName2(String lastName2) {
        this.lastName2 = lastName2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getInternalId() {
        return internalId;
    }

    public void setInternalId(String internalId) {
        this.internalId = internalId;
    }
}
