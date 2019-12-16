package com.github.javaboot.eql.clause;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SortSpecification {
  private String column;
  private SortOrder sortOrder = SortOrder.ASC;
}
