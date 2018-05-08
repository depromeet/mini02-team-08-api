package com.depromeet.donkey;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionResponse {
  Integer status;
  String error;
  String message;
  String path;
  Long timestamp;

  private ExceptionResponse(Integer status, String error, String message, String path) {
    this.status = status;
    this.error = error;
    this.message = message;
    this.path = path;
    this.timestamp = System.currentTimeMillis();
  }

  public static ExceptionResponse create(Integer status, String error, String message, String path) {
    return new ExceptionResponse(status, error, message, path);
  }
}
