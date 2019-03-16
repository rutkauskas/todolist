package com.rutkauskas.toDoBackend.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;

public class Task {

  private UUID id;
  private String title;
  private boolean archived;

  public Task(
      @JsonProperty("id") UUID id,
      @JsonProperty("title") String title,
      @JsonProperty("archived") boolean archived) {
    this.id = id;
    this.title = title;
    this.archived = archived;
  }

  public UUID getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public boolean isArchived() {
    return archived;
  }

  public void setArchived(boolean archived) {
    this.archived = archived;
  }
}
