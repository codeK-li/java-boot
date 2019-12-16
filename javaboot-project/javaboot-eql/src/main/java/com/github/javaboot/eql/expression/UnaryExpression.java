package com.github.javaboot.eql.expression;

public interface UnaryExpression extends Expression {
  UnaryOperator getOperator();

  Expression getExpression();
}
