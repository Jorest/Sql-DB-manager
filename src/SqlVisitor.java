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
	 * Visit a parse tree produced by the {@code addConstraint}
	 * labeled alternative in {@link SqlParser#accion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddConstraint(@NotNull SqlParser.AddConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tipoFloar}
	 * labeled alternative in {@link SqlParser#tipo_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoFloar(@NotNull SqlParser.TipoFloarContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(@NotNull SqlParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dropColumn}
	 * labeled alternative in {@link SqlParser#accion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropColumn(@NotNull SqlParser.DropColumnContext ctx);
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
	 * Visit a parse tree produced by the {@code eqE3}
	 * labeled alternative in {@link SqlParser#rel_op3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqE3(@NotNull SqlParser.EqE3Context ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#alter_database_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlter_database_statement(@NotNull SqlParser.Alter_database_statementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqE2}
	 * labeled alternative in {@link SqlParser#rel_op2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqE2(@NotNull SqlParser.EqE2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code eqE}
	 * labeled alternative in {@link SqlParser#rel_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqE(@NotNull SqlParser.EqEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code cond_op1}
	 * labeled alternative in {@link SqlParser#cond_op}.
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
	 * Visit a parse tree produced by the {@code cond_op2}
	 * labeled alternative in {@link SqlParser#cond_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond_op2(@NotNull SqlParser.Cond_op2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code addColumn}
	 * labeled alternative in {@link SqlParser#accion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddColumn(@NotNull SqlParser.AddColumnContext ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#sql_executable_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSql_executable_statement(@NotNull SqlParser.Sql_executable_statementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code foreignK}
	 * labeled alternative in {@link SqlParser#constraintType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForeignK(@NotNull SqlParser.ForeignKContext ctx);
	/**
	 * Visit a parse tree produced by the {@code defcolumna}
	 * labeled alternative in {@link SqlParser#column}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefcolumna(@NotNull SqlParser.DefcolumnaContext ctx);
	/**
	 * Visit a parse tree produced by the {@code dropConstraint}
	 * labeled alternative in {@link SqlParser#accion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDropConstraint(@NotNull SqlParser.DropConstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relLE}
	 * labeled alternative in {@link SqlParser#rel_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelLE(@NotNull SqlParser.RelLEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code defconstraint}
	 * labeled alternative in {@link SqlParser#column}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefconstraint(@NotNull SqlParser.DefconstraintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code check}
	 * labeled alternative in {@link SqlParser#constraintType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCheck(@NotNull SqlParser.CheckContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relL3}
	 * labeled alternative in {@link SqlParser#rel_op3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelL3(@NotNull SqlParser.RelL3Context ctx);
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
	 * Visit a parse tree produced by the {@code rekB3}
	 * labeled alternative in {@link SqlParser#rel_op3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRekB3(@NotNull SqlParser.RekB3Context ctx);
	/**
	 * Visit a parse tree produced by the {@code expr33}
	 * labeled alternative in {@link SqlParser#expr3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr33(@NotNull SqlParser.Expr33Context ctx);
	/**
	 * Visit a parse tree produced by the {@code rekB2}
	 * labeled alternative in {@link SqlParser#rel_op2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRekB2(@NotNull SqlParser.RekB2Context ctx);
	/**
	 * Visit a parse tree produced by the {@code expr32}
	 * labeled alternative in {@link SqlParser#expr3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr32(@NotNull SqlParser.Expr32Context ctx);
	/**
	 * Visit a parse tree produced by the {@code expr34}
	 * labeled alternative in {@link SqlParser#expr3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr34(@NotNull SqlParser.Expr34Context ctx);
	/**
	 * Visit a parse tree produced by the {@code tipoInr}
	 * labeled alternative in {@link SqlParser#tipo_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoInr(@NotNull SqlParser.TipoInrContext ctx);
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
	 * Visit a parse tree produced by the {@code relL2}
	 * labeled alternative in {@link SqlParser#rel_op2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelL2(@NotNull SqlParser.RelL2Context ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#sql_data_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSql_data_statement(@NotNull SqlParser.Sql_data_statementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqNE}
	 * labeled alternative in {@link SqlParser#rel_op}.
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
	 * Visit a parse tree produced by the {@code factorID}
	 * labeled alternative in {@link SqlParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactorID(@NotNull SqlParser.FactorIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tipoDate}
	 * labeled alternative in {@link SqlParser#tipo_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoDate(@NotNull SqlParser.TipoDateContext ctx);
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
	 * Visit a parse tree produced by the {@code relBE3}
	 * labeled alternative in {@link SqlParser#rel_op3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelBE3(@NotNull SqlParser.RelBE3Context ctx);
	/**
	 * Visit a parse tree produced by the {@code relBE2}
	 * labeled alternative in {@link SqlParser#rel_op2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelBE2(@NotNull SqlParser.RelBE2Context ctx);
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
	 * Visit a parse tree produced by the {@code relLE3}
	 * labeled alternative in {@link SqlParser#rel_op3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelLE3(@NotNull SqlParser.RelLE3Context ctx);
	/**
	 * Visit a parse tree produced by the {@code relBE}
	 * labeled alternative in {@link SqlParser#rel_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelBE(@NotNull SqlParser.RelBEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code relLE2}
	 * labeled alternative in {@link SqlParser#rel_op2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelLE2(@NotNull SqlParser.RelLE2Context ctx);
	/**
	 * Visit a parse tree produced by {@link SqlParser#insert_value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInsert_value(@NotNull SqlParser.Insert_valueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code eqNE2}
	 * labeled alternative in {@link SqlParser#rel_op2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqNE2(@NotNull SqlParser.EqNE2Context ctx);
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
	 * Visit a parse tree produced by the {@code primaryK}
	 * labeled alternative in {@link SqlParser#constraintType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryK(@NotNull SqlParser.PrimaryKContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expression1}
	 * labeled alternative in {@link SqlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression1(@NotNull SqlParser.Expression1Context ctx);
	/**
	 * Visit a parse tree produced by the {@code eqNE3}
	 * labeled alternative in {@link SqlParser#rel_op3}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqNE3(@NotNull SqlParser.EqNE3Context ctx);
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
	 * Visit a parse tree produced by the {@code tipoChar}
	 * labeled alternative in {@link SqlParser#tipo_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTipoChar(@NotNull SqlParser.TipoCharContext ctx);
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