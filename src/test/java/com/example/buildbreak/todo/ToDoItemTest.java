package com.example.buildbreak.todo;

import org.axonframework.test.FixtureConfiguration;
import org.axonframework.test.Fixtures;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by ajohnson on 12/3/2014.
 */
public class ToDoItemTest {
    private FixtureConfiguration fixture;

    @Before
    public void setUp() {
        fixture = Fixtures.newGivenWhenThenFixture(ToDoItem.class);
    }

    @Test
    public void testCreateToDoItem() {
        fixture.given()
                .when(new CreateToDoItemCommand("todo1", "test implement"))
                .expectEvents(new ToDoItemCreatedEvent("todo1", "test implement"));
    }

    @Test
    public void testMarkToDoItemAsCompleted() {
        fixture.given(new ToDoItemCreatedEvent("todo1", "should be complete"))
                .when(new MarkCompletedCommand("todo1"))
                .expectEvents(new ToDoItemCompletedEvent("todo1"));
    }
}
