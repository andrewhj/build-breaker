package com.example.buildbreak.user;

/**
 * Created by ajohnson on 1/1/2015.
 */
public class UserAuthenticatedEvent {
    private final String userName;

    public UserAuthenticatedEvent(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
