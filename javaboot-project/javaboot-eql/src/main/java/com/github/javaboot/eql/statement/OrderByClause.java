package com.github.javaboot.eql.statement;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class OrderByClause {
  private List<SortSpecification> sortSpecifications = new ArrayList<>();
}
