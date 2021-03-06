package io.github.codek.jrock.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 用于分页的 Request
 *
 * @author codeK
 */
@NoArgsConstructor
public class PagingRequest<T> {
  /** 每一页的数据数量 */
  @Getter private int pageSize;
  /** 分页的页码，0 表示第一页 */
  @Getter private long pageIndex;
  /** 查询参数 */
  @Setter @Getter private T parameter;
  /** 是否查询记录总数 */
  @Setter @Getter private boolean countable = true;

  /**
   * 设置 pageSize，必须大于 0
   *
   * @param pageSize 每一页的记录数
   */
  public void setPageSize(int pageSize) {
    if (pageSize <= 0) {
      throw new IllegalArgumentException(
          "pageSize must be greater than 0, it is [" + pageSize + "] now.");
    }

    this.pageSize = pageSize;
  }

  /**
   * 设置 pageIndex，必须大于 0
   *
   * @param pageIndex 分页的页码
   */
  public void setPageIndex(long pageIndex) {
    if (pageIndex <= 0) {
      throw new IllegalArgumentException(
          "pageIndex must be greater than 0, it is [" + pageIndex + "] now.");
    }

    this.pageIndex = pageIndex;
  }

  /**
   * 分页的页码，1 表示第一页；这是一个更加符合业务直觉的属性
   *
   * @return 分页页码
   */
  public long getPageNumber() {
    return pageIndex + 1;
  }

  /**
   * 获取当前页数据的起始 index
   *
   * @return 当前页数据的起始 index
   */
  public long getPagingStartIndex() {
    return pageIndex * pageSize;
  }

  /**
   * 获取当前页数据的结束 index
   *
   * @return 当前页数据的结束 index
   */
  public long getPagingEndIndex() {
    return (pageIndex + 1) * pageSize;
  }
}
