package com.example.TaskManager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.TaskManager.model.Task;
import com.example.TaskManager.service.TaskService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/user")
public class TaskController {
    @Autowired
    private TaskService taskService;

   
    @PostMapping("/{userId}/tasks")
    public ResponseEntity<Task> addTask(@PathVariable Long userId, @RequestBody Task task) {
        return ResponseEntity.ok(taskService.creatTask(userId, task));
    
    }

    @GetMapping("/{userId}/tasks")
  public ResponseEntity<List<Task>> getAllTasks(@PathVariable Long userId) {
    List<Task> tasks = taskService.getAllTasks(userId);
    return ResponseEntity.ok(tasks);
  }

   @DeleteMapping("/{userId}/tasks/{taskId}")
    public ResponseEntity<String> deleteTask(@PathVariable Long userId, @PathVariable Long taskId){
        taskService.deleteTask(taskId);
        return ResponseEntity.ok("task deleted");
    }

    @PutMapping("/{userId}/tasks/{taskId}/name")
    public ResponseEntity<Task> updateNameTask(@PathVariable Long userId, @PathVariable Long taskId,@RequestBody Task task) {
       Task t = taskService.updateNameTask(taskId,task);
       return ResponseEntity.ok(t);
    }

    @PutMapping("/{userId}/tasks/{taskId}/status")
    public ResponseEntity<Task> updateStatusTask(@PathVariable Long userId,@PathVariable Long taskId,@RequestBody Task task){
        Task t=taskService.updateStatusTask(taskId, task);
        return ResponseEntity.ok(t);
    }

    @PutMapping("/{userId}/tasks/{id}/descreption")
    public ResponseEntity<Task> updateDescriptionTask(@PathVariable Long userId,@PathVariable Long id,@RequestBody Task task){
        Task t= taskService.updateDescriptionTask(id, task);
        return ResponseEntity.ok(t);
    }
    

}
 

  
  
    


