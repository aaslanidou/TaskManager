package com.example.TaskManager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.TaskManager.model.*;
import com.example.TaskManager.repository.TaskRepository;
import com.example.TaskManager.repository.UserRepository;

@Service
public class TaskService {
@Autowired
private TaskRepository taskRepository;

@Autowired
private UserRepository userRepository;

public Task creatTask(Long id,Task task){
    User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    task.setUser(user);
    return taskRepository.save(task);

}

public List<Task> getAllTasks(Long userId){
    return taskRepository.findByUser_Id(userId);
}



public void deleteTask(Long taskId) {
    if(!taskRepository.existsById(taskId)) throw new RuntimeException("task with id "+ taskId+ " does not exist");
    
    taskRepository.deleteById(taskId);
    
}

public Task updateNameTask(Long taskId,Task t){
    Task task = taskRepository.findById(taskId).orElseThrow(()-> new RuntimeException("task not found"));
    task.setName(t.getName());
    return taskRepository.save(task);
}

public Task updateStatusTask(Long taskId,Task t){
    Task task = taskRepository.findById(taskId).orElseThrow(()-> new RuntimeException("task not found"));
    task.setStatus(t.getStatus());
    return taskRepository.save(task);
}

public Task updateDescriptionTask(Long taskId, Task t){
    Task task = taskRepository.findById(taskId).orElseThrow(()-> new RuntimeException("Task not found"));
    task.setDescription(t.getDescription());
    return task;
}
}
