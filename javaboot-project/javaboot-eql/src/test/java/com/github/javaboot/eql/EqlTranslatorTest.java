package com.github.javaboot.eql;

import com.github.javaboot.eql.clause.OrderByClause;
import com.github.javaboot.eql.clause.SortOrder;
import com.github.javaboot.eql.clause.SortSpecification;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class EqlTranslatorTest {
  /**
   * eql:
   *
   * <p>from employee
   */
  @Test
  void should_translator_entityName() {
    EqlTranslator translator = new EqlTranslator();
    EqlStatement statement = translator.translate("from employee");
    String entityName = statement.getEntityName();
    assertThat(entityName).isEqualTo("employee");
  }

  /**
   * eql:
   *
   * <p>from employee order by id, birthday desc, age asc
   */
  @Test
  void should_translator_entityName_and_orderBy() {
    String eql = "from employee order by id, birthday desc, age asc";
    EqlTranslator translator = new EqlTranslator();
    EqlStatement statement = translator.translate(eql);
    String entityName = statement.getEntityName();
    assertThat(entityName).isEqualTo("employee");

    OrderByClause orderByClause = statement.getOrderByClause();
    List<SortSpecification> sortSpecifications = orderByClause.getSortSpecifications();

    assertThat(sortSpecifications.size()).isEqualTo(3);
    {
      SortSpecification sortSpecification = sortSpecifications.get(0);
      assertThat(sortSpecification.getField()).isEqualTo("id");
      assertThat(sortSpecification.getSortOrder()).isEqualTo(SortOrder.ASC);
    }
    {
      SortSpecification sortSpecification = sortSpecifications.get(1);
      assertThat(sortSpecification.getField()).isEqualTo("birthday");
      assertThat(sortSpecification.getSortOrder()).isEqualTo(SortOrder.DESC);
    }
    {
      SortSpecification sortSpecification = sortSpecifications.get(2);
      assertThat(sortSpecification.getField()).isEqualTo("age");
      assertThat(sortSpecification.getSortOrder()).isEqualTo(SortOrder.ASC);
    }
  }

  /**
   * eql:
   *
   * <p>from employee where age > 10
   */
  @Test
  void should_translator_age_gt_10() {
    String eql = "from employee where age > 10";
    EqlTranslator translator = new EqlTranslator();
    EqlStatement statement = translator.translate(eql);
    String entityName = statement.getEntityName();
    assertThat(entityName).isEqualTo("employee");


  }
}
