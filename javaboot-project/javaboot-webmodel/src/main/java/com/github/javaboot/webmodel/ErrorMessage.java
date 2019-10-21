package com.github.javaboot.webmodel;

import lombok.Data;

@Data
public class ErrorMessage {
  public static final int UNKNOWN_ERROR_CODE = 0;

  private int code = UNKNOWN_ERROR_CODE;
  private String message;
  private Object payload;
}
