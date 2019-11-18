package com.github.javaboot.err;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ErrorMessageTest {
  @Test
  void should_return_ErrorMessage() {
    final int code = 100;
    final String message = "xxrjrjrj";
    final String payload = "xlsurjrj";

    ErrorMessage em = new ErrorMessage();
    em.setCode(code);
    em.setMessage(message);
    em.setPayload(payload);

    assertThat(em.getCode()).isEqualTo(code);
    assertThat(em.getMessage()).isEqualTo(message);
    assertThat(em.getPayload()).isEqualTo(payload);
    assertThat(em.toExceptionMessage()).isEqualTo(String.format("[%s]%s", code, message));
  }
}
