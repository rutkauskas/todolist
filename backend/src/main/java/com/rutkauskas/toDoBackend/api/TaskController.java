package com.rutkauskas.toDoBackend.api;

import com.rutkauskas.toDoBackend.model.Task;
import com.rutkauskas.toDoBackend.service.TaskService;

public class TaskController {

  private final TaskService taskService;

  public TaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  public void addTask(Task task) {
    taskService.addTask(task);
  }
}
