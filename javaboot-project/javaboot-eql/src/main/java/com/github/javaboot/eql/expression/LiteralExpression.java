package com.github.javaboot.eql.expression;

public class LiteralExpression implements Expression {

  private String text;
  private Object value;

  public LiteralExpression(String text, Object value) {
    this.text = text;
    this.value = value;
  }

  public String getText() {
    return text;
  }

  public Object getValue() {
    return value;
  }
}
