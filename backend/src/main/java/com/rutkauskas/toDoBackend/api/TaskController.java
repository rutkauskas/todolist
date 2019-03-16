package com.rutkauskas.toDoBackend.api;

import com.rutkauskas.toDoBackend.model.Task;
import com.rutkauskas.toDoBackend.service.TaskService;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

  @GetMapping("/")
  public List<Task> getAllTasks() {
    return taskService.getAllTasks();
  }

  @PutMapping(path = "/{id}")
  public void updateTask(@PathVariable("id") UUID id, @RequestBody Task taskToUpdate) {
    taskService.updateTask(id, taskToUpdate);
  }
}
