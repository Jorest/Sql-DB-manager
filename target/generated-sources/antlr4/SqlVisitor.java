// Generated from Sql.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SqlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SqlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SqlParser#use_schema_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUse_schema_statement(@NotNull SqlParser.Use_schema_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#table_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTable_definition(@NotNull SqlParser.Table_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull SqlParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#int_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt_literal(@NotNull SqlParser.Int_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#sql_schema_manipulation_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSql_schema_manipulation_statement(@NotNull SqlParser.Sql_schema_manipulation_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#alter_table_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_table_statement(@NotNull SqlParser.Alter_table_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#alter_database_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_database_statement(@NotNull SqlParser.Alter_database_statementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqE}
	 * labeled alternative in {@link SqlParser#eq_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqE(@NotNull SqlParser.EqEContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#cond_op1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond_op1(@NotNull SqlParser.Cond_op1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code uniFactorFactor}
	 * labeled alternative in {@link SqlParser#unifactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniFactorFactor(@NotNull SqlParser.UniFactorFactorContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(@NotNull SqlParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#delete_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelete_value(@NotNull SqlParser.Delete_valueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code uniFactorNot}
	 * labeled alternative in {@link SqlParser#unifactor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUniFactorNot(@NotNull SqlParser.UniFactorNotContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#char_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitChar_literal(@NotNull SqlParser.Char_literalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rekB}
	 * labeled alternative in {@link SqlParser#rel_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRekB(@NotNull SqlParser.RekBContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#cond_op2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond_op2(@NotNull SqlParser.Cond_op2Context ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#sql_executable_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSql_executable_statement(@NotNull SqlParser.Sql_executable_statementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relLE}
	 * labeled alternative in {@link SqlParser#rel_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelLE(@NotNull SqlParser.RelLEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code factorLiteral}
	 * labeled alternative in {@link SqlParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorLiteral(@NotNull SqlParser.FactorLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#tipo_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipo_literal(@NotNull SqlParser.Tipo_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#rename_table_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRename_table_statement(@NotNull SqlParser.Rename_table_statementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr31}
	 * labeled alternative in {@link SqlParser#expr3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr31(@NotNull SqlParser.Expr31Context ctx);
	/**
	 * Visit a parse tree produced by the {@code expr32}
	 * labeled alternative in {@link SqlParser#expr3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr32(@NotNull SqlParser.Expr32Context ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#accion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccion(@NotNull SqlParser.AccionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#show_column_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShow_column_statement(@NotNull SqlParser.Show_column_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#sql_schema_definition_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSql_schema_definition_statement(@NotNull SqlParser.Sql_schema_definition_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#sql_data_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSql_data_statement(@NotNull SqlParser.Sql_data_statementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqNE}
	 * labeled alternative in {@link SqlParser#eq_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqNE(@NotNull SqlParser.EqNEContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#show_schema_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShow_schema_statement(@NotNull SqlParser.Show_schema_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#sql_schema_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSql_schema_statement(@NotNull SqlParser.Sql_schema_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(@NotNull SqlParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#constraintType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraintType(@NotNull SqlParser.ConstraintTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#list_values}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitList_values(@NotNull SqlParser.List_valuesContext ctx);
	/**
	 * Visit a parse tree produced by the {@code factorExpression}
	 * labeled alternative in {@link SqlParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorExpression(@NotNull SqlParser.FactorExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#float_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloat_literal(@NotNull SqlParser.Float_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#drop_schema_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_schema_statement(@NotNull SqlParser.Drop_schema_statementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr22}
	 * labeled alternative in {@link SqlParser#expr2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr22(@NotNull SqlParser.Expr22Context ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#select_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelect_value(@NotNull SqlParser.Select_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#date_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDate_literal(@NotNull SqlParser.Date_literalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr21}
	 * labeled alternative in {@link SqlParser#expr2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr21(@NotNull SqlParser.Expr21Context ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#drop_table_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDrop_table_statement(@NotNull SqlParser.Drop_table_statementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relL}
	 * labeled alternative in {@link SqlParser#rel_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelL(@NotNull SqlParser.RelLContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#column}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitColumn(@NotNull SqlParser.ColumnContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relBE}
	 * labeled alternative in {@link SqlParser#rel_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelBE(@NotNull SqlParser.RelBEContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#insert_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsert_value(@NotNull SqlParser.Insert_valueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expression2}
	 * labeled alternative in {@link SqlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression2(@NotNull SqlParser.Expression2Context ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#schema_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSchema_definition(@NotNull SqlParser.Schema_definitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expression1}
	 * labeled alternative in {@link SqlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression1(@NotNull SqlParser.Expression1Context ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#update_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUpdate_value(@NotNull SqlParser.Update_valueContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#constraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstraint(@NotNull SqlParser.ConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#show_table_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShow_table_statement(@NotNull SqlParser.Show_table_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#relational}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelational(@NotNull SqlParser.RelationalContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#logic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogic(@NotNull SqlParser.LogicContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expr11}
	 * labeled alternative in {@link SqlParser#expr1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr11(@NotNull SqlParser.Expr11Context ctx);
	/**
	 * Visit a parse tree produced by the {@code expr12}
	 * labeled alternative in {@link SqlParser#expr1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr12(@NotNull SqlParser.Expr12Context ctx);
}