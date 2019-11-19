package com.github.javaboot.err;

/**
 * 应用的基础异常类
 *
 * @author OPO
 */
public class SystemException extends BaseException {
  /** 开发框架的异常等级，128 */
  public static final int EXCEPTION_LEVEL = 2 << 6;

  public SystemException(ErrorMessage errorMessage) {
    super(errorMessage);
  }

  public SystemException(ErrorMessage errorMessage, Throwable cause) {
    super(errorMessage, cause);
  }

  @Override
  public int getExceptionLevel() {
    return EXCEPTION_LEVEL;
  }
}
