package com.rutkauskas.toDoBackend.service;

import com.rutkauskas.toDoBackend.dao.TaskDao;
import com.rutkauskas.toDoBackend.model.Task;

public class TaskService {

  private final TaskDao taskDao;

  public TaskService(TaskDao taskDao) {
    this.taskDao = taskDao;
  }

  public int addTask(Task task) {
    return taskDao.insertTask(task);
  }

}
