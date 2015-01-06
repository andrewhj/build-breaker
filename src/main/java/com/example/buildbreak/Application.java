package com.example.buildbreak;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.starter.axon.SimpleAxonConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@Import(value = {SimpleAxonConfiguration.class})
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);
//    @Autowired
//    private CommandGateway commandGateway;
//
//    @PostConstruct
//    public void createAdmin() {
//        final String itemId = UUID.randomUUID().toString();
//        commandGateway.send(new CreateToDoItemCommand(itemId, "Need to do this"));
////        commandGateway.send(new MarkCompletedCommand(itemId));
//
//    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
