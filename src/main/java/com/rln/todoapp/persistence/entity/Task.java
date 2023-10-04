package com.rln.todoapp.persistence.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "task")
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String title;
  private String description;
  private LocalDateTime createDate;
  private LocalDateTime eta;
  private boolean finished;
  private TaskStatus taskStatus;

}
