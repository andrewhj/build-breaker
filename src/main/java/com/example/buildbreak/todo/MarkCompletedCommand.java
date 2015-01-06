package com.example.buildbreak.todo;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

/**
 * Command to mark a given item complete.
 */
public class MarkCompletedCommand {
    @TargetAggregateIdentifier
    private final String todoId;

    public MarkCompletedCommand(String todoId) {
        this.todoId = todoId;
    }

    public String getTodoId() {
        return todoId;
    }
}
