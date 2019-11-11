package com.github.javaboot.webmodel;

/**
 * 成功的 {@link AbstractResponse Response}
 *
 * @author OPO
 */
public class OkResponse<T> extends AbstractResponse<T> {
  public OkResponse() {
    this(null);
  }

  public OkResponse(T body) {
    super();
    this.body = body;
  }
}
