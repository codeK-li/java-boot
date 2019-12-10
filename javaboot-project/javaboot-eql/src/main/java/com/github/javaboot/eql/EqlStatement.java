package com.github.javaboot.eql;

import com.github.javaboot.eql.clause.OrderByClause;
import com.github.javaboot.eql.clause.WhereClause;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EqlStatement {
  private String entityName;
  private OrderByClause orderByClause;
  private WhereClause whereClause;
}
