package com.example.buildbreak.user;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

/**
 * Command to perform user Authentication
 */
public class AuthenticateUserCommand {
    @TargetAggregateIdentifier
    private final String userName;
    private final String password;

    public AuthenticateUserCommand(String userName, String password) {
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
