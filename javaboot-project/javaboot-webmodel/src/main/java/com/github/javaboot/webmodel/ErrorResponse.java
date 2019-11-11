package com.github.javaboot.webmodel;

/**
 * 失败的 {@link AbstractResponse Response}
 *
 * @author OPO
 * @see ErrorMessage
 */
public class ErrorResponse extends AbstractResponse<ErrorMessage> {
  public ErrorResponse() {
    this(new ErrorMessage());
  }

  public ErrorResponse(ErrorMessage errorMessage) {
    this.error = errorMessage == null ? new ErrorMessage() : errorMessage;
  }
}
