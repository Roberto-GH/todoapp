package com.rln.todoapp.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

  @org.springframework.web.bind.annotation.ExceptionHandler(value = {TodoAppException.class})
  protected ResponseEntity<Object> handleConflict(TodoAppException todoAppException, WebRequest webRequest) {
    String bodyOfResponse = todoAppException.getMessage();
    return handleExceptionInternal(todoAppException, bodyOfResponse, new HttpHeaders(), todoAppException.getHttpStatus(), webRequest);
  }

}
