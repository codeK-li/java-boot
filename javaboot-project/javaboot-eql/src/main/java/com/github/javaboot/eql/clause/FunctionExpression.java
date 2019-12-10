package com.github.javaboot.eql.clause;

import java.util.List;

public interface FunctionExpression extends Expression {
  String getFunctionName();

  List<Expression> getArgExpressions();
}
