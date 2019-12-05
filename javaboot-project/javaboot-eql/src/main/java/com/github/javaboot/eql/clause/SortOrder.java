package com.github.javaboot.eql.clause;

public enum SortOrder {
  ASC {
    @Override
    public SortOrder reverse() {
      return DESC;
    }
  },
  DESC {
    @Override
    public SortOrder reverse() {
      return ASC;
    }
  };

  public abstract SortOrder reverse();

  public static SortOrder interpret(String value) {
    if (value == null) {
      return null;
    }

    if (value.equalsIgnoreCase(ASC.name())) {
      return ASC;
    }

    if (value.equalsIgnoreCase(DESC.name())) {
      return DESC;
    }

    throw new IllegalArgumentException("Unknown sort order : " + value);
  }
}
