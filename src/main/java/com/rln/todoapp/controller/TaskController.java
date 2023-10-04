package com.rln.todoapp.controller;

import com.rln.todoapp.dto.TaskInDto;
import com.rln.todoapp.mapper.TaskInDtoToTask;
import com.rln.todoapp.persistence.entity.Task;
import com.rln.todoapp.persistence.entity.TaskStatus;
import com.rln.todoapp.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

  private final TaskService taskService;

  public TaskController(TaskService taskService) {
    this.taskService = taskService;
  }

  @PostMapping
  public Task createTask(@RequestBody TaskInDto taskInDto) {
    return taskService.createTask(taskInDto);
  }

  @GetMapping
  public List<Task> findAll() {
    return taskService.findAll();
  }

  @GetMapping("/status/{status}")
  public List<Task> findAllByTaskStatus(@PathVariable("status") TaskStatus taskStatus) {
    return taskService.findAllByTaskStatus(taskStatus);
  }

  @PatchMapping("/mark_as_finished/{id}")
  public ResponseEntity<Void> markTaskAsFinished(@PathVariable("id") Long id) {
    taskService.markTaskAsFinished(id);
    return ResponseEntity.noContent().build();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteById(@PathVariable("id") Long id) {
    taskService.deleteById(id);
    return ResponseEntity.noContent().build();
  }

}
