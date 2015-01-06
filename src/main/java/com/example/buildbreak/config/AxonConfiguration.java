package com.example.buildbreak.config;

import com.example.buildbreak.user.User;
import com.example.buildbreak.todo.ToDoItem;
import org.axonframework.eventhandling.EventBus;
import org.axonframework.eventsourcing.EventCountSnapshotterTrigger;
import org.axonframework.eventsourcing.EventSourcingRepository;
import org.axonframework.eventsourcing.SnapshotterTrigger;
import org.axonframework.eventstore.EventStore;
import org.axonframework.eventstore.fs.EventFileResolver;
import org.axonframework.eventstore.fs.FileSystemEventStore;
import org.axonframework.eventstore.fs.SimpleEventFileResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

@Configuration
public class AxonConfiguration {
    private final Logger logger = LoggerFactory.getLogger(AxonConfiguration.class);

    @Bean
    EventStore eventStore(@Value("${axon.eventStore.file}") String eventStoreLocation) {
        File baseDir = new File(eventStoreLocation);
        if (!baseDir.exists()) {
            baseDir.mkdir();
            logger.info("creating Event store directory: {}", baseDir.toPath().toString());
        }
        final EventFileResolver eventFileResolver = new SimpleEventFileResolver(baseDir);
        return new FileSystemEventStore(eventFileResolver);
    }

    @Bean
    EventSourcingRepository<ToDoItem> toDoRepository(EventStore eventStore, EventBus eventBus) {
        final EventSourcingRepository<ToDoItem> repository = new EventSourcingRepository<ToDoItem>(ToDoItem.class, eventStore);
        repository.setEventBus(eventBus);
        return repository;
    }

    @Bean
    SnapshotterTrigger snapshotterTrigger() {
        final EventCountSnapshotterTrigger snapshotter = new EventCountSnapshotterTrigger();
        snapshotter.setTrigger(10);
        return snapshotter;
    }

    @Bean
    EventSourcingRepository<User> userRepository(EventStore eventStore, EventBus eventBus, SnapshotterTrigger snapshotterTrigger) {
        EventSourcingRepository<User> userEventSourcingRepository = new EventSourcingRepository<>(User.class, eventStore);
        userEventSourcingRepository.setEventBus(eventBus);
        userEventSourcingRepository.setSnapshotterTrigger(snapshotterTrigger);
        return userEventSourcingRepository;
    }
}
