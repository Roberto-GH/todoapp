package com.rln.todoapp.dto;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskInDto {

  private String title;
  private String description;
  private LocalDateTime eta;

}
