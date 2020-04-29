package com.github.codek.javaboot.err;

/**
 * JavaBoot 框架的异常
 *
 * @author OPO
 */
public class FrameworkException extends BaseException {
  /** 基础设施的异常等级，例如网络、中间件、外部服务等 */
  public static final int SYSTEM_LEVEL = 2;
  /** 开发框架的异常等级 */
  public static final int FRAMEWORK_LEVEL = 2 << 4;
  /** 应用框架的异常等级 */
  public static final int APPLICATION_LEVEL = 2 << 5;
  /** 业务规则的异常等级 */
  public static final int BUSINESS_LEVEL = 2 << 6;
  /** 异常等级 */
  private int exceptionLevel;

  protected FrameworkException(ErrorMessage errorMessage) {
    super(errorMessage);
  }

  protected FrameworkException(ErrorMessage errorMessage, Throwable cause) {
    super(errorMessage, cause);
  }

  /**
   * 构造基础设施异常
   *
   * @param errorMessage
   * @return
   */
  public static FrameworkException system(ErrorMessage errorMessage) {
    FrameworkException e = new FrameworkException(errorMessage);
    e.exceptionLevel = SYSTEM_LEVEL;

    return e;
  }

  /**
   * 构造基础设施异常
   *
   * @param errorMessage
   * @param cause
   * @return
   */
  public static FrameworkException system(ErrorMessage errorMessage, Throwable cause) {
    FrameworkException e = new FrameworkException(errorMessage, cause);
    e.exceptionLevel = SYSTEM_LEVEL;

    return e;
  }

  /**
   * 构造开发框架异常
   *
   * @param errorMessage
   * @return
   */
  public static FrameworkException framework(ErrorMessage errorMessage) {
    FrameworkException e = new FrameworkException(errorMessage);
    e.exceptionLevel = FRAMEWORK_LEVEL;

    return e;
  }

  /**
   * 构造开发框架异常
   *
   * @param errorMessage
   * @param cause
   * @return
   */
  public static FrameworkException framework(ErrorMessage errorMessage, Throwable cause) {
    FrameworkException e = new FrameworkException(errorMessage, cause);
    e.exceptionLevel = FRAMEWORK_LEVEL;

    return e;
  }

  /**
   * 构造应用框架异常
   *
   * @param errorMessage
   * @return
   */
  public static FrameworkException application(ErrorMessage errorMessage) {
    FrameworkException e = new FrameworkException(errorMessage);
    e.exceptionLevel = APPLICATION_LEVEL;

    return e;
  }

  /**
   * 构造应用框架异常
   *
   * @param errorMessage
   * @param cause
   * @return
   */
  public static FrameworkException application(ErrorMessage errorMessage, Throwable cause) {
    FrameworkException e = new FrameworkException(errorMessage, cause);
    e.exceptionLevel = APPLICATION_LEVEL;

    return e;
  }

  /**
   * 构造业务规则异常
   *
   * @param errorMessage
   * @return
   */
  public static FrameworkException business(ErrorMessage errorMessage) {
    FrameworkException e = new FrameworkException(errorMessage);
    e.exceptionLevel = BUSINESS_LEVEL;

    return e;
  }

  /**
   * 构造业务规则异常
   *
   * @param errorMessage
   * @return
   */
  public static FrameworkException business(ErrorMessage errorMessage, Throwable cause) {
    FrameworkException e = new FrameworkException(errorMessage, cause);
    e.exceptionLevel = BUSINESS_LEVEL;

    return e;
  }

  @Override
  public int getExceptionLevel() {
    return exceptionLevel;
  }
}
