package com.github.javaboot.eql.expression;

import java.util.List;

public interface FunctionExpression extends Expression {
  String getFunctionName();

  List<Expression> getArgExpressions();
}
