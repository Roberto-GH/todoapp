package com.rln.todoapp.exceptions;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TodoAppException extends RuntimeException{

  private String message;
  private HttpStatus httpStatus;

}
