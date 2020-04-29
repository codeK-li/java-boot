package com.github.codek.javaboot.err;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FrameworkExceptionTest {
  @Test
  void should_return_the_same_ErrorMessage() {
    {
      ErrorMessage em = new ErrorMessage();
      FrameworkException ae = FrameworkException.system(em);

      assertThat(ae.getErrorMessage()).isEqualTo(em);
      assertThat(ae.getExceptionLevel()).isEqualTo(FrameworkException.SYSTEM_LEVEL);
    }
    {
      ErrorMessage em = new ErrorMessage();
      FrameworkException ae = FrameworkException.framework(em);

      assertThat(ae.getErrorMessage()).isEqualTo(em);
      assertThat(ae.getExceptionLevel()).isEqualTo(FrameworkException.FRAMEWORK_LEVEL);
    }
    {
      ErrorMessage em = new ErrorMessage();
      FrameworkException ae = FrameworkException.application(em);

      assertThat(ae.getErrorMessage()).isEqualTo(em);
      assertThat(ae.getExceptionLevel()).isEqualTo(FrameworkException.APPLICATION_LEVEL);
    }
    {
      ErrorMessage em = new ErrorMessage();
      FrameworkException ae = FrameworkException.business(em);

      assertThat(ae.getErrorMessage()).isEqualTo(em);
      assertThat(ae.getExceptionLevel()).isEqualTo(FrameworkException.BUSINESS_LEVEL);
    }
  }

  @Test
  void should_return_the_same_ErrorMessage_and_Throwable() {
    {
      ErrorMessage em = new ErrorMessage();
      Throwable t = new Exception();
      FrameworkException ae = FrameworkException.system(em, t);

      assertThat(ae.getErrorMessage()).isEqualTo(em);
      assertThat(ae.getCause()).isEqualTo(t);
      assertThat(ae.getExceptionLevel()).isEqualTo(FrameworkException.SYSTEM_LEVEL);
    }
    {
      ErrorMessage em = new ErrorMessage();
      Throwable t = new Exception();
      FrameworkException ae = FrameworkException.framework(em, t);

      assertThat(ae.getErrorMessage()).isEqualTo(em);
      assertThat(ae.getCause()).isEqualTo(t);
      assertThat(ae.getExceptionLevel()).isEqualTo(FrameworkException.FRAMEWORK_LEVEL);
    }
    {
      ErrorMessage em = new ErrorMessage();
      Throwable t = new Exception();
      FrameworkException ae = FrameworkException.application(em, t);

      assertThat(ae.getErrorMessage()).isEqualTo(em);
      assertThat(ae.getCause()).isEqualTo(t);
      assertThat(ae.getExceptionLevel()).isEqualTo(FrameworkException.APPLICATION_LEVEL);
    }
    {
      ErrorMessage em = new ErrorMessage();
      Throwable t = new Exception();
      FrameworkException ae = FrameworkException.business(em, t);

      assertThat(ae.getErrorMessage()).isEqualTo(em);
      assertThat(ae.getCause()).isEqualTo(t);
      assertThat(ae.getExceptionLevel()).isEqualTo(FrameworkException.BUSINESS_LEVEL);
    }
  }
}
