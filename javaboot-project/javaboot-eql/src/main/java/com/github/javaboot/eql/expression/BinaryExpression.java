package com.github.javaboot.eql.expression;

public interface BinaryExpression extends Expression {
  BinaryOperator getOperator();

  Expression getLeftExpression();

  Expression getRightExpression();
}
