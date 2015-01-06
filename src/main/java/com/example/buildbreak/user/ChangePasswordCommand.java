package com.example.buildbreak.user;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

/**
 * Created by ajohnson on 1/1/2015.
 */
public class ChangePasswordCommand {
    @TargetAggregateIdentifier
    private final String userName;
    private final String newPass;
    private final String currentPass;

    public ChangePasswordCommand(String userName, String currentPass, String newPass) {
        this.userName = userName;
        this.newPass = newPass;
        this.currentPass = currentPass;
    }

    public String getUserName() {
        return userName;
    }

    public String getNewPass() {
        return newPass;
    }

    public String getCurrentPass() {
        return currentPass;
    }
}
