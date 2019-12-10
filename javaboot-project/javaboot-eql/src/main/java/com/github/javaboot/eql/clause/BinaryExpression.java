package com.github.javaboot.eql.clause;

public interface BinaryExpression extends Expression {
  BinaryOperator getOperator();

  Expression getLeftExpression();

  Expression getRightExpression();
}
