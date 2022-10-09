package com.hemkant.springbootwithmongodb.repository;

import com.hemkant.springbootwithmongodb.module.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findBySeverity(int severity);

    @Query("{assigneeID:?0}")
    List<Task> findByAssigneeID(int assigneeID);
}
