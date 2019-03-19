package com.rutkauskas.toDoBackend.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.rutkauskas.toDoBackend.model.Task;
import com.rutkauskas.toDoBackend.service.TaskService;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TaskControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private TaskController controller;

  @MockBean
  private TaskService taskService;

  @Test
  public void contextLoads() {
    assertThat(mockMvc).isNotNull();
  }

  @Test
  public void addTask() throws Exception {
    this.mockMvc.perform(post("/")
        .content("{ \"id \": \"868247e7-a6c0-4e95-9bac-da0c0bf8df30\", \"title\": \"testas\", \"archived\": false}")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }

  @Test
  public void getAllTasks() throws Exception {
    Task task = new Task(UUID.fromString("868247e7-a6c0-4e95-9bac-da0c0bf8df30"), "testas", false);

    List<Task> tasks = Arrays.asList(task);
    given(taskService.getAllTasks()).willReturn(tasks);

    this.mockMvc.perform(get("/"))
        .andExpect(status().isOk())
        .andExpect(content().json("[{'id': '868247e7-a6c0-4e95-9bac-da0c0bf8df30','title': 'testas','archived': false}]"));
  }

  @Test
  public void updateTask() throws Exception {
    this.mockMvc.perform(put("/868247e7-a6c0-4e95-9bac-da0c0bf8df30")
        .content("{\"archived\": true}")
        .contentType(MediaType.APPLICATION_JSON)
        .accept(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk());
  }
}