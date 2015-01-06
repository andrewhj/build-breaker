package com.example.buildbreak.user;

/**
 * Created by ajohnson on 12/8/2014.
 */
public class UserRegisteredEvent {
    private final String userName;
    private final String password;

    public UserRegisteredEvent(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
