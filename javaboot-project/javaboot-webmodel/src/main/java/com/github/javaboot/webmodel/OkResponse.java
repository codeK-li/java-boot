package com.github.javaboot.webmodel;

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
