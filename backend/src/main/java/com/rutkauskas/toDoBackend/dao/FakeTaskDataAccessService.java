package com.rutkauskas.toDoBackend.dao;

import com.rutkauskas.toDoBackend.model.Task;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository("fakeDao")
public class FakeTaskDataAccessService implements TaskDao {

  private static List<Task> DB = new ArrayList<>();

  @Override
  public int insertTask(UUID id, Task task) {
    DB.add(new Task(id, task.getTitle(), task.isArchived()));
    return 1;
  }
}
