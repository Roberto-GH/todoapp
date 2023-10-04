package com.rln.todoapp.service;

import com.rln.todoapp.dto.TaskInDto;
import com.rln.todoapp.exceptions.TodoAppException;
import com.rln.todoapp.mapper.TaskInDtoToTask;
import com.rln.todoapp.persistence.entity.Task;
import com.rln.todoapp.persistence.entity.TaskStatus;
import com.rln.todoapp.persistence.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

  private final TaskRepository taskRepository;
  private final TaskInDtoToTask mapper;

  public TaskService(TaskRepository taskRepository, TaskInDtoToTask taskInDtoToTask) {
    this.taskRepository = taskRepository;
    this.mapper = taskInDtoToTask;
  }

  public Task createTask(TaskInDto taskInDto) {
    return taskRepository.save(mapper.map(taskInDto));
  }

  public List<Task> findAll() {
    return taskRepository.findAll();
  }

  public List<Task> findAllByTaskStatus(TaskStatus taskStatus) {
    return taskRepository.findAllByTaskStatus(taskStatus);
  }

  @Transactional
  public void markTaskAsFinished(Long id) {
    Optional<Task> optionalTask = taskRepository.findById(id);
    if (optionalTask.isEmpty())
      throw new TodoAppException("Task not found", HttpStatus.NOT_FOUND);
    taskRepository.markTaskAsFinished(id);
  }

  public void deleteById(Long id) {
    Optional<Task> optionalTask = taskRepository.findById(id);
    if (optionalTask.isEmpty())
      throw new TodoAppException("Task not found", HttpStatus.NOT_FOUND);
    taskRepository.deleteById(id);
  }

}
