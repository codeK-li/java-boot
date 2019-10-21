package com.github.javaboot.webmodel;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ErrorResponseTest {
  @Test
  void should_return_error_response() {
    ErrorResponse er = new ErrorResponse();
    assertThat(er.isSuccess()).isFalse();
    ErrorMessage em = er.getBody();
    assertThat(em.getCode()).isEqualTo(0);
    assertThat(em.getMessage()).isNull();
    assertThat(em.getPayload()).isNull();
  }

  @Test
  void should_return_error_response_by_error_message() {
    ErrorMessage em = new ErrorMessage();
    ErrorResponse er = new ErrorResponse(em);
    assertThat(er.isSuccess()).isFalse();
    assertThat(er.getBody()).isEqualTo(em);
  }
}
