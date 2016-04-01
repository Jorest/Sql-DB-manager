// Generated from Sql.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SqlParser}.
 */
public interface SqlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SqlParser#use_schema_statement}.
	 * @param ctx the parse tree
	 */
	void enterUse_schema_statement(@NotNull SqlParser.Use_schema_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#use_schema_statement}.
	 * @param ctx the parse tree
	 */
	void exitUse_schema_statement(@NotNull SqlParser.Use_schema_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#table_definition}.
	 * @param ctx the parse tree
	 */
	void enterTable_definition(@NotNull SqlParser.Table_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#table_definition}.
	 * @param ctx the parse tree
	 */
	void exitTable_definition(@NotNull SqlParser.Table_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(@NotNull SqlParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(@NotNull SqlParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#int_literal}.
	 * @param ctx the parse tree
	 */
	void enterInt_literal(@NotNull SqlParser.Int_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#int_literal}.
	 * @param ctx the parse tree
	 */
	void exitInt_literal(@NotNull SqlParser.Int_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#sql_schema_manipulation_statement}.
	 * @param ctx the parse tree
	 */
	void enterSql_schema_manipulation_statement(@NotNull SqlParser.Sql_schema_manipulation_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#sql_schema_manipulation_statement}.
	 * @param ctx the parse tree
	 */
	void exitSql_schema_manipulation_statement(@NotNull SqlParser.Sql_schema_manipulation_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#alter_table_statement}.
	 * @param ctx the parse tree
	 */
	void enterAlter_table_statement(@NotNull SqlParser.Alter_table_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#alter_table_statement}.
	 * @param ctx the parse tree
	 */
	void exitAlter_table_statement(@NotNull SqlParser.Alter_table_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#alter_database_statement}.
	 * @param ctx the parse tree
	 */
	void enterAlter_database_statement(@NotNull SqlParser.Alter_database_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#alter_database_statement}.
	 * @param ctx the parse tree
	 */
	void exitAlter_database_statement(@NotNull SqlParser.Alter_database_statementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqE}
	 * labeled alternative in {@link SqlParser#eq_op}.
	 * @param ctx the parse tree
	 */
	void enterEqE(@NotNull SqlParser.EqEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqE}
	 * labeled alternative in {@link SqlParser#eq_op}.
	 * @param ctx the parse tree
	 */
	void exitEqE(@NotNull SqlParser.EqEContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#cond_op1}.
	 * @param ctx the parse tree
	 */
	void enterCond_op1(@NotNull SqlParser.Cond_op1Context ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#cond_op1}.
	 * @param ctx the parse tree
	 */
	void exitCond_op1(@NotNull SqlParser.Cond_op1Context ctx);
	/**
	 * Enter a parse tree produced by the {@code uniFactorFactor}
	 * labeled alternative in {@link SqlParser#unifactor}.
	 * @param ctx the parse tree
	 */
	void enterUniFactorFactor(@NotNull SqlParser.UniFactorFactorContext ctx);
	/**
	 * Exit a parse tree produced by the {@code uniFactorFactor}
	 * labeled alternative in {@link SqlParser#unifactor}.
	 * @param ctx the parse tree
	 */
	void exitUniFactorFactor(@NotNull SqlParser.UniFactorFactorContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(@NotNull SqlParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(@NotNull SqlParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#delete_value}.
	 * @param ctx the parse tree
	 */
	void enterDelete_value(@NotNull SqlParser.Delete_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#delete_value}.
	 * @param ctx the parse tree
	 */
	void exitDelete_value(@NotNull SqlParser.Delete_valueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code uniFactorNot}
	 * labeled alternative in {@link SqlParser#unifactor}.
	 * @param ctx the parse tree
	 */
	void enterUniFactorNot(@NotNull SqlParser.UniFactorNotContext ctx);
	/**
	 * Exit a parse tree produced by the {@code uniFactorNot}
	 * labeled alternative in {@link SqlParser#unifactor}.
	 * @param ctx the parse tree
	 */
	void exitUniFactorNot(@NotNull SqlParser.UniFactorNotContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#char_literal}.
	 * @param ctx the parse tree
	 */
	void enterChar_literal(@NotNull SqlParser.Char_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#char_literal}.
	 * @param ctx the parse tree
	 */
	void exitChar_literal(@NotNull SqlParser.Char_literalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code rekB}
	 * labeled alternative in {@link SqlParser#rel_op}.
	 * @param ctx the parse tree
	 */
	void enterRekB(@NotNull SqlParser.RekBContext ctx);
	/**
	 * Exit a parse tree produced by the {@code rekB}
	 * labeled alternative in {@link SqlParser#rel_op}.
	 * @param ctx the parse tree
	 */
	void exitRekB(@NotNull SqlParser.RekBContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#cond_op2}.
	 * @param ctx the parse tree
	 */
	void enterCond_op2(@NotNull SqlParser.Cond_op2Context ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#cond_op2}.
	 * @param ctx the parse tree
	 */
	void exitCond_op2(@NotNull SqlParser.Cond_op2Context ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#sql_executable_statement}.
	 * @param ctx the parse tree
	 */
	void enterSql_executable_statement(@NotNull SqlParser.Sql_executable_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#sql_executable_statement}.
	 * @param ctx the parse tree
	 */
	void exitSql_executable_statement(@NotNull SqlParser.Sql_executable_statementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relLE}
	 * labeled alternative in {@link SqlParser#rel_op}.
	 * @param ctx the parse tree
	 */
	void enterRelLE(@NotNull SqlParser.RelLEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relLE}
	 * labeled alternative in {@link SqlParser#rel_op}.
	 * @param ctx the parse tree
	 */
	void exitRelLE(@NotNull SqlParser.RelLEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code factorLiteral}
	 * labeled alternative in {@link SqlParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorLiteral(@NotNull SqlParser.FactorLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code factorLiteral}
	 * labeled alternative in {@link SqlParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorLiteral(@NotNull SqlParser.FactorLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#tipo_literal}.
	 * @param ctx the parse tree
	 */
	void enterTipo_literal(@NotNull SqlParser.Tipo_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#tipo_literal}.
	 * @param ctx the parse tree
	 */
	void exitTipo_literal(@NotNull SqlParser.Tipo_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#rename_table_statement}.
	 * @param ctx the parse tree
	 */
	void enterRename_table_statement(@NotNull SqlParser.Rename_table_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#rename_table_statement}.
	 * @param ctx the parse tree
	 */
	void exitRename_table_statement(@NotNull SqlParser.Rename_table_statementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr31}
	 * labeled alternative in {@link SqlParser#expr3}.
	 * @param ctx the parse tree
	 */
	void enterExpr31(@NotNull SqlParser.Expr31Context ctx);
	/**
	 * Exit a parse tree produced by the {@code expr31}
	 * labeled alternative in {@link SqlParser#expr3}.
	 * @param ctx the parse tree
	 */
	void exitExpr31(@NotNull SqlParser.Expr31Context ctx);
	/**
	 * Enter a parse tree produced by the {@code expr32}
	 * labeled alternative in {@link SqlParser#expr3}.
	 * @param ctx the parse tree
	 */
	void enterExpr32(@NotNull SqlParser.Expr32Context ctx);
	/**
	 * Exit a parse tree produced by the {@code expr32}
	 * labeled alternative in {@link SqlParser#expr3}.
	 * @param ctx the parse tree
	 */
	void exitExpr32(@NotNull SqlParser.Expr32Context ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#accion}.
	 * @param ctx the parse tree
	 */
	void enterAccion(@NotNull SqlParser.AccionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#accion}.
	 * @param ctx the parse tree
	 */
	void exitAccion(@NotNull SqlParser.AccionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#show_column_statement}.
	 * @param ctx the parse tree
	 */
	void enterShow_column_statement(@NotNull SqlParser.Show_column_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#show_column_statement}.
	 * @param ctx the parse tree
	 */
	void exitShow_column_statement(@NotNull SqlParser.Show_column_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#sql_schema_definition_statement}.
	 * @param ctx the parse tree
	 */
	void enterSql_schema_definition_statement(@NotNull SqlParser.Sql_schema_definition_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#sql_schema_definition_statement}.
	 * @param ctx the parse tree
	 */
	void exitSql_schema_definition_statement(@NotNull SqlParser.Sql_schema_definition_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#sql_data_statement}.
	 * @param ctx the parse tree
	 */
	void enterSql_data_statement(@NotNull SqlParser.Sql_data_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#sql_data_statement}.
	 * @param ctx the parse tree
	 */
	void exitSql_data_statement(@NotNull SqlParser.Sql_data_statementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code eqNE}
	 * labeled alternative in {@link SqlParser#eq_op}.
	 * @param ctx the parse tree
	 */
	void enterEqNE(@NotNull SqlParser.EqNEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code eqNE}
	 * labeled alternative in {@link SqlParser#eq_op}.
	 * @param ctx the parse tree
	 */
	void exitEqNE(@NotNull SqlParser.EqNEContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#show_schema_statement}.
	 * @param ctx the parse tree
	 */
	void enterShow_schema_statement(@NotNull SqlParser.Show_schema_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#show_schema_statement}.
	 * @param ctx the parse tree
	 */
	void exitShow_schema_statement(@NotNull SqlParser.Show_schema_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#sql_schema_statement}.
	 * @param ctx the parse tree
	 */
	void enterSql_schema_statement(@NotNull SqlParser.Sql_schema_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#sql_schema_statement}.
	 * @param ctx the parse tree
	 */
	void exitSql_schema_statement(@NotNull SqlParser.Sql_schema_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(@NotNull SqlParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(@NotNull SqlParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#constraintType}.
	 * @param ctx the parse tree
	 */
	void enterConstraintType(@NotNull SqlParser.ConstraintTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#constraintType}.
	 * @param ctx the parse tree
	 */
	void exitConstraintType(@NotNull SqlParser.ConstraintTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#list_values}.
	 * @param ctx the parse tree
	 */
	void enterList_values(@NotNull SqlParser.List_valuesContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#list_values}.
	 * @param ctx the parse tree
	 */
	void exitList_values(@NotNull SqlParser.List_valuesContext ctx);
	/**
	 * Enter a parse tree produced by the {@code factorExpression}
	 * labeled alternative in {@link SqlParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactorExpression(@NotNull SqlParser.FactorExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code factorExpression}
	 * labeled alternative in {@link SqlParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactorExpression(@NotNull SqlParser.FactorExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#float_literal}.
	 * @param ctx the parse tree
	 */
	void enterFloat_literal(@NotNull SqlParser.Float_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#float_literal}.
	 * @param ctx the parse tree
	 */
	void exitFloat_literal(@NotNull SqlParser.Float_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#drop_schema_statement}.
	 * @param ctx the parse tree
	 */
	void enterDrop_schema_statement(@NotNull SqlParser.Drop_schema_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#drop_schema_statement}.
	 * @param ctx the parse tree
	 */
	void exitDrop_schema_statement(@NotNull SqlParser.Drop_schema_statementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr22}
	 * labeled alternative in {@link SqlParser#expr2}.
	 * @param ctx the parse tree
	 */
	void enterExpr22(@NotNull SqlParser.Expr22Context ctx);
	/**
	 * Exit a parse tree produced by the {@code expr22}
	 * labeled alternative in {@link SqlParser#expr2}.
	 * @param ctx the parse tree
	 */
	void exitExpr22(@NotNull SqlParser.Expr22Context ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#select_value}.
	 * @param ctx the parse tree
	 */
	void enterSelect_value(@NotNull SqlParser.Select_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#select_value}.
	 * @param ctx the parse tree
	 */
	void exitSelect_value(@NotNull SqlParser.Select_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#date_literal}.
	 * @param ctx the parse tree
	 */
	void enterDate_literal(@NotNull SqlParser.Date_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#date_literal}.
	 * @param ctx the parse tree
	 */
	void exitDate_literal(@NotNull SqlParser.Date_literalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr21}
	 * labeled alternative in {@link SqlParser#expr2}.
	 * @param ctx the parse tree
	 */
	void enterExpr21(@NotNull SqlParser.Expr21Context ctx);
	/**
	 * Exit a parse tree produced by the {@code expr21}
	 * labeled alternative in {@link SqlParser#expr2}.
	 * @param ctx the parse tree
	 */
	void exitExpr21(@NotNull SqlParser.Expr21Context ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#drop_table_statement}.
	 * @param ctx the parse tree
	 */
	void enterDrop_table_statement(@NotNull SqlParser.Drop_table_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#drop_table_statement}.
	 * @param ctx the parse tree
	 */
	void exitDrop_table_statement(@NotNull SqlParser.Drop_table_statementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relL}
	 * labeled alternative in {@link SqlParser#rel_op}.
	 * @param ctx the parse tree
	 */
	void enterRelL(@NotNull SqlParser.RelLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relL}
	 * labeled alternative in {@link SqlParser#rel_op}.
	 * @param ctx the parse tree
	 */
	void exitRelL(@NotNull SqlParser.RelLContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#column}.
	 * @param ctx the parse tree
	 */
	void enterColumn(@NotNull SqlParser.ColumnContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#column}.
	 * @param ctx the parse tree
	 */
	void exitColumn(@NotNull SqlParser.ColumnContext ctx);
	/**
	 * Enter a parse tree produced by the {@code relBE}
	 * labeled alternative in {@link SqlParser#rel_op}.
	 * @param ctx the parse tree
	 */
	void enterRelBE(@NotNull SqlParser.RelBEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code relBE}
	 * labeled alternative in {@link SqlParser#rel_op}.
	 * @param ctx the parse tree
	 */
	void exitRelBE(@NotNull SqlParser.RelBEContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#insert_value}.
	 * @param ctx the parse tree
	 */
	void enterInsert_value(@NotNull SqlParser.Insert_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#insert_value}.
	 * @param ctx the parse tree
	 */
	void exitInsert_value(@NotNull SqlParser.Insert_valueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expression2}
	 * labeled alternative in {@link SqlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression2(@NotNull SqlParser.Expression2Context ctx);
	/**
	 * Exit a parse tree produced by the {@code expression2}
	 * labeled alternative in {@link SqlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression2(@NotNull SqlParser.Expression2Context ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#schema_definition}.
	 * @param ctx the parse tree
	 */
	void enterSchema_definition(@NotNull SqlParser.Schema_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#schema_definition}.
	 * @param ctx the parse tree
	 */
	void exitSchema_definition(@NotNull SqlParser.Schema_definitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expression1}
	 * labeled alternative in {@link SqlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression1(@NotNull SqlParser.Expression1Context ctx);
	/**
	 * Exit a parse tree produced by the {@code expression1}
	 * labeled alternative in {@link SqlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression1(@NotNull SqlParser.Expression1Context ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#update_value}.
	 * @param ctx the parse tree
	 */
	void enterUpdate_value(@NotNull SqlParser.Update_valueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#update_value}.
	 * @param ctx the parse tree
	 */
	void exitUpdate_value(@NotNull SqlParser.Update_valueContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#constraint}.
	 * @param ctx the parse tree
	 */
	void enterConstraint(@NotNull SqlParser.ConstraintContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#constraint}.
	 * @param ctx the parse tree
	 */
	void exitConstraint(@NotNull SqlParser.ConstraintContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#show_table_statement}.
	 * @param ctx the parse tree
	 */
	void enterShow_table_statement(@NotNull SqlParser.Show_table_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#show_table_statement}.
	 * @param ctx the parse tree
	 */
	void exitShow_table_statement(@NotNull SqlParser.Show_table_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#relational}.
	 * @param ctx the parse tree
	 */
	void enterRelational(@NotNull SqlParser.RelationalContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#relational}.
	 * @param ctx the parse tree
	 */
	void exitRelational(@NotNull SqlParser.RelationalContext ctx);
	/**
	 * Enter a parse tree produced by {@link SqlParser#logic}.
	 * @param ctx the parse tree
	 */
	void enterLogic(@NotNull SqlParser.LogicContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#logic}.
	 * @param ctx the parse tree
	 */
	void exitLogic(@NotNull SqlParser.LogicContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expr11}
	 * labeled alternative in {@link SqlParser#expr1}.
	 * @param ctx the parse tree
	 */
	void enterExpr11(@NotNull SqlParser.Expr11Context ctx);
	/**
	 * Exit a parse tree produced by the {@code expr11}
	 * labeled alternative in {@link SqlParser#expr1}.
	 * @param ctx the parse tree
	 */
	void exitExpr11(@NotNull SqlParser.Expr11Context ctx);
	/**
	 * Enter a parse tree produced by the {@code expr12}
	 * labeled alternative in {@link SqlParser#expr1}.
	 * @param ctx the parse tree
	 */
	void enterExpr12(@NotNull SqlParser.Expr12Context ctx);
	/**
	 * Exit a parse tree produced by the {@code expr12}
	 * labeled alternative in {@link SqlParser#expr1}.
	 * @param ctx the parse tree
	 */
	void exitExpr12(@NotNull SqlParser.Expr12Context ctx);
}