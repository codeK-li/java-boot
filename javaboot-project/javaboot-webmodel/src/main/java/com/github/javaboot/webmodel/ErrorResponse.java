package com.github.javaboot.webmodel;

public class ErrorResponse extends AbstractResponse<ErrorMessage> {
  public ErrorResponse() {
    super();
    this.success = false;
    this.body = new ErrorMessage();
  }

  public ErrorResponse(ErrorMessage errorMessage) {
    this();
    this.body = errorMessage;
  }
}
