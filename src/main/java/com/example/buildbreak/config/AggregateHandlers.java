package com.example.buildbreak.config;

import com.example.buildbreak.user.User;
import com.example.buildbreak.todo.ToDoItem;
import org.axonframework.commandhandling.CommandBus;
import org.axonframework.commandhandling.annotation.AggregateAnnotationCommandHandler;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.commandhandling.gateway.CommandGatewayFactoryBean;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration file for Aggregate Command Handlers
 */
@Configuration
public class AggregateHandlers {
    @Bean
    public AggregateAnnotationCommandHandler<ToDoItem> toDoItemCommandHandler(EventSourcingRepository<ToDoItem> todoRepo, CommandBus commandBus) {
        return AggregateAnnotationCommandHandler.subscribe(ToDoItem.class, todoRepo, commandBus);
    }


    @Bean
    public AggregateAnnotationCommandHandler<User> userCommandHandler(EventSourcingRepository<User> userRepo, CommandBus commandBus) {
        return AggregateAnnotationCommandHandler.subscribe(User.class, userRepo, commandBus);
    }


    @Bean
    public CommandGatewayFactoryBean<CommandGateway> commandGatewayFactoryBean(CommandBus commandBus) {
        CommandGatewayFactoryBean<CommandGateway> commandGatewayFactoryBean = new CommandGatewayFactoryBean<>();
        commandGatewayFactoryBean.setCommandBus(commandBus);
        return commandGatewayFactoryBean;
    }
}
