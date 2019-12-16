package com.github.javaboot.eql;

import com.github.javaboot.eql.clause.ComparisonPredicate;
import com.github.javaboot.eql.clause.WhereClause;
import com.github.javaboot.eql.expression.ColumnReference;
import com.github.javaboot.eql.expression.ComparisonOperator;
import com.github.javaboot.eql.expression.Expression;
import com.github.javaboot.eql.expression.LiteralExpression;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EqlWhereTranslatorTest {
  /**
   * eql:
   *
   * <p>from employee where age > 40
   */
  @Test
  void should_eql_translate_0001() {
    String eql = "from employee where age > 40";
    EqlTranslator translator = new EqlTranslator();
    EqlStatement statement = translator.translate(eql);

    // from employee
    String entityName = statement.getEntityName();
    assertThat(entityName).isEqualTo("employee");

    // where age > 40
    WhereClause whereClause = statement.getWhereClause();
    ComparisonPredicate predicate = (ComparisonPredicate) whereClause.getPredicate();
    Expression leftExpression = predicate.getLeftHandExpression();
    ComparisonOperator operator = predicate.getOperator();
    Expression rightExpression = predicate.getRightHandExpression();

    {
      ColumnReference column = (ColumnReference) leftExpression;
      String columnExpression = column.getColumnExpression();
      assertThat(columnExpression).isEqualTo("age");
    }
    assertThat(operator).isEqualTo(ComparisonOperator.GREATER_THAN);
    {
      LiteralExpression literal = (LiteralExpression) rightExpression;
      assertThat(literal.getText()).isEqualTo("40");
      assertThat(literal.getValue()).isEqualTo(Integer.valueOf(40));
    }
  }
}
