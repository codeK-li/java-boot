package com.github.javaboot.webmodel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 用于分页的 Request
 *
 * @author OPO
 */
@NoArgsConstructor
public class PagingRequest<T> {
  /** 每一页的数据数量 */
  @Getter private int pageSize;
  /** 分页的页码，0 表示第一页 */
  @Getter private long pageIndex;
  /** 查询参数 */
  @Setter @Getter private T parameter;

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize < 0 ? 0 : pageSize;
  }

  public void setPageIndex(long pageIndex) {
    this.pageIndex = pageIndex < 0 ? 0 : pageIndex;
  }

  public long getPageNumber() {
    return pageIndex + 1;
  }

  public long getPagingStartIndex() {
    return pageIndex * pageSize;
  }

  public long getPagingEndIndex() {
    return (pageIndex + 1) * pageSize;
  }
}
