package com.github.javaboot.eql.expression;

import com.github.javaboot.eql.expression.Expression;

public interface ParameterExpression extends Expression {
  String getVariableName();
}
