package com.example.buildbreak.user;

import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;

public class UserTest {
    private FixtureConfiguration fixture;

    @Before
    public void setUp() {
        fixture = Fixtures.newGivenWhenThenFixture(User.class);
    }

    @Test
    public void registerUser() {
        fixture.given()
                .when(new RegisterUserCommand("test", "testpass"))
                .expectEvents(new UserRegisteredEvent("test", "testpass"));
    }

    @Test
    public void disableUser() {
        fixture.given(new UserRegisteredEvent("test", "test"))
                .when(new DisableUserCommand("test"))
                .expectEvents(new UserDisabledEvent("test"));
    }

    @Test
    public void disableUserOnlyHappensOnce() {
        fixture.given(new UserRegisteredEvent("double", "tap"), new UserDisabledEvent("double"))
                .when(new DisableUserCommand("double"))
                .expectEvents();
    }

    @Test
    public void enableUser() {
        fixture.given(new UserRegisteredEvent("reenable", "test"), new UserDisabledEvent("reenable"))
                .when(new EnableUserCommand("reenable"))
                .expectEvents(new UserEnabledEvent("reenable"));
    }

    @Test
    public void authenticateUser() {
        fixture.given(new UserRegisteredEvent("test", "test"))
                .when(new AuthenticateUserCommand("test", "test"))
                .expectEvents(new UserAuthenticatedEvent("test"));
    }

    @Test
    public void failedAuthentication() {
        fixture.given(new UserRegisteredEvent("test", "test"))
                .when(new AuthenticateUserCommand("test", "password"))
                .expectException(AuthenticationFailedException.class);
    }

    @Test
    public void goodCredentialsDisabledAccountShouldThrowWithDisabledMessage() {
        fixture.given(new UserRegisteredEvent("test", "test"), new UserDisabledEvent("test"))
                .when(new AuthenticateUserCommand("test", "test"))
                .expectException(AuthenticationFailedException.class);
    }

    @Test
    public void changePassword() {
        fixture.given(new UserRegisteredEvent("test", "test"))
                .when(new ChangePasswordCommand("test", "test", "pass"))
                .expectEvents(new PasswordChangedEvent("test", "pass"));
    }
}
