package com.example.buildbreak.user;

/**
 * Created by ajohnson on 12/28/2014.
 */
public class UserDisabledEvent {
    private final String userName;

    public UserDisabledEvent(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
