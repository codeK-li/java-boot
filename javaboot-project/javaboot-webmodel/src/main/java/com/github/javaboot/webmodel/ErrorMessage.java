package com.github.javaboot.webmodel;

import lombok.Data;

/**
 * 错误消息
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
  /** 错误消息 */
  private String message;
  /** 错误数据 */
  private Object payload;
}
