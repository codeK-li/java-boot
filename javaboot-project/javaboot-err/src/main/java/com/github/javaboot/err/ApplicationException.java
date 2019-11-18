package com.github.javaboot.err;

/**
 * 应用的基础异常类
 *
 * @author OPO
 */
public class ApplicationException extends BaseException {
  public ApplicationException(ErrorMessage errorMessage) {
    super(errorMessage);
  }

  public ApplicationException(ErrorMessage errorMessage, Throwable cause) {
    super(errorMessage, cause);
  }
}
