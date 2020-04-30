package com.github.codek.jrock.dto;

import org.junit.jupiter.api.Assertions;
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

  @Test
  void should_return_pageCount_by_totalCount_and_pageSize() {
    final long pageSize = 10;
    final long totalCount = 100;
    PagingBody<String> pb = new PagingBody<>();
    pb.setPageCountByTotalCountAndPageSize(totalCount, pageSize);

    assertThat(pb.getTotalCount()).isEqualTo(totalCount);
    assertThat(pb.getPageCount()).isEqualTo((totalCount - 1) / pageSize + 1);
  }

  @Test
  void should_throws_IllegalArgumentException_when_setPageCountByTotalCountAndPageSize() {
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> {
          final long pageSize = 0;
          final long totalCount = 100;
          PagingBody<String> pb = new PagingBody<>();
          pb.setPageCountByTotalCountAndPageSize(totalCount, pageSize);
        });

    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> {
          final long pageSize = 10;
          final long totalCount = -1;
          PagingBody<String> pb = new PagingBody<>();
          pb.setPageCountByTotalCountAndPageSize(totalCount, pageSize);
        });
  }
}
