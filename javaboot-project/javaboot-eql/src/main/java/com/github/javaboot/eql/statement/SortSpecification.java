package com.github.javaboot.eql.statement;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SortSpecification {
  private String field;
  private SortOrder sortOrder = SortOrder.ASC;
}
