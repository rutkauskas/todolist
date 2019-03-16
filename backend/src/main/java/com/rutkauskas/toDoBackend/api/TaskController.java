package com.rutkauskas.toDoBackend.api;

import com.rutkauskas.toDoBackend.model.Task;
import com.rutkauskas.toDoBackend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

  private final TaskService taskService;

  @Autowired
  public TaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  @PostMapping("/")
  public void addTask(@RequestBody Task task) {
    taskService.addTask(task);
  }
}
