package com.github.javaboot.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PagingRequestTest {
  @Test
  void should_return_default_PagingRequest() {
    final int pageSize = 10;
    final long pageIndex = 2;
    final String parameter = "xxxx";
    PagingRequest<String> request = new PagingRequest<>();
    request.setPageSize(pageSize);
    request.setPageIndex(pageIndex);
    request.setParameter(parameter);

    assertThat(request.getPageSize()).isEqualTo(pageSize);
    assertThat(request.getPageIndex()).isEqualTo(pageIndex);
    assertThat(request.getPageNumber()).isEqualTo(pageIndex + 1);
    assertThat(request.getParameter()).isEqualTo(parameter);
    assertThat(request.isCountable()).isTrue();
    assertThat(request.getPagingStartIndex()).isEqualTo(pageIndex * pageSize);
    assertThat(request.getPagingEndIndex()).isEqualTo((pageIndex + 1) * pageSize);
  }

  @Test
  void should_throws_IllegalArgumentException() {
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> {
          final int pageSize = -1;
          final long pageIndex = 2;

          PagingRequest request = new PagingRequest();
          request.setPageSize(pageSize);
          request.setPageIndex(pageIndex);
        });

    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> {
          final int pageSize = 10;
          final long pageIndex = -2;

          PagingRequest request = new PagingRequest();
          request.setPageSize(pageSize);
          request.setPageIndex(pageIndex);
        });
  }
}
