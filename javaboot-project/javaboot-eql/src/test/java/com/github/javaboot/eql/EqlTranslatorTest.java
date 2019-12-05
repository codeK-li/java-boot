package com.github.javaboot.eql;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EqlTranslatorTest {
  /**
   * eql:
   *
   * <p>from employee
   *
   * <p>
   */
  @Test
  void should_translator_entityName() {
    EqlTranslator translator = new EqlTranslator();
    EqlStatement statement = translator.translate("from employee");
    String entityName = statement.getEntityName();
    assertThat(entityName).isEqualTo("employee");
  }
}
