package com.github.javaboot.webmodel;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OkResponseTest {
  @Test
  void should_return_success_response() {
    OkResponse sr = new OkResponse();
    assertThat(sr.isSuccess()).isTrue();
    assertThat(sr.getBody()).isNull();

    OkResponse<String> sr1 = new OkResponse<>("abc");
    assertThat(sr1.isSuccess()).isTrue();
    assertThat(sr1.getBody()).isEqualTo("abc");
  }
}
