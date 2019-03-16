package com.rutkauskas.toDoBackend.dao;

import com.rutkauskas.toDoBackend.model.Task;
import java.util.UUID;

public interface TaskDao {

  int insertTask(UUID id, Task task);

  default int insertTask(Task task) {
    UUID id = UUID.randomUUID();
    return insertTask(id, task);
  }

}
