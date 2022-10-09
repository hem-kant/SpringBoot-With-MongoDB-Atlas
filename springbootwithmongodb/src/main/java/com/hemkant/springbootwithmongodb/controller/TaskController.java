package com.hemkant.springbootwithmongodb.controller;


import com.hemkant.springbootwithmongodb.module.Task;
import com.hemkant.springbootwithmongodb.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Task createTask(@RequestBody Task task) {
        return  service.createTask(task);
    }

    @GetMapping
    public List<Task> getTasks(){
        return service.getAllTasks();
    }

    @GetMapping("/{taskID}")
    public  Task getTask( @PathVariable String taskID){
    return service.getTaskById(taskID);
    }

    @GetMapping("/serverity/{serverityId}")
    public  List<Task> findTaskBySeverity(int serverityId){
        return service.getTaskBySeverity(serverityId);
    }

    @GetMapping("assignee/{assigneeID}")
    public List<Task> getTaskByAssignee(@PathVariable int assigneeID){
        return service.getTaskByAssigneeID(assigneeID);
    }

    @PutMapping
    public Task ModifiyTask(@RequestBody Task task){
        return service.updateTask(task);
    }

    @DeleteMapping("/{taskID}")
    public String deleteTask(@PathVariable String taskID){
        return service.deleteTask(taskID);
    }

}
