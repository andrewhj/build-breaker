package com.example.buildbreak.user;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.TreeMap;

@Component
public class UserSampleCommandLineRunner implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(UserSampleCommandLineRunner.class);

    private final CommandGateway commandGateway;

    private final Map<String, String> defaultUserList;



    @Autowired
    public UserSampleCommandLineRunner(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;

        this.defaultUserList = new TreeMap<>();
        defaultUserList.put("admin", "admin");
        defaultUserList.put("guest", "guest");
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Running User Samples");
        for (Map.Entry<String, String> userPair : defaultUserList.entrySet()) {
            commandGateway.send(new RegisterUserCommand(userPair.getKey(), userPair.getValue()));
        }

        log.info("attempt admin login:");
        commandGateway.send(new AuthenticateUserCommand("admin", "admin"));
        log.info("attempt bad account login:");
        commandGateway.send(new AuthenticateUserCommand("admin", "bad"));
        log.info("done");

    }
}
