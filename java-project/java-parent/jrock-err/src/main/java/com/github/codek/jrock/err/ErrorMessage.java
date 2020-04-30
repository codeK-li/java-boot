package com.github.codek.jrock.err;

import lombok.Data;

/**
 * 错误消息对象
 *
 * @author codeK
 * @since 2019-10-24 17:34
 */
@Data
public class ErrorMessage {
  /** 错误Code */
  private String code = "UNKNOWN";
  /** 错误Message */
  private String message;
  /** 错误数据 */
  private Object payload;

  /**
   * 转换为 Exception 的 message
   *
   * @return message 的字符串
   */
  public String toMessage() {
    return String.format("[%s]%s", code, message);
  }
}
