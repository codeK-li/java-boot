package com.github.javaboot.webmodel;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PagingBodyTest {
  @Test
  void should_return_default_PagingBody() {
    PagingBody<String> pb = new PagingBody<>();
    assertThat(pb.getPageCount()).isEqualTo(0);
    assertThat(pb.getTotalCount()).isEqualTo(0);
    assertThat(pb.getItems()).isNull();
  }
}
