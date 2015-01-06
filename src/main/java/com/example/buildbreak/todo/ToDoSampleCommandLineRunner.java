package com.example.buildbreak.todo;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ToDoSampleCommandLineRunner implements CommandLineRunner {
    private static final Logger logger = LoggerFactory.getLogger(ToDoSampleCommandLineRunner.class);

    private CommandGateway commandGateway;

    public void createAdmin() {
        final String itemId = UUID.randomUUID().toString();
        logger.debug("creating todo item");
        commandGateway.send(new CreateToDoItemCommand(itemId, "Need to do this"));
        logger.debug("completing item");
        commandGateway.send(new MarkCompletedCommand(itemId));

    }

    @Autowired
    public ToDoSampleCommandLineRunner(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Creating events");
        createAdmin();
        logger.info("done");

    }
}
