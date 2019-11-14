package com.github.javaboot.webmodel;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResponseTest {
  @Test
  void should_return_error_response() {
    Response er = Response.error();
    assertThat(er.isSuccess()).isFalse();
    ErrorMessage em = er.getError();
    assertThat(em.getCode()).isEqualTo(0);
    assertThat(em.getMessage()).isNull();
    assertThat(em.getPayload()).isNull();
  }

  @Test
  void should_return_error_response_by_error_message() {
    ErrorMessage em = new ErrorMessage();
    Response er = Response.error(em);
    assertThat(er.isSuccess()).isFalse();
    assertThat(er.getError()).isEqualTo(em);
  }

  @Test
  void should_return_success_response() {
    Response sr = Response.ok();
    assertThat(sr.isSuccess()).isTrue();
    assertThat(sr.getBody()).isNull();

    Response<String> sr1 = Response.ok("abc");
    assertThat(sr1.isSuccess()).isTrue();
    assertThat(sr1.getBody()).isEqualTo("abc");
  }
}
