package com.github.javaboot.err;

import lombok.Data;

/**
 * 错误消息对象
 *
 * @author OPO
 * @date 2019-10-24 17:34
 */
@Data
public class ErrorMessage {
  /** 未知错误Code */
  public static final int UNKNOWN_ERROR_CODE = 0;
  /** 错误Code */
  private int code = UNKNOWN_ERROR_CODE;
  /** 错误Message */
  private String message;
  /** 错误数据 */
  private Object payload;

  /**
   * 转换为 Exception 的 message
   *
   * @return
   */
  public String toExceptionMessage() {
    return String.format("[%s]%s", code, message);
  }
}