package com.github.javaboot.err;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationExceptionTest {
  @Test
  void should_return_the_same_ErrorMessage() {
    ErrorMessage em = new ErrorMessage();
    ApplicationException ae = new ApplicationException(em);

    assertThat(ae.getErrorMessage()).isEqualTo(em);
  }

  @Test
  void should_return_the_same_ErrorMessage_and_Throwable() {
    ErrorMessage em = new ErrorMessage();
    Throwable t = new Exception();
    ApplicationException ae = new ApplicationException(em, t);

    assertThat(ae.getErrorMessage()).isEqualTo(em);
    assertThat(ae.getCause()).isEqualTo(t);
  }
}
