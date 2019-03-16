package com.rutkauskas.toDoBackend.service;

import com.rutkauskas.toDoBackend.dao.TaskDao;
import com.rutkauskas.toDoBackend.model.Task;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

  private final TaskDao taskDao;

  @Autowired
  public TaskService(@Qualifier("fakeDao") TaskDao taskDao) {
    this.taskDao = taskDao;
  }

  public int addTask(Task task) {
    return taskDao.insertTask(task);
  }

  public List<Task> getAllTasks() {
    return taskDao.selectAllTasks();
  }
}
