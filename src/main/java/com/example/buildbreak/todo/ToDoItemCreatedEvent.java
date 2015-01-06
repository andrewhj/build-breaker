package com.example.buildbreak.todo;

/**
 * Event to fire when work item is created.
 */
public class ToDoItemCreatedEvent {
    private final String todoId;
    private final String todoDescription;

    public ToDoItemCreatedEvent(String todoId,String todoDescription) {
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
