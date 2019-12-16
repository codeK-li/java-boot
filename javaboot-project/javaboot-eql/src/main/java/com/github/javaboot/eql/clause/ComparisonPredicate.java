package com.github.javaboot.eql.clause;

import com.github.javaboot.eql.expression.ComparisonOperator;
import com.github.javaboot.eql.expression.Expression;

public class ComparisonPredicate implements Predicate {
  private final Expression leftHandExpression;
  private ComparisonOperator operator;
  private final Expression rightHandExpression;

  public ComparisonPredicate(
      Expression leftHandExpression, ComparisonOperator operator, Expression rightHandExpression) {
    this.leftHandExpression = leftHandExpression;
    this.operator = operator;
    this.rightHandExpression = rightHandExpression;
  }

  public Expression getLeftHandExpression() {
    return leftHandExpression;
  }

  public ComparisonOperator getOperator() {
    return operator;
  }

  public Expression getRightHandExpression() {
    return rightHandExpression;
  }
}
