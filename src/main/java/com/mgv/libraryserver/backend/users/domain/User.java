package com.mgv.libraryserver.backend.users.domain;

import com.mgv.libraryserver.backend.users.domain.exceptions.WrongEmailFormat;
import com.mgv.libraryserver.backend.users.domain.vo.*;

import java.util.regex.Pattern;

public final class User {
    private final static String REGEX_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    private final UserUuid uuid;
    private UserName name;
    private UserLastName lastName;
    private UserLastName2 lastName2;
    private UserEmail email;
    private UserInternalId internalId;

    public User(UserUuid uuid, UserName name, UserLastName lastName, UserLastName2 lastName2, UserEmail email, UserInternalId internalId) {
        this.uuid = uuid;
        this.name = name;
        this.lastName = lastName;
        this.lastName2 = lastName2;
        this.email = email;
        this.internalId = internalId;
    }

    public static User create(UserUuid uuid, UserName name, UserLastName lastName, UserLastName2 lastName2, UserEmail email, UserInternalId internalId){
        User user = new User(
                uuid, name, lastName, lastName2, email, internalId
        );
        validateEmail(email);
        return user;
    }

    public void update(UserName name, UserLastName lastName, UserLastName2 lastName2, UserEmail email, UserInternalId internalId){
        validateEmail(email);
        this.name = name;
        this.lastName = lastName;
        this.lastName2 = lastName2;
        this.email = email;
        this.internalId = internalId;
    }

    public UserUuid uuid() {
        return uuid;
    }

    public UserName name() {
        return name;
    }

    public UserLastName lastName() {
        return lastName;
    }

    public UserLastName2 lastName2() {
        return lastName2;
    }

    public UserEmail email() {
        return email;
    }

    public UserInternalId internalId() {
        return internalId;
    }

    private static void validateEmail(UserEmail email){
        Pattern pattern = Pattern.compile(REGEX_PATTERN);
        if(!pattern.matcher(email.value()).matches()){
            throw new WrongEmailFormat(email);
        }
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(obj == null || getClass() != obj.getClass()){
            return false;
        }
        User user = (User) obj;
        return uuid.equals(user.uuid) && name.equals(user.name) && lastName.equals(user.lastName) &&
                lastName2.equals(user.lastName2) && email.equals(user.email) && internalId.equals(user.internalId);
    }
}
