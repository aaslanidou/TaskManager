package com.example.TaskManager.dto;

import com.example.TaskManager.model.Status;
import com.example.TaskManager.model.Task;

public class TaskMapper {
    //Task to DTO
  public TaskDTO toTaskDTO(Task task){
    return new TaskDTO(task.getId(),
                       task.getName(),
                       task.getDescription(),
                       task.getStatus().toString());
  }


    //DTO to Task
  public Task toTask(TaskDTO taskDTO){
    Task t = new Task();
    t.setName(taskDTO.name());
    t.setDescription(taskDTO.description());
    t.setStatus(Status.valueOf(taskDTO.status().toLowerCase()));
    return t;

  }  

}
