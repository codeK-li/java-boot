package com.github.javaboot.eql;

import com.github.javaboot.eql.internal.EqlParser;
import com.github.javaboot.eql.internal.EqlParserBaseVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

public class EqlStatementBuilder extends EqlParserBaseVisitor {
  @Override
  public EqlStatement visitStatement(EqlParser.StatementContext ctx) {
    EqlParser.SelectStatementContext selectStatementContext = ctx.selectStatement();
    if (selectStatementContext != null) {
      EqlParser.QuerySpecContext querySpecContext = selectStatementContext.querySpec();
      EqlParser.FromClauseContext fromClauseContext = querySpecContext.fromClause();
      EqlParser.FromClauseSpaceContext fromClauseSpaceContext = fromClauseContext.fromClauseSpace();
      EqlParser.EntityNameContext entityNameContext = fromClauseSpaceContext.entityName();
      TerminalNode entityNameNode = entityNameContext.IDENTIFIER();
      String entityName = entityNameNode.getText();

      EqlStatement eqlStatement = new EqlStatement();
      eqlStatement.setEntityName(entityName);
      return eqlStatement;
    }

    // return super.visitStatement(ctx);
    return null;
  }
}
