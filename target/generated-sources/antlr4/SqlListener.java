// Generated from Sql.g4 by ANTLR 4.4
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SqlParser}.
 */
public interface SqlListener extends ParseTreeListener {
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
	 * Enter a parse tree produced by {@link SqlParser#sql2003Parser}.
	 * @param ctx the parse tree
	 */
	void enterSql2003Parser(@NotNull SqlParser.Sql2003ParserContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#sql2003Parser}.
	 * @param ctx the parse tree
	 */
	void exitSql2003Parser(@NotNull SqlParser.Sql2003ParserContext ctx);
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
	 * Enter a parse tree produced by {@link SqlParser#value}.
	 * @param ctx the parse tree
	 */
	void enterValue(@NotNull SqlParser.ValueContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#value}.
	 * @param ctx the parse tree
	 */
	void exitValue(@NotNull SqlParser.ValueContext ctx);
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
	 * Enter a parse tree produced by {@link SqlParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(@NotNull SqlParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SqlParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(@NotNull SqlParser.ConditionContext ctx);
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
}