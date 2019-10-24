package com.github.javaboot.webmodel;

/**
 * 失败的 {@link AbstractResponse Response}
 *
 * @author OPO
 */
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
