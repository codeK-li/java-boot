package com.github.javaboot.eql.clause;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WhereClause {
  private Predicate predicate;
}
