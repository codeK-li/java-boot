package com.github.javaboot.eql.clause;

import com.github.javaboot.eql.expression.JunctiveOperator;

public interface JunctivePredicate extends Predicate {
  JunctiveOperator getOperator();

  Predicate getLeftPredicate();

  Predicate getRightPredicate();
}
