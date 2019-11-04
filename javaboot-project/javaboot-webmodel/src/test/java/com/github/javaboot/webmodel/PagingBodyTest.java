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

  @Test
  void should_return_pageCount_by_totalCount_and_pageSize() {
    final long pageSize = 10;
    final long totalCount = 100;
    PagingBody<String> pb = new PagingBody<>();
    pb.setPageCountByTotalCountAndPageSize(totalCount, pageSize);

    assertThat(pb.getTotalCount()).isEqualTo(totalCount);
    assertThat(pb.getPageCount()).isEqualTo((totalCount - 1) / pageSize + 1);
  }
}
