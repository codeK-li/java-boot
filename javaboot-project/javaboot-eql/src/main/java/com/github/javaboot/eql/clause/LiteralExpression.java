package com.github.javaboot.eql.clause;

public interface LiteralExpression extends Expression {
  String getText();

  Object value();
}
