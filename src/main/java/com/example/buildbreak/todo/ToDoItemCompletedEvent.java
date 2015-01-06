package com.example.buildbreak.todo;

/**
 * Created by ajohnson on 12/3/2014.
 */
public class ToDoItemCompletedEvent {
    private final String todoId;

    public ToDoItemCompletedEvent(String todoId) {

        this.todoId = todoId;
    }

    public String getTodoId() {
        return todoId;
    }

}
