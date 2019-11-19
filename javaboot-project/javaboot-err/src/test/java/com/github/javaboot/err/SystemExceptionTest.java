package com.github.javaboot.err;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SystemExceptionTest {
  @Test
  void should_return_the_same_ErrorMessage() {
    ErrorMessage em = new ErrorMessage();
    SystemException ae = new SystemException(em);

    assertThat(ae.getErrorMessage()).isEqualTo(em);
    assertThat(ae.getExceptionLevel()).isEqualTo(SystemException.EXCEPTION_LEVEL);
  }

  @Test
  void should_return_the_same_ErrorMessage_and_Throwable() {
    ErrorMessage em = new ErrorMessage();
    Throwable t = new Exception();
    SystemException ae = new SystemException(em, t);

    assertThat(ae.getErrorMessage()).isEqualTo(em);
    assertThat(ae.getCause()).isEqualTo(t);
    assertThat(ae.getExceptionLevel()).isEqualTo(SystemException.EXCEPTION_LEVEL);
  }
}
