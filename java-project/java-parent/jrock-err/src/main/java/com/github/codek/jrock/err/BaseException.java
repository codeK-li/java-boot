package com.github.codek.jrock.err;

import lombok.Getter;

/**
 * 开发框架的基础异常类
 *
 * @author codeK
 */
public abstract class BaseException extends RuntimeException {
  /** 错误消息 */
  @Getter private ErrorMessage errorMessage;

  /**
   * 基础异常类的构造函数
   *
   * @param errorMessage 错误消息
   */
  public BaseException(ErrorMessage errorMessage) {
    super(errorMessage.toMessage());
    this.errorMessage = errorMessage;
  }

  /**
   * 基础异常类的构造函数
   *
   * @param errorMessage 错误消息
   * @param cause 异常
   */
  public BaseException(ErrorMessage errorMessage, Throwable cause) {
    super(errorMessage.toMessage(), cause);
    this.errorMessage = errorMessage;
  }

  /**
   * 获取异常等级
   *
   * @return 异常等级
   */
  public abstract int getExceptionLevel();
}
