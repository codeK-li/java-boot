package com.github.javaboot.webmodel;

import lombok.Data;

import java.util.List;

/**
 * 用于分页的 Body
 *
 * @author OPO
 */
@Data
public class PagingBody<T> {
  private long totalCount;
  private List<T> items;

  private long pageCount;
}
