package com.example.buildbreak.todo;

import org.axonframework.eventhandling.annotation.EventHandler;
import org.springframework.stereotype.Component;

@Component
public class ToDoEventHandler {
    @EventHandler
    public void handle(ToDoItemCreatedEvent event) {
        System.out.print("item created ");
        System.out.println(event.getTodoDescription());
    }

    @EventHandler
    public void handle(ToDoItemCompletedEvent event) {
        System.out.println("completed item ");
        System.out.println(event.getTodoId());

    }
}
