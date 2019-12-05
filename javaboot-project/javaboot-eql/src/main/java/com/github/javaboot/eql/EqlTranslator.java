package com.github.javaboot.eql;

import com.github.javaboot.eql.internal.EqlLexer;
import com.github.javaboot.eql.internal.EqlParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class EqlTranslator {
  public EqlStatement translate(String eql) {
    EqlLexer lexer = new EqlLexer(CharStreams.fromString(eql));
    EqlParser parser = new EqlParser(new CommonTokenStream(lexer));
    EqlParser.StatementContext statementContext = parser.statement();
    EqlStatementBuilder statementBuilder = new EqlStatementBuilder();

    final EqlStatement statement = statementBuilder.visitStatement(statementContext);
    return statement;
  }
}
