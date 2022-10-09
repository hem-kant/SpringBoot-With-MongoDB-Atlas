package com.hemkant.springbootwithmongodb.service;

import com.hemkant.springbootwithmongodb.module.Task;
import com.hemkant.springbootwithmongodb.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repository;

    public Task createTask(Task task){

        task.setTaskID(UUID.randomUUID().toString().split("-")[0]);
        return repository.save(task);

    }
    public List<Task> getAllTasks(){
        return repository.findAll();
    }

    public Task getTaskById(String taskID){
        return repository.findById(taskID).get();
    }

    public List<Task> getTaskBySeverity(int severity){
        return repository.findBySeverity(severity);
    }

    public List<Task> getTaskByAssigneeID(int assigneeID){
        return repository.findByAssigneeID(assigneeID);
    }

    public Task updateTask(Task taskRequest)
    {
        Task taskID= repository.findById(taskRequest.getTaskID()).get();
        taskID.setDescription(taskRequest.getDescription());
        taskID.setSeverity(taskRequest.getSeverity());
        taskID.setStoryPoint(taskRequest.getStoryPoint());
        taskID.setAssigneeID(taskRequest.getAssigneeID());
        return repository.save(taskID);
    }

    public String deleteTask(String taskID){
        repository.deleteById(taskID);
        return taskID+ " Task Deleted";
    }
}
