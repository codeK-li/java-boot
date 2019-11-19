package com.github.javaboot.err;

/**
 * 应用的基础异常类
 *
 * @author OPO
 */
public class FrameworkException extends BaseException {
  /** 开发框架的异常等级，256 */
  public static final int EXCEPTION_LEVEL = 2 << 7;

  public FrameworkException(ErrorMessage errorMessage) {
    super(errorMessage);
  }

  public FrameworkException(ErrorMessage errorMessage, Throwable cause) {
    super(errorMessage, cause);
  }

  @Override
  public int getExceptionLevel() {
    return EXCEPTION_LEVEL;
  }
}
