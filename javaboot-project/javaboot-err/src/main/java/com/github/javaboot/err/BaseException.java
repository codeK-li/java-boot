package com.github.javaboot.err;

import lombok.Getter;

/**
 * 开发框架的基础异常类
 *
 * @author OPO
 */
public abstract class BaseException extends RuntimeException {
  @Getter private ErrorMessage errorMessage;

  public BaseException(ErrorMessage errorMessage) {
    super(errorMessage.toExceptionMessage());
    this.errorMessage = errorMessage;
  }

  public BaseException(ErrorMessage errorMessage, Throwable cause) {
    super(errorMessage.toExceptionMessage(), cause);
    this.errorMessage = errorMessage;
  }
}
