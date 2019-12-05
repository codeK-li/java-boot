package com.github.javaboot.eql;

import com.github.javaboot.eql.internal.EqlParser;
import com.github.javaboot.eql.internal.EqlParserBaseVisitor;
import com.github.javaboot.eql.statement.OrderByClause;
import com.github.javaboot.eql.statement.SortOrder;
import com.github.javaboot.eql.statement.SortSpecification;
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

      EqlParser.OrderByClauseContext orderByClauseContext = querySpecContext.orderByClause();
      if (orderByClauseContext != null) {
        List<EqlParser.SortSpecificationContext> sortSpecificationContexts =
            orderByClauseContext.sortSpecification();
        List<SortSpecification> sortSpecifications =
            new ArrayList<>(sortSpecificationContexts.size());
        for (EqlParser.SortSpecificationContext ssc : sortSpecificationContexts) {
          SortSpecification ss = new SortSpecification();
          String field = ssc.sortExpression().IDENTIFIER().getText();
          ss.setField(field);
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

      return eqlStatement;
    }

    // return super.visitStatement(ctx);
    return null;
  }
}
