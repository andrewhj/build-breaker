package com.example.buildbreak.user;

import org.axonframework.commandhandling.annotation.CommandHandler;
import org.axonframework.eventhandling.annotation.EventHandler;
import org.axonframework.eventsourcing.annotation.AbstractAnnotatedAggregateRoot;
import org.axonframework.eventsourcing.annotation.AggregateIdentifier;

/**
 * Aggregate to handle User processing.
 */
public class User extends AbstractAnnotatedAggregateRoot {
    private static final String BAD_CREDENTIALS = "Invalid username/password combination";
    private static final String SUSPENDED = "This account has been suspended/disabled";

    @AggregateIdentifier
    private String userName;
    private String password;

    private boolean enabled;

    public User() {

    }

    @CommandHandler
    public User(RegisterUserCommand command) {
        apply(new UserRegisteredEvent(command.getUserName(), command.getPassword()));
    }

    @EventHandler
    public void handle(UserRegisteredEvent event) {
        this.password = event.getPassword();
        this.userName = event.getUserName();
        this.enabled = true;
    }

    @CommandHandler
    public void disable(DisableUserCommand command) {
        if (enabled) {
            apply(new UserDisabledEvent(userName));
        }
    }

    @EventHandler
    public void handle(UserDisabledEvent event) {
        this.enabled = false;
    }

    @CommandHandler
    public void enable(EnableUserCommand command) {
        apply(new UserEnabledEvent(userName));
    }

    @EventHandler
    public void handle(UserEnabledEvent event) {
        enabled = true;
    }

    @CommandHandler
    public void authenticate(AuthenticateUserCommand command) throws AuthenticationFailedException {
        if (enabled && userName.equals(command.getUserName()) && password.equals(command.getPassword())) {
            apply(new UserAuthenticatedEvent(userName));
        } else {
            if (!userName.equals(command.getUserName()) || !password.equals(command.getPassword())) {
                throw new AuthenticationFailedException(BAD_CREDENTIALS);
            } else {
                throw new AuthenticationFailedException(SUSPENDED);
            }
        }
    }

    @CommandHandler
    public void changePassword(ChangePasswordCommand command) {
        if (userName.equals(command.getUserName()) && password.equals(command.getCurrentPass())) {
            apply(new PasswordChangedEvent(userName, command.getNewPass()));
        }
    }

    @EventHandler
    public void handle(PasswordChangedEvent event) {
        password = event.getPassword();
    }


}
