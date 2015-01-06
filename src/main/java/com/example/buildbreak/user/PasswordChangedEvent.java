package com.example.buildbreak.user;


public class PasswordChangedEvent {
    private final String userName;
    private final String password;

    public PasswordChangedEvent(String userName, String password) {
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
