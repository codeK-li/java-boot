package com.github.javaboot.eql;

import com.github.javaboot.eql.clause.OrderByClause;
import com.github.javaboot.eql.clause.SortOrder;
import com.github.javaboot.eql.clause.SortSpecification;
import com.github.javaboot.eql.internal.EqlParser;
import com.github.javaboot.eql.internal.EqlParserBaseVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

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

      buildOrderByClause(querySpecContext, eqlStatement);

      super.visitStatement(ctx);
      return eqlStatement;
    }

    return null;
  }

  @Override
  public Object visitOrderByClause(EqlParser.OrderByClauseContext ctx) {
    return super.visitOrderByClause(ctx);
  }

  private void buildOrderByClause(
      EqlParser.QuerySpecContext querySpecContext, EqlStatement eqlStatement) {
    EqlParser.OrderByClauseContext orderByClauseContext = querySpecContext.orderByClause();
    if (orderByClauseContext != null) {
      List<EqlParser.SortSpecificationContext> sortSpecificationContexts =
          orderByClauseContext.sortSpecification();
      List<SortSpecification> sortSpecifications =
          new ArrayList<>(sortSpecificationContexts.size());
      for (EqlParser.SortSpecificationContext ssc : sortSpecificationContexts) {
        SortSpecification ss = new SortSpecification();
        String column = ssc.sortExpression().IDENTIFIER().getText();
        ss.setColumn(column);
        EqlParser.OrderingSpecificationContext orderingSpecificationContext =
            ssc.orderingSpecification();
        if (orderingSpecificationContext != null) {
          String sortOrder = orderingSpecificationContext.getText();
          ss.setSortOrder(SortOrder.interpret(sortOrder));
        }

        sortSpecifications.add(ss);
      }

      OrderByClause orderByClause = new OrderByClause();
      orderByClause.setSortSpecifications(sortSpecifications);
      eqlStatement.setOrderByClause(orderByClause);
    }
  }
}
