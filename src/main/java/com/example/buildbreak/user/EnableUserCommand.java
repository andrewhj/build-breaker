package com.example.buildbreak.user;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

/**
 * Command to enable users
 */
public class EnableUserCommand {
    @TargetAggregateIdentifier
    private final String userName;

    public EnableUserCommand(String userName) {
        this.userName = userName;
    }
}
