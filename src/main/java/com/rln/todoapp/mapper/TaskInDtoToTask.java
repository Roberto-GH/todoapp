package com.rln.todoapp.mapper;

import com.rln.todoapp.dto.TaskInDto;
import com.rln.todoapp.persistence.entity.Task;
import com.rln.todoapp.persistence.entity.TaskStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskInDtoToTask implements Imapper<TaskInDto, Task> {

  @Override
  public Task map(TaskInDto taskInDto) {
    return Task
      .builder()
      .title(taskInDto.getTitle())
      .description(taskInDto.getDescription())
      .createDate(LocalDateTime.now())
      .eta(taskInDto.getEta())
      .finished(false)
      .taskStatus(TaskStatus.ON_TIME)
      .build();
  }

}
