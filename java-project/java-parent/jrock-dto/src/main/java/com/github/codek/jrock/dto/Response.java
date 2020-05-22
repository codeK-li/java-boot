package com.github.codek.jrock.dto;

import com.github.codek.jrock.err.ErrorMessage;
import lombok.Data;

/**
 * Response 对象，可以被使用在 web 场景，也可以被使用在 RPC 场景
 *
 * @author codeK
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
   * @return 包含错误信息的 Response 对象
   */
  public static <T> Response<T> error() {
    return error(null);
  }

  /**
   * 构造包含错误信息的 Response 对象
   *
   * @param em 错误消息对象
   * @return 包含错误信息的 Response 对象
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
   * @param <T> 消息体类型
   * @return 包含空消息体的 Response
   */
  public static <T> Response<T> ok() {
    Response response = new Response();
    return response;
  }

  /**
   * 构造成功的 Response
   *
   * @param body 消息体
   * @param <T> 消息体类型
   * @return 包含空消息体的 Response
   */
  public static <T> Response<T> ok(T body) {
    Response<T> response = new Response<T>();
    response.body = body;
    return response;
  }

  /**
   * 是否是成功的 Response
   *
   * @return 是否是成功
   */
  public boolean isSuccess() {
    return error == null;
  }
}
