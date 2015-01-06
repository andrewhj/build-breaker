package com.example.buildbreak.user;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

/**
 * Command for registering new users.
 */
public class RegisterUserCommand {
    @TargetAggregateIdentifier
    private final String userName;
    private final String password;

    public RegisterUserCommand(String userName, String password) {
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
