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
  /** 记录总数 */
  private long totalCount;
  /** 当前页的记录集合 */
  private List<T> items;
  /** 总的分页总数 */
  private long pageCount;

  /**
   * 通过 totalCount 和 pageSize 计算 pageCount
   *
   * @param totalCount
   * @param pageSize
   */
  public void setPageCountByTotalCountAndPageSize(long totalCount, long pageSize) {
    this.totalCount = totalCount;
    this.pageCount = ((totalCount - 1) / pageSize) + 1;
  }
}
