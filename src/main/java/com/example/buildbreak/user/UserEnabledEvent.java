package com.example.buildbreak.user;

/**
 * A user has been enabled
 */
public class UserEnabledEvent {
    private final String userName;

    public UserEnabledEvent(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
