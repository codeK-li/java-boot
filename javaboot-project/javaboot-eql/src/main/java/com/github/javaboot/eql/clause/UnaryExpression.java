package com.github.javaboot.eql.clause;

public interface UnaryExpression extends Expression {
  UnaryOperator getOperator();

  Expression getExpression();
}
