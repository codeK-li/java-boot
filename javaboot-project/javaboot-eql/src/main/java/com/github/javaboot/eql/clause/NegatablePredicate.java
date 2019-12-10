package com.github.javaboot.eql.clause;

public interface NegatablePredicate extends Predicate {
  boolean isNegated();

  NegatablePredicate not();
}
