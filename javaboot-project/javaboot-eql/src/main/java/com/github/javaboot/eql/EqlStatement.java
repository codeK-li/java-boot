package com.github.javaboot.eql;

import com.github.javaboot.eql.statement.OrderByClause;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EqlStatement {
  private String entityName;
  private OrderByClause orderByClause;
}
