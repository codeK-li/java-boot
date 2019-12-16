package com.github.javaboot.eql.expression;

public class ColumnReference implements Expression {
  private final String columnExpression;

  public ColumnReference(String columnExpression) {
    this.columnExpression = columnExpression;
  }

  public String getColumnExpression() {
    return columnExpression;
  }
}
