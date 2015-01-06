package com.example.buildbreak.user;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Event handler for the various user events
 */
@Component
public class UserEventLogger {
    private final Logger logger = LoggerFactory.getLogger(UserEventLogger.class);
    @EventHandler
    public void handle(UserEnabledEvent event) {
        logger.info("User {} is enabled", event.getUserName());

    }

    @EventHandler
    public void handle(UserDisabledEvent event) {
        logger.info("User {} is disabled", event.getUserName());
    }

    @EventHandler
    public void handle(UserAuthenticatedEvent event) {
        logger.info("User {} logged in", event.getUserName());
    }

    @EventHandler
    public void handle(PasswordChangedEvent event) {
        logger.info("User {} password updated", event.getUserName());
    }
}
