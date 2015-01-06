package com.example.buildbreak.todo;

import org.axonframework.commandhandling.annotation.TargetAggregateIdentifier;

/**
 * command to request creation a work item.
 */
public class CreateToDoItemCommand {
    @TargetAggregateIdentifier
    private final String todoId;
    private final String todoDescription;

    public CreateToDoItemCommand(String todoId,String todoDescription) {
        this.todoId = todoId;
        this.todoDescription = todoDescription;
    }

    public String getTodoId() {
        return todoId;
    }

    public String getTodoDescription() {
        return todoDescription;
    }
}
