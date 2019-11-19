package com.github.javaboot.err;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FrameworkExceptionTest {
  @Test
  void should_return_the_same_ErrorMessage() {
    ErrorMessage em = new ErrorMessage();
    FrameworkException ae = new FrameworkException(em);

    assertThat(ae.getErrorMessage()).isEqualTo(em);
    assertThat(ae.getExceptionLevel()).isEqualTo(FrameworkException.EXCEPTION_LEVEL);
  }

  @Test
  void should_return_the_same_ErrorMessage_and_Throwable() {
    ErrorMessage em = new ErrorMessage();
    Throwable t = new Exception();
    FrameworkException ae = new FrameworkException(em, t);

    assertThat(ae.getErrorMessage()).isEqualTo(em);
    assertThat(ae.getCause()).isEqualTo(t);
    assertThat(ae.getExceptionLevel()).isEqualTo(FrameworkException.EXCEPTION_LEVEL);
  }
}
