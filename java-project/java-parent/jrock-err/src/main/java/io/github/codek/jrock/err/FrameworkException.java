package io.github.codek.jrock.err;

/**
 * jrock 框架的异常
 *
 * @author codeK
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

  /**
   * 构造函数
   *
   * @param errorMessage 错误消息
   */
  protected FrameworkException(ErrorMessage errorMessage) {
    super(errorMessage);
  }

  /**
   * 构造函数
   *
   * @param errorMessage 错误消息
   * @param cause 异常
   */
  protected FrameworkException(ErrorMessage errorMessage, Throwable cause) {
    super(errorMessage, cause);
  }

  /**
   * 构造基础设施异常
   *
   * @param errorMessage 错误消息
   * @return 框架异常
   */
  public static FrameworkException system(ErrorMessage errorMessage) {
    FrameworkException e = new FrameworkException(errorMessage);
    e.exceptionLevel = SYSTEM_LEVEL;

    return e;
  }

  /**
   * 构造基础设施异常
   *
   * @param errorMessage 错误消息
   * @param cause 异常
   * @return 框架异常
   */
  public static FrameworkException system(ErrorMessage errorMessage, Throwable cause) {
    FrameworkException e = new FrameworkException(errorMessage, cause);
    e.exceptionLevel = SYSTEM_LEVEL;

    return e;
  }

  /**
   * 构造开发框架异常
   *
   * @param errorMessage 错误消息
   * @return 框架异常
   */
  public static FrameworkException framework(ErrorMessage errorMessage) {
    FrameworkException e = new FrameworkException(errorMessage);
    e.exceptionLevel = FRAMEWORK_LEVEL;

    return e;
  }

  /**
   * 构造开发框架异常
   *
   * @param errorMessage 错误消息
   * @param cause 异常
   * @return 框架异常
   */
  public static FrameworkException framework(ErrorMessage errorMessage, Throwable cause) {
    FrameworkException e = new FrameworkException(errorMessage, cause);
    e.exceptionLevel = FRAMEWORK_LEVEL;

    return e;
  }

  /**
   * 构造应用框架异常
   *
   * @param errorMessage 错误消息
   * @return 框架异常
   */
  public static FrameworkException application(ErrorMessage errorMessage) {
    FrameworkException e = new FrameworkException(errorMessage);
    e.exceptionLevel = APPLICATION_LEVEL;

    return e;
  }

  /**
   * 构造应用框架异常
   *
   * @param errorMessage 错误消息
   * @param cause 异常
   * @return 框架异常
   */
  public static FrameworkException application(ErrorMessage errorMessage, Throwable cause) {
    FrameworkException e = new FrameworkException(errorMessage, cause);
    e.exceptionLevel = APPLICATION_LEVEL;

    return e;
  }

  /**
   * 构造业务规则异常
   *
   * @param errorMessage 错误消息
   * @return 框架异常
   */
  public static FrameworkException business(ErrorMessage errorMessage) {
    FrameworkException e = new FrameworkException(errorMessage);
    e.exceptionLevel = BUSINESS_LEVEL;

    return e;
  }

  /**
   * 构造业务规则异常
   *
   * @param errorMessage 错误消息
   * @param cause 异常
   * @return 框架异常
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
