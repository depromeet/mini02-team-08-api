package com.depromeet.donkey;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.HandlerMethod;

import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  @ExceptionHandler(value = IllegalArgumentException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ExceptionResponse exception(IllegalArgumentException exception, HttpServletRequest request, HandlerMethod handlerMethod) {
    log.error("[{}]/{} caught IllegalArgumentException[BAD_REQUEST]", handlerMethod.getBeanType(), handlerMethod.getMethod());
    return ExceptionResponse.create(
        HttpStatus.BAD_REQUEST.value(),
        HttpStatus.BAD_REQUEST.name(),
        exception.getMessage(),
        request.getRequestURL().toString()
    );
  }

  @ExceptionHandler(value = NoSuchElementException.class)
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  public ExceptionResponse exception(NoSuchElementException exception, HttpServletRequest request, HandlerMethod handlerMethod) {
    log.error("[{}]/{} caught NoSuchElementException[UNAUTHORIZED]", handlerMethod.getBeanType(), handlerMethod.getMethod());
    return ExceptionResponse.create(
        HttpStatus.UNAUTHORIZED.value(),
        HttpStatus.UNAUTHORIZED.name(),
        exception.getMessage(),
        request.getRequestURL().toString()
    );
  }
}
