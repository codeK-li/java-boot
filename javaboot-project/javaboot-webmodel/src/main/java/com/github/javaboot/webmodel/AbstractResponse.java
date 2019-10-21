package com.github.javaboot.webmodel;

public abstract class AbstractResponse<T> {

  /** 是否是成功的 Response */
  protected boolean success;
  /** Response 的消息体 */
  protected T body;

  public boolean isSuccess() {
    return success;
  }

  public T getBody() {
    return body;
  }
}
