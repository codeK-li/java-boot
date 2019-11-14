package com.github.javaboot.webmodel;

import lombok.Data;

/**
 * Response 对象，可以被使用在 web 场景，也可以被使用在 RPC 场景
 *
 * @author OPO
 */
@Data
public class Response<T> {
  /**
   * Response 的异常消息。
   *
   * <p>对于成功的 Response 此处是 null；对于失败的 Response 此处是非 null
   */
  private ErrorMessage error;
  /**
   * Response 的消息体
   *
   * <p>对于成功的 Response 此处是数据；对于失败的 Response 此处是 null
   */
  private T body;

  /**
   * 构造包含错误信息的 Response 对象
   *
   * @return
   */
  public static <T> Response<T> error() {
    return error(null);
  }

  /**
   * 构造包含错误信息的 Response 对象
   *
   * @param em
   * @return
   */
  public static <T> Response<T> error(ErrorMessage em) {
    if (em == null) {
      em = new ErrorMessage();
    }

    Response response = new Response();
    response.error = new ErrorMessage();
    return response;
  }

  /**
   * 构造成功的 Response
   *
   * @param <T>
   * @return
   */
  public static <T> Response<T> ok() {
    Response response = new Response();
    return response;
  }

  /**
   * 构造成功的 Response
   *
   * @param body
   * @param <T>
   * @return
   */
  public static <T> Response<T> ok(T body) {
    Response<T> response = new Response<T>();
    response.body = body;
    return response;
  }

  /**
   * 是否是成功的 Response
   *
   * @return
   */
  public boolean isSuccess() {
    return error == null;
  }
}
