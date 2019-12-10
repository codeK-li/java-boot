package com.github.javaboot.eql.clause;

public interface JunctivePredicate extends Predicate {
  JunctiveOperator getOperator();

  Predicate getLeftPredicate();

  Predicate getRightPredicate();
}
