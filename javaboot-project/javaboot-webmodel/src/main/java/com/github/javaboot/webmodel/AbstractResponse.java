package com.github.javaboot.webmodel;

/**
 * Response 的抽象类
 *
 * @author OPO
 * @date 2019-10-24 17:17
 */
public abstract class AbstractResponse<T> {
  /** 是否是成功的 Response */
  protected boolean success;
  /** Response 的消息体 */
  protected T body;
  /** 是否是成功的 Response */
  public boolean isSuccess() {
    return success;
  }

  /**
   * 获取 Response 的内容体。对于成功的 Response 此处是数据；对于失败的 Response 此处是 {@link ErrorMessage}
   *
   * @return
   */
  public T getBody() {
    return body;
  }
}
