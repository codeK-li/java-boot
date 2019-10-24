package com.github.javaboot.webmodel;

/**
 * 成功的 {@link AbstractResponse Response}
 *
 * @author OPO
 */
public class OkResponse<T> extends AbstractResponse<T> {
  public OkResponse() {
    super();
    this.success = true;
  }

  public OkResponse(T body) {
    this();
    this.body = body;
  }
}
