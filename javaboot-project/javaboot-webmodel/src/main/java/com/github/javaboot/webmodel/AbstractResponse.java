package com.github.javaboot.webmodel;

/**
 * Response 的抽象类
 *
 * @author OPO
 * @date 2019-10-24 17:17
 */
public abstract class AbstractResponse<T> {
  protected ErrorMessage error;
  /** Response 的消息体 */
  protected T body;
  /** 是否是成功的 Response */
  public boolean isSuccess() {
    return error == null;
  }

  /**
   * 获取 Response 的内容体。对于成功的 Response 此处是数据；对于失败的 Response 此处是 null
   *
   * @return
   */
  public T getBody() {
    return body;
  }

  /**
   * 获取 Response 的异常消息。对于成功的 Response 此处是 null；对于失败的 Response 此处是非 null
   *
   * @return
   */
  public ErrorMessage getError() {
    return error;
  }
}
