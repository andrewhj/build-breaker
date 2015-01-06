package com.example.buildbreak.user;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

/**
 *
 */
public class DisableUserCommand {
    @TargetAggregateIdentifier
    private final String userName;

    public DisableUserCommand(String userName) {
        this.userName = userName;
    }
}
