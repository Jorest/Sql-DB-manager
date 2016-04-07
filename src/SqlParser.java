// Generated from Sql.g4 by ANTLR 4.4
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SqlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__50=1, T__49=2, T__48=3, T__47=4, T__46=5, T__45=6, T__44=7, T__43=8, 
		T__42=9, T__41=10, T__40=11, T__39=12, T__38=13, T__37=14, T__36=15, T__35=16, 
		T__34=17, T__33=18, T__32=19, T__31=20, T__30=21, T__29=22, T__28=23, 
		T__27=24, T__26=25, T__25=26, T__24=27, T__23=28, T__22=29, T__21=30, 
		T__20=31, T__19=32, T__18=33, T__17=34, T__16=35, T__15=36, T__14=37, 
		T__13=38, T__12=39, T__11=40, T__10=41, T__9=42, T__8=43, T__7=44, T__6=45, 
		T__5=46, T__4=47, T__3=48, T__2=49, T__1=50, T__0=51, INT=52, CHAR=53, 
		BOOLEAN=54, DATETIME=55, ID=56, NUM=57, FLOAT=58, Char=59, DATE=60, WS=61, 
		COMMENT=62;
	public static final String[] tokenNames = {
		"<INVALID>", "'FOREIGN'", "'CONSTRAINT'", "'FROM'", "'REFERENCES'", "'='", 
		"'('", "','", "'COLUMNS'", "'PRIMARY'", "'ASC'", "'VALUES'", "'CHECK'", 
		"'UPDATE'", "'DELETE'", "'>='", "'<'", "'TABLES'", "'<>'", "'INSERT'", 
		"'SHOW'", "'CREATE'", "'CHAR('", "'COLUMN'", "'DATABASES'", "'TABLE'", 
		"'BY'", "'WHERE'", "'INTO'", "'AND'", "';'", "'NOT'", "'<='", "'ADD'", 
		"'KEY'", "'ORDER'", "'*'", "'SELECT'", "'DROP'", "'DATE'", "'INT'", "'TO'", 
		"'RENAME'", "'>'", "'OR'", "'ALTER'", "'USE'", "'FLOAT'", "')'", "'DESC'", 
		"'DATABASE'", "'SET'", "'int'", "'char'", "'boolean'", "'datetime'", "ID", 
		"NUM", "FLOAT", "Char", "DATE", "WS", "COMMENT"
	};
	public static final int
		RULE_program = 0, RULE_sql_executable_statement = 1, RULE_sql_schema_statement = 2, 
		RULE_sql_schema_definition_statement = 3, RULE_sql_schema_manipulation_statement = 4, 
		RULE_sql_data_statement = 5, RULE_schema_definition = 6, RULE_table_definition = 7, 
		RULE_drop_schema_statement = 8, RULE_alter_table_statement = 9, RULE_drop_table_statement = 10, 
		RULE_alter_database_statement = 11, RULE_show_schema_statement = 12, RULE_use_schema_statement = 13, 
		RULE_column = 14, RULE_tipo_literal = 15, RULE_constraint = 16, RULE_constraintType = 17, 
		RULE_rename_table_statement = 18, RULE_accion = 19, RULE_show_table_statement = 20, 
		RULE_show_column_statement = 21, RULE_dmlstatement = 22, RULE_insert_value = 23, 
		RULE_update_value = 24, RULE_delete_value = 25, RULE_select_value = 26, 
		RULE_list_values = 27, RULE_literal = 28, RULE_int_literal = 29, RULE_float_literal = 30, 
		RULE_date_literal = 31, RULE_char_literal = 32, RULE_rel_op = 33, RULE_rel_op2 = 34, 
		RULE_rel_op3 = 35, RULE_cond_op = 36, RULE_expression = 37, RULE_expr1 = 38, 
		RULE_expr3 = 39, RULE_unifactor = 40, RULE_factor = 41;
	public static final String[] ruleNames = {
		"program", "sql_executable_statement", "sql_schema_statement", "sql_schema_definition_statement", 
		"sql_schema_manipulation_statement", "sql_data_statement", "schema_definition", 
		"table_definition", "drop_schema_statement", "alter_table_statement", 
		"drop_table_statement", "alter_database_statement", "show_schema_statement", 
		"use_schema_statement", "column", "tipo_literal", "constraint", "constraintType", 
		"rename_table_statement", "accion", "show_table_statement", "show_column_statement", 
		"dmlstatement", "insert_value", "update_value", "delete_value", "select_value", 
		"list_values", "literal", "int_literal", "float_literal", "date_literal", 
		"char_literal", "rel_op", "rel_op2", "rel_op3", "cond_op", "expression", 
		"expr1", "expr3", "unifactor", "factor"
	};

	@Override
	public String getGrammarFileName() { return "Sql.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public SqlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<Sql_executable_statementContext> sql_executable_statement() {
			return getRuleContexts(Sql_executable_statementContext.class);
		}
		public Sql_executable_statementContext sql_executable_statement(int i) {
			return getRuleContext(Sql_executable_statementContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(84); sql_executable_statement();
				}
				}
				setState(87); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__38) | (1L << T__37) | (1L << T__32) | (1L << T__31) | (1L << T__30) | (1L << T__14) | (1L << T__13) | (1L << T__6) | (1L << T__5))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sql_executable_statementContext extends ParserRuleContext {
		public Sql_schema_statementContext sql_schema_statement() {
			return getRuleContext(Sql_schema_statementContext.class,0);
		}
		public Sql_data_statementContext sql_data_statement() {
			return getRuleContext(Sql_data_statementContext.class,0);
		}
		public Sql_executable_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql_executable_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSql_executable_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSql_executable_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSql_executable_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sql_executable_statementContext sql_executable_statement() throws RecognitionException {
		Sql_executable_statementContext _localctx = new Sql_executable_statementContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_sql_executable_statement);
		try {
			setState(91);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(89); sql_schema_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(90); sql_data_statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sql_schema_statementContext extends ParserRuleContext {
		public Sql_schema_manipulation_statementContext sql_schema_manipulation_statement() {
			return getRuleContext(Sql_schema_manipulation_statementContext.class,0);
		}
		public Sql_schema_definition_statementContext sql_schema_definition_statement() {
			return getRuleContext(Sql_schema_definition_statementContext.class,0);
		}
		public Sql_schema_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql_schema_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSql_schema_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSql_schema_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSql_schema_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sql_schema_statementContext sql_schema_statement() throws RecognitionException {
		Sql_schema_statementContext _localctx = new Sql_schema_statementContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_sql_schema_statement);
		try {
			setState(95);
			switch (_input.LA(1)) {
			case T__30:
				enterOuterAlt(_localctx, 1);
				{
				setState(93); sql_schema_definition_statement();
				}
				break;
			case T__38:
			case T__37:
			case T__32:
			case T__31:
			case T__14:
			case T__13:
			case T__6:
			case T__5:
				enterOuterAlt(_localctx, 2);
				{
				setState(94); sql_schema_manipulation_statement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sql_schema_definition_statementContext extends ParserRuleContext {
		public Table_definitionContext table_definition() {
			return getRuleContext(Table_definitionContext.class,0);
		}
		public Schema_definitionContext schema_definition() {
			return getRuleContext(Schema_definitionContext.class,0);
		}
		public Sql_schema_definition_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql_schema_definition_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSql_schema_definition_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSql_schema_definition_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSql_schema_definition_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sql_schema_definition_statementContext sql_schema_definition_statement() throws RecognitionException {
		Sql_schema_definition_statementContext _localctx = new Sql_schema_definition_statementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_sql_schema_definition_statement);
		try {
			setState(99);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(97); schema_definition();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(98); table_definition();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sql_schema_manipulation_statementContext extends ParserRuleContext {
		public Drop_table_statementContext drop_table_statement() {
			return getRuleContext(Drop_table_statementContext.class,0);
		}
		public Drop_schema_statementContext drop_schema_statement() {
			return getRuleContext(Drop_schema_statementContext.class,0);
		}
		public DmlstatementContext dmlstatement() {
			return getRuleContext(DmlstatementContext.class,0);
		}
		public Show_schema_statementContext show_schema_statement() {
			return getRuleContext(Show_schema_statementContext.class,0);
		}
		public Alter_table_statementContext alter_table_statement() {
			return getRuleContext(Alter_table_statementContext.class,0);
		}
		public Alter_database_statementContext alter_database_statement() {
			return getRuleContext(Alter_database_statementContext.class,0);
		}
		public Rename_table_statementContext rename_table_statement() {
			return getRuleContext(Rename_table_statementContext.class,0);
		}
		public Show_table_statementContext show_table_statement() {
			return getRuleContext(Show_table_statementContext.class,0);
		}
		public Use_schema_statementContext use_schema_statement() {
			return getRuleContext(Use_schema_statementContext.class,0);
		}
		public Show_column_statementContext show_column_statement() {
			return getRuleContext(Show_column_statementContext.class,0);
		}
		public Sql_schema_manipulation_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql_schema_manipulation_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSql_schema_manipulation_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSql_schema_manipulation_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSql_schema_manipulation_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sql_schema_manipulation_statementContext sql_schema_manipulation_statement() throws RecognitionException {
		Sql_schema_manipulation_statementContext _localctx = new Sql_schema_manipulation_statementContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_sql_schema_manipulation_statement);
		try {
			setState(111);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(101); drop_schema_statement();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(102); alter_table_statement();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(103); drop_table_statement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(104); alter_database_statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(105); use_schema_statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(106); show_schema_statement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(107); rename_table_statement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(108); show_table_statement();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(109); show_column_statement();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(110); dmlstatement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Sql_data_statementContext extends ParserRuleContext {
		public Select_valueContext select_value() {
			return getRuleContext(Select_valueContext.class,0);
		}
		public Sql_data_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sql_data_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSql_data_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSql_data_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSql_data_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Sql_data_statementContext sql_data_statement() throws RecognitionException {
		Sql_data_statementContext _localctx = new Sql_data_statementContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_sql_data_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113); select_value();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Schema_definitionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SqlParser.ID, 0); }
		public Schema_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_schema_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSchema_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSchema_definition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSchema_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Schema_definitionContext schema_definition() throws RecognitionException {
		Schema_definitionContext _localctx = new Schema_definitionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_schema_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(115); match(T__30);
			setState(116); match(T__1);
			setState(117); match(ID);
			setState(118); match(T__21);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Table_definitionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SqlParser.ID, 0); }
		public List<ColumnContext> column() {
			return getRuleContexts(ColumnContext.class);
		}
		public ColumnContext column(int i) {
			return getRuleContext(ColumnContext.class,i);
		}
		public Table_definitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterTable_definition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitTable_definition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitTable_definition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Table_definitionContext table_definition() throws RecognitionException {
		Table_definitionContext _localctx = new Table_definitionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_table_definition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120); match(T__30);
			setState(121); match(T__26);
			setState(122); match(ID);
			setState(123); match(T__45);
			setState(125); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(124); column();
				}
				}
				setState(127); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__49 || _la==ID );
			setState(129); match(T__3);
			setState(130); match(T__21);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Drop_schema_statementContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SqlParser.ID, 0); }
		public Drop_schema_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_schema_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterDrop_schema_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitDrop_schema_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDrop_schema_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Drop_schema_statementContext drop_schema_statement() throws RecognitionException {
		Drop_schema_statementContext _localctx = new Drop_schema_statementContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_drop_schema_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132); match(T__13);
			setState(133); match(T__1);
			setState(134); match(ID);
			setState(135); match(T__21);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Alter_table_statementContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SqlParser.ID, 0); }
		public AccionContext accion() {
			return getRuleContext(AccionContext.class,0);
		}
		public Alter_table_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alter_table_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterAlter_table_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitAlter_table_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitAlter_table_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Alter_table_statementContext alter_table_statement() throws RecognitionException {
		Alter_table_statementContext _localctx = new Alter_table_statementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_alter_table_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137); match(T__6);
			setState(138); match(T__26);
			setState(139); match(ID);
			setState(140); accion();
			setState(141); match(T__21);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Drop_table_statementContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SqlParser.ID, 0); }
		public Drop_table_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_drop_table_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterDrop_table_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitDrop_table_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDrop_table_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Drop_table_statementContext drop_table_statement() throws RecognitionException {
		Drop_table_statementContext _localctx = new Drop_table_statementContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_drop_table_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143); match(T__13);
			setState(144); match(T__26);
			setState(145); match(ID);
			setState(146); match(T__21);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Alter_database_statementContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(SqlParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SqlParser.ID, i);
		}
		public Alter_database_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_alter_database_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterAlter_database_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitAlter_database_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitAlter_database_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Alter_database_statementContext alter_database_statement() throws RecognitionException {
		Alter_database_statementContext _localctx = new Alter_database_statementContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_alter_database_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148); match(T__6);
			setState(149); match(T__1);
			setState(150); match(ID);
			setState(151); match(T__9);
			setState(152); match(T__10);
			setState(153); match(ID);
			setState(154); match(T__21);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Show_schema_statementContext extends ParserRuleContext {
		public Show_schema_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_show_schema_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterShow_schema_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitShow_schema_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitShow_schema_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Show_schema_statementContext show_schema_statement() throws RecognitionException {
		Show_schema_statementContext _localctx = new Show_schema_statementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_show_schema_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156); match(T__31);
			setState(157); match(T__27);
			setState(158); match(T__21);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Use_schema_statementContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SqlParser.ID, 0); }
		public Use_schema_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_use_schema_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterUse_schema_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitUse_schema_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitUse_schema_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Use_schema_statementContext use_schema_statement() throws RecognitionException {
		Use_schema_statementContext _localctx = new Use_schema_statementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_use_schema_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(160); match(T__5);
			setState(161); match(T__1);
			setState(162); match(ID);
			setState(163); match(T__21);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnContext extends ParserRuleContext {
		public ColumnContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_column; }
	 
		public ColumnContext() { }
		public void copyFrom(ColumnContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class DefcolumnaContext extends ColumnContext {
		public TerminalNode ID() { return getToken(SqlParser.ID, 0); }
		public Tipo_literalContext tipo_literal() {
			return getRuleContext(Tipo_literalContext.class,0);
		}
		public DefcolumnaContext(ColumnContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterDefcolumna(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitDefcolumna(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDefcolumna(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DefconstraintContext extends ColumnContext {
		public ConstraintContext constraint() {
			return getRuleContext(ConstraintContext.class,0);
		}
		public DefconstraintContext(ColumnContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterDefconstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitDefconstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDefconstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ColumnContext column() throws RecognitionException {
		ColumnContext _localctx = new ColumnContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_column);
		int _la;
		try {
			setState(174);
			switch (_input.LA(1)) {
			case ID:
				_localctx = new DefcolumnaContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(165); match(ID);
				setState(166); tipo_literal();
				setState(168);
				_la = _input.LA(1);
				if (_la==T__44) {
					{
					setState(167); match(T__44);
					}
				}

				}
				break;
			case T__49:
				_localctx = new DefconstraintContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(170); constraint();
				setState(172);
				_la = _input.LA(1);
				if (_la==T__44) {
					{
					setState(171); match(T__44);
					}
				}

				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Tipo_literalContext extends ParserRuleContext {
		public Tipo_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tipo_literal; }
	 
		public Tipo_literalContext() { }
		public void copyFrom(Tipo_literalContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TipoDateContext extends Tipo_literalContext {
		public TipoDateContext(Tipo_literalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterTipoDate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitTipoDate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitTipoDate(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TipoIntContext extends Tipo_literalContext {
		public TipoIntContext(Tipo_literalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterTipoInt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitTipoInt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitTipoInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TipoFloatContext extends Tipo_literalContext {
		public TipoFloatContext(Tipo_literalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterTipoFloat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitTipoFloat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitTipoFloat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TipoCharContext extends Tipo_literalContext {
		public TerminalNode NUM() { return getToken(SqlParser.NUM, 0); }
		public TipoCharContext(Tipo_literalContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterTipoChar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitTipoChar(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitTipoChar(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Tipo_literalContext tipo_literal() throws RecognitionException {
		Tipo_literalContext _localctx = new Tipo_literalContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_tipo_literal);
		try {
			setState(182);
			switch (_input.LA(1)) {
			case T__11:
				_localctx = new TipoIntContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(176); match(T__11);
				}
				break;
			case T__4:
				_localctx = new TipoFloatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(177); match(T__4);
				}
				break;
			case T__29:
				_localctx = new TipoCharContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(178); match(T__29);
				setState(179); match(NUM);
				setState(180); match(T__3);
				}
				break;
			case T__12:
				_localctx = new TipoDateContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(181); match(T__12);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstraintContext extends ParserRuleContext {
		public ConstraintTypeContext constraintType() {
			return getRuleContext(ConstraintTypeContext.class,0);
		}
		public ConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstraintContext constraint() throws RecognitionException {
		ConstraintContext _localctx = new ConstraintContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_constraint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184); match(T__49);
			setState(185); constraintType();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstraintTypeContext extends ParserRuleContext {
		public ConstraintTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constraintType; }
	 
		public ConstraintTypeContext() { }
		public void copyFrom(ConstraintTypeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class ForeignKContext extends ConstraintTypeContext {
		public List<TerminalNode> ID() { return getTokens(SqlParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SqlParser.ID, i);
		}
		public ForeignKContext(ConstraintTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterForeignK(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitForeignK(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitForeignK(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CheckContext extends ConstraintTypeContext {
		public TerminalNode ID() { return getToken(SqlParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public CheckContext(ConstraintTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterCheck(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitCheck(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitCheck(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrimaryKContext extends ConstraintTypeContext {
		public List<TerminalNode> ID() { return getTokens(SqlParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SqlParser.ID, i);
		}
		public PrimaryKContext(ConstraintTypeContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterPrimaryK(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitPrimaryK(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitPrimaryK(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstraintTypeContext constraintType() throws RecognitionException {
		ConstraintTypeContext _localctx = new ConstraintTypeContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_constraintType);
		int _la;
		try {
			setState(231);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new PrimaryKContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(187); match(ID);
				setState(188); match(T__42);
				setState(189); match(T__17);
				setState(190); match(T__45);
				setState(191); match(ID);
				setState(196);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__44) {
					{
					{
					setState(192); match(T__44);
					setState(193); match(ID);
					}
					}
					setState(198);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(199); match(T__3);
				}
				break;
			case 2:
				_localctx = new ForeignKContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(200); match(ID);
				setState(201); match(T__50);
				setState(202); match(T__17);
				setState(203); match(T__45);
				setState(204); match(ID);
				setState(209);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__44) {
					{
					{
					setState(205); match(T__44);
					setState(206); match(ID);
					}
					}
					setState(211);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(212); match(T__3);
				setState(213); match(T__47);
				setState(214); match(ID);
				setState(215); match(T__45);
				setState(216); match(ID);
				setState(221);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__44) {
					{
					{
					setState(217); match(T__44);
					setState(218); match(ID);
					}
					}
					setState(223);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(224); match(T__3);
				}
				break;
			case 3:
				_localctx = new CheckContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(225); match(ID);
				setState(226); match(T__39);
				setState(227); match(T__45);
				setState(228); expression(0);
				setState(229); match(T__3);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Rename_table_statementContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(SqlParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SqlParser.ID, i);
		}
		public Rename_table_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rename_table_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterRename_table_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitRename_table_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitRename_table_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rename_table_statementContext rename_table_statement() throws RecognitionException {
		Rename_table_statementContext _localctx = new Rename_table_statementContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_rename_table_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(233); match(T__6);
			setState(234); match(T__26);
			setState(235); match(ID);
			setState(236); match(T__9);
			setState(237); match(T__10);
			setState(238); match(ID);
			setState(239); match(T__21);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class AccionContext extends ParserRuleContext {
		public AccionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_accion; }
	 
		public AccionContext() { }
		public void copyFrom(AccionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AddColumnContext extends AccionContext {
		public TerminalNode ID() { return getToken(SqlParser.ID, 0); }
		public ConstraintContext constraint() {
			return getRuleContext(ConstraintContext.class,0);
		}
		public Tipo_literalContext tipo_literal() {
			return getRuleContext(Tipo_literalContext.class,0);
		}
		public AddColumnContext(AccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterAddColumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitAddColumn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitAddColumn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DropConstraintContext extends AccionContext {
		public TerminalNode ID() { return getToken(SqlParser.ID, 0); }
		public DropConstraintContext(AccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterDropConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitDropConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDropConstraint(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AddConstraintContext extends AccionContext {
		public ConstraintContext constraint() {
			return getRuleContext(ConstraintContext.class,0);
		}
		public AddConstraintContext(AccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterAddConstraint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitAddConstraint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitAddConstraint(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DropColumnContext extends AccionContext {
		public TerminalNode ID() { return getToken(SqlParser.ID, 0); }
		public DropColumnContext(AccionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterDropColumn(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitDropColumn(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDropColumn(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AccionContext accion() throws RecognitionException {
		AccionContext _localctx = new AccionContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_accion);
		try {
			setState(255);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				_localctx = new AddColumnContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(241); match(T__18);
				setState(242); match(T__28);
				setState(243); match(ID);
				setState(244); tipo_literal();
				{
				setState(245); constraint();
				}
				}
				break;
			case 2:
				_localctx = new AddConstraintContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(247); match(T__18);
				setState(248); constraint();
				}
				break;
			case 3:
				_localctx = new DropColumnContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(249); match(T__13);
				setState(250); match(T__28);
				setState(251); match(ID);
				}
				break;
			case 4:
				_localctx = new DropConstraintContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(252); match(T__13);
				setState(253); match(T__49);
				setState(254); match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Show_table_statementContext extends ParserRuleContext {
		public Show_table_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_show_table_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterShow_table_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitShow_table_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitShow_table_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Show_table_statementContext show_table_statement() throws RecognitionException {
		Show_table_statementContext _localctx = new Show_table_statementContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_show_table_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(257); match(T__31);
			setState(258); match(T__34);
			setState(259); match(T__21);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Show_column_statementContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SqlParser.ID, 0); }
		public Show_column_statementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_show_column_statement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterShow_column_statement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitShow_column_statement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitShow_column_statement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Show_column_statementContext show_column_statement() throws RecognitionException {
		Show_column_statementContext _localctx = new Show_column_statementContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_show_column_statement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(261); match(T__31);
			setState(262); match(T__43);
			setState(263); match(T__48);
			setState(264); match(ID);
			setState(265); match(T__21);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DmlstatementContext extends ParserRuleContext {
		public Delete_valueContext delete_value() {
			return getRuleContext(Delete_valueContext.class,0);
		}
		public Insert_valueContext insert_value() {
			return getRuleContext(Insert_valueContext.class,0);
		}
		public Update_valueContext update_value() {
			return getRuleContext(Update_valueContext.class,0);
		}
		public Select_valueContext select_value() {
			return getRuleContext(Select_valueContext.class,0);
		}
		public DmlstatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dmlstatement; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterDmlstatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitDmlstatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDmlstatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DmlstatementContext dmlstatement() throws RecognitionException {
		DmlstatementContext _localctx = new DmlstatementContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_dmlstatement);
		try {
			setState(271);
			switch (_input.LA(1)) {
			case T__32:
				enterOuterAlt(_localctx, 1);
				{
				setState(267); insert_value();
				}
				break;
			case T__38:
				enterOuterAlt(_localctx, 2);
				{
				setState(268); update_value();
				}
				break;
			case T__37:
				enterOuterAlt(_localctx, 3);
				{
				setState(269); delete_value();
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 4);
				{
				setState(270); select_value();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Insert_valueContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(SqlParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SqlParser.ID, i);
		}
		public List_valuesContext list_values() {
			return getRuleContext(List_valuesContext.class,0);
		}
		public Insert_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_insert_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterInsert_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitInsert_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitInsert_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Insert_valueContext insert_value() throws RecognitionException {
		Insert_valueContext _localctx = new Insert_valueContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_insert_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(273); match(T__32);
			setState(274); match(T__23);
			setState(275); match(ID);
			setState(288);
			_la = _input.LA(1);
			if (_la==T__45) {
				{
				setState(276); match(T__45);
				setState(285);
				_la = _input.LA(1);
				if (_la==ID) {
					{
					{
					setState(277); match(ID);
					}
					setState(282);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__44) {
						{
						{
						setState(278); match(T__44);
						setState(279); match(ID);
						}
						}
						setState(284);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(287); match(T__3);
				}
			}

			setState(290); match(T__40);
			{
			setState(291); list_values();
			}
			setState(292); match(T__21);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Update_valueContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(SqlParser.ID); }
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public TerminalNode ID(int i) {
			return getToken(SqlParser.ID, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Update_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_update_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterUpdate_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitUpdate_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitUpdate_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Update_valueContext update_value() throws RecognitionException {
		Update_valueContext _localctx = new Update_valueContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_update_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294); match(T__38);
			setState(295); match(ID);
			setState(296); match(T__0);
			setState(297); match(ID);
			setState(298); match(T__46);
			setState(299); literal();
			setState(306);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__44) {
				{
				{
				setState(300); match(T__44);
				setState(301); match(ID);
				setState(302); match(T__46);
				setState(303); literal();
				}
				}
				setState(308);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(311);
			_la = _input.LA(1);
			if (_la==T__24) {
				{
				setState(309); match(T__24);
				setState(310); expression(0);
				}
			}

			setState(313); match(T__21);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Delete_valueContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(SqlParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Delete_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delete_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterDelete_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitDelete_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDelete_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Delete_valueContext delete_value() throws RecognitionException {
		Delete_valueContext _localctx = new Delete_valueContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_delete_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(315); match(T__37);
			setState(316); match(T__48);
			setState(317); match(ID);
			setState(320);
			_la = _input.LA(1);
			if (_la==T__24) {
				{
				setState(318); match(T__24);
				setState(319); expression(0);
				}
			}

			setState(322); match(T__21);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Select_valueContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(SqlParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SqlParser.ID, i);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Select_valueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_select_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSelect_value(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSelect_value(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitSelect_value(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Select_valueContext select_value() throws RecognitionException {
		Select_valueContext _localctx = new Select_valueContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_select_value);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(324); match(T__14);
			setState(334);
			switch (_input.LA(1)) {
			case T__15:
				{
				setState(325); match(T__15);
				}
				break;
			case ID:
				{
				setState(326); match(ID);
				setState(331);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__44) {
					{
					{
					setState(327); match(T__44);
					setState(328); match(ID);
					}
					}
					setState(333);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(336); match(T__48);
			setState(337); match(ID);
			setState(340);
			_la = _input.LA(1);
			if (_la==T__24) {
				{
				setState(338); match(T__24);
				setState(339); expression(0);
				}
			}

			setState(345);
			_la = _input.LA(1);
			if (_la==T__16) {
				{
				setState(342); match(T__16);
				setState(343); match(T__25);
				setState(344);
				_la = _input.LA(1);
				if ( !(_la==T__41 || _la==T__2) ) {
				_errHandler.recoverInline(this);
				}
				consume();
				}
			}

			setState(347); match(T__21);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class List_valuesContext extends ParserRuleContext {
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public List_valuesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_list_values; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterList_values(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitList_values(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitList_values(this);
			else return visitor.visitChildren(this);
		}
	}

	public final List_valuesContext list_values() throws RecognitionException {
		List_valuesContext _localctx = new List_valuesContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_list_values);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			_la = _input.LA(1);
			if (_la==T__45) {
				{
				setState(349); match(T__45);
				setState(358);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << NUM) | (1L << FLOAT) | (1L << Char) | (1L << DATE))) != 0)) {
					{
					{
					setState(350); literal();
					}
					setState(355);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__44) {
						{
						{
						setState(351); match(T__44);
						setState(352); literal();
						}
						}
						setState(357);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(360); match(T__3);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LiteralContext extends ParserRuleContext {
		public Int_literalContext int_literal() {
			return getRuleContext(Int_literalContext.class,0);
		}
		public Date_literalContext date_literal() {
			return getRuleContext(Date_literalContext.class,0);
		}
		public Float_literalContext float_literal() {
			return getRuleContext(Float_literalContext.class,0);
		}
		public Char_literalContext char_literal() {
			return getRuleContext(Char_literalContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitLiteral(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_literal);
		try {
			setState(367);
			switch (_input.LA(1)) {
			case NUM:
				enterOuterAlt(_localctx, 1);
				{
				setState(363); int_literal();
				}
				break;
			case FLOAT:
				enterOuterAlt(_localctx, 2);
				{
				setState(364); float_literal();
				}
				break;
			case DATE:
				enterOuterAlt(_localctx, 3);
				{
				setState(365); date_literal();
				}
				break;
			case Char:
				enterOuterAlt(_localctx, 4);
				{
				setState(366); char_literal();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Int_literalContext extends ParserRuleContext {
		public TerminalNode NUM() { return getToken(SqlParser.NUM, 0); }
		public Int_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_int_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterInt_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitInt_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitInt_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Int_literalContext int_literal() throws RecognitionException {
		Int_literalContext _localctx = new Int_literalContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_int_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369); match(NUM);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Float_literalContext extends ParserRuleContext {
		public TerminalNode FLOAT() { return getToken(SqlParser.FLOAT, 0); }
		public Float_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_float_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterFloat_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitFloat_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitFloat_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Float_literalContext float_literal() throws RecognitionException {
		Float_literalContext _localctx = new Float_literalContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_float_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(371); match(FLOAT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Date_literalContext extends ParserRuleContext {
		public TerminalNode DATE() { return getToken(SqlParser.DATE, 0); }
		public Date_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_date_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterDate_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitDate_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitDate_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Date_literalContext date_literal() throws RecognitionException {
		Date_literalContext _localctx = new Date_literalContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_date_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373); match(DATE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Char_literalContext extends ParserRuleContext {
		public TerminalNode Char() { return getToken(SqlParser.Char, 0); }
		public Char_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_char_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterChar_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitChar_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitChar_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Char_literalContext char_literal() throws RecognitionException {
		Char_literalContext _localctx = new Char_literalContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_char_literal);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(375); match(Char);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Rel_opContext extends ParserRuleContext {
		public Rel_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rel_op; }
	 
		public Rel_opContext() { }
		public void copyFrom(Rel_opContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RelLContext extends Rel_opContext {
		public RelLContext(Rel_opContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterRelL(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitRelL(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitRelL(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelLEContext extends Rel_opContext {
		public RelLEContext(Rel_opContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterRelLE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitRelLE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitRelLE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqEContext extends Rel_opContext {
		public EqEContext(Rel_opContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterEqE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitEqE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitEqE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelBEContext extends Rel_opContext {
		public RelBEContext(Rel_opContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterRelBE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitRelBE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitRelBE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqNEContext extends Rel_opContext {
		public EqNEContext(Rel_opContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterEqNE(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitEqNE(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitEqNE(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RekBContext extends Rel_opContext {
		public RekBContext(Rel_opContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterRekB(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitRekB(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitRekB(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rel_opContext rel_op() throws RecognitionException {
		Rel_opContext _localctx = new Rel_opContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_rel_op);
		try {
			setState(383);
			switch (_input.LA(1)) {
			case T__35:
				_localctx = new RelLContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(377); match(T__35);
				}
				break;
			case T__8:
				_localctx = new RekBContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(378); match(T__8);
				}
				break;
			case T__19:
				_localctx = new RelLEContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(379); match(T__19);
				}
				break;
			case T__36:
				_localctx = new RelBEContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(380); match(T__36);
				}
				break;
			case T__46:
				_localctx = new EqEContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(381); match(T__46);
				}
				break;
			case T__33:
				_localctx = new EqNEContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(382); match(T__33);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Rel_op2Context extends ParserRuleContext {
		public Rel_op2Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rel_op2; }
	 
		public Rel_op2Context() { }
		public void copyFrom(Rel_op2Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EqE2Context extends Rel_op2Context {
		public EqE2Context(Rel_op2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterEqE2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitEqE2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitEqE2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelLE2Context extends Rel_op2Context {
		public RelLE2Context(Rel_op2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterRelLE2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitRelLE2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitRelLE2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelL2Context extends Rel_op2Context {
		public RelL2Context(Rel_op2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterRelL2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitRelL2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitRelL2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqNE2Context extends Rel_op2Context {
		public EqNE2Context(Rel_op2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterEqNE2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitEqNE2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitEqNE2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RekB2Context extends Rel_op2Context {
		public RekB2Context(Rel_op2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterRekB2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitRekB2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitRekB2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelBE2Context extends Rel_op2Context {
		public RelBE2Context(Rel_op2Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterRelBE2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitRelBE2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitRelBE2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rel_op2Context rel_op2() throws RecognitionException {
		Rel_op2Context _localctx = new Rel_op2Context(_ctx, getState());
		enterRule(_localctx, 68, RULE_rel_op2);
		try {
			setState(391);
			switch (_input.LA(1)) {
			case T__35:
				_localctx = new RelL2Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(385); match(T__35);
				}
				break;
			case T__8:
				_localctx = new RekB2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(386); match(T__8);
				}
				break;
			case T__19:
				_localctx = new RelLE2Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(387); match(T__19);
				}
				break;
			case T__36:
				_localctx = new RelBE2Context(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(388); match(T__36);
				}
				break;
			case T__46:
				_localctx = new EqE2Context(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(389); match(T__46);
				}
				break;
			case T__33:
				_localctx = new EqNE2Context(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(390); match(T__33);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Rel_op3Context extends ParserRuleContext {
		public Rel_op3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_rel_op3; }
	 
		public Rel_op3Context() { }
		public void copyFrom(Rel_op3Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EqNE3Context extends Rel_op3Context {
		public EqNE3Context(Rel_op3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterEqNE3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitEqNE3(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitEqNE3(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelL3Context extends Rel_op3Context {
		public RelL3Context(Rel_op3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterRelL3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitRelL3(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitRelL3(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EqE3Context extends Rel_op3Context {
		public EqE3Context(Rel_op3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterEqE3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitEqE3(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitEqE3(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelLE3Context extends Rel_op3Context {
		public RelLE3Context(Rel_op3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterRelLE3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitRelLE3(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitRelLE3(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RekB3Context extends Rel_op3Context {
		public RekB3Context(Rel_op3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterRekB3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitRekB3(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitRekB3(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelBE3Context extends Rel_op3Context {
		public RelBE3Context(Rel_op3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterRelBE3(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitRelBE3(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitRelBE3(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Rel_op3Context rel_op3() throws RecognitionException {
		Rel_op3Context _localctx = new Rel_op3Context(_ctx, getState());
		enterRule(_localctx, 70, RULE_rel_op3);
		try {
			setState(399);
			switch (_input.LA(1)) {
			case T__35:
				_localctx = new RelL3Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(393); match(T__35);
				}
				break;
			case T__8:
				_localctx = new RekB3Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(394); match(T__8);
				}
				break;
			case T__19:
				_localctx = new RelLE3Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(395); match(T__19);
				}
				break;
			case T__36:
				_localctx = new RelBE3Context(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(396); match(T__36);
				}
				break;
			case T__46:
				_localctx = new EqE3Context(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(397); match(T__46);
				}
				break;
			case T__33:
				_localctx = new EqNE3Context(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(398); match(T__33);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Cond_opContext extends ParserRuleContext {
		public Cond_opContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond_op; }
	 
		public Cond_opContext() { }
		public void copyFrom(Cond_opContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Cond_op1Context extends Cond_opContext {
		public Cond_op1Context(Cond_opContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterCond_op1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitCond_op1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitCond_op1(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Cond_op2Context extends Cond_opContext {
		public Cond_op2Context(Cond_opContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterCond_op2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitCond_op2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitCond_op2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Cond_opContext cond_op() throws RecognitionException {
		Cond_opContext _localctx = new Cond_opContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_cond_op);
		try {
			setState(403);
			switch (_input.LA(1)) {
			case T__22:
				_localctx = new Cond_op1Context(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(401); match(T__22);
				}
				break;
			case T__7:
				_localctx = new Cond_op2Context(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(402); match(T__7);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Expression2Context extends ExpressionContext {
		public Expr1Context expr1() {
			return getRuleContext(Expr1Context.class,0);
		}
		public Expression2Context(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterExpression2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitExpression2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitExpression2(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expression1Context extends ExpressionContext {
		public Expr1Context expr1() {
			return getRuleContext(Expr1Context.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public Cond_opContext cond_op() {
			return getRuleContext(Cond_opContext.class,0);
		}
		public Expression1Context(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterExpression1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitExpression1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitExpression1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 74;
		enterRecursionRule(_localctx, 74, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new Expression2Context(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(406); expr1(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(414);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Expression1Context(new ExpressionContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_expression);
					setState(408);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(409); cond_op();
					setState(410); expr1(0);
					}
					} 
				}
				setState(416);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,34,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Expr1Context extends ParserRuleContext {
		public Expr1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr1; }
	 
		public Expr1Context() { }
		public void copyFrom(Expr1Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Expr11Context extends Expr1Context {
		public Expr1Context expr1() {
			return getRuleContext(Expr1Context.class,0);
		}
		public Expr3Context expr3() {
			return getRuleContext(Expr3Context.class,0);
		}
		public Cond_opContext cond_op() {
			return getRuleContext(Cond_opContext.class,0);
		}
		public Expr11Context(Expr1Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterExpr11(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitExpr11(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitExpr11(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr12Context extends Expr1Context {
		public Expr3Context expr3() {
			return getRuleContext(Expr3Context.class,0);
		}
		public Expr12Context(Expr1Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterExpr12(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitExpr12(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitExpr12(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr1Context expr1() throws RecognitionException {
		return expr1(0);
	}

	private Expr1Context expr1(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expr1Context _localctx = new Expr1Context(_ctx, _parentState);
		Expr1Context _prevctx = _localctx;
		int _startState = 76;
		enterRecursionRule(_localctx, 76, RULE_expr1, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new Expr12Context(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(418); expr3(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(426);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Expr11Context(new Expr1Context(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_expr1);
					setState(420);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(421); cond_op();
					setState(422); expr3(0);
					}
					} 
				}
				setState(428);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,35,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Expr3Context extends ParserRuleContext {
		public Expr3Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr3; }
	 
		public Expr3Context() { }
		public void copyFrom(Expr3Context ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class Expr31Context extends Expr3Context {
		public Rel_opContext rel_op() {
			return getRuleContext(Rel_opContext.class,0);
		}
		public UnifactorContext unifactor() {
			return getRuleContext(UnifactorContext.class,0);
		}
		public Expr3Context expr3() {
			return getRuleContext(Expr3Context.class,0);
		}
		public Expr31Context(Expr3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterExpr31(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitExpr31(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitExpr31(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr33Context extends Expr3Context {
		public Expr3Context expr3() {
			return getRuleContext(Expr3Context.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public Rel_op2Context rel_op2() {
			return getRuleContext(Rel_op2Context.class,0);
		}
		public Expr33Context(Expr3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterExpr33(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitExpr33(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitExpr33(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr32Context extends Expr3Context {
		public UnifactorContext unifactor() {
			return getRuleContext(UnifactorContext.class,0);
		}
		public Expr32Context(Expr3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterExpr32(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitExpr32(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitExpr32(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class Expr34Context extends Expr3Context {
		public Rel_op3Context rel_op3() {
			return getRuleContext(Rel_op3Context.class,0);
		}
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public Expr3Context expr3() {
			return getRuleContext(Expr3Context.class,0);
		}
		public Expr34Context(Expr3Context ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterExpr34(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitExpr34(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitExpr34(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr3Context expr3() throws RecognitionException {
		return expr3(0);
	}

	private Expr3Context expr3(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Expr3Context _localctx = new Expr3Context(_ctx, _parentState);
		Expr3Context _prevctx = _localctx;
		int _startState = 78;
		enterRecursionRule(_localctx, 78, RULE_expr3, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(435);
			switch (_input.LA(1)) {
			case NUM:
			case FLOAT:
			case Char:
			case DATE:
				{
				_localctx = new Expr34Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(430); literal();
				setState(431); rel_op3();
				setState(432); expr3(1);
				}
				break;
			case T__45:
			case T__20:
			case ID:
				{
				_localctx = new Expr32Context(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(434); unifactor();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(447);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(445);
					switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
					case 1:
						{
						_localctx = new Expr31Context(new Expr3Context(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr3);
						setState(437);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(438); rel_op();
						setState(439); unifactor();
						}
						break;
					case 2:
						{
						_localctx = new Expr33Context(new Expr3Context(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr3);
						setState(441);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(442); rel_op2();
						setState(443); literal();
						}
						break;
					}
					} 
				}
				setState(449);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,38,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class UnifactorContext extends ParserRuleContext {
		public UnifactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unifactor; }
	 
		public UnifactorContext() { }
		public void copyFrom(UnifactorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class UniFactorFactorContext extends UnifactorContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public UniFactorFactorContext(UnifactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterUniFactorFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitUniFactorFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitUniFactorFactor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class UniFactorNotContext extends UnifactorContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public UniFactorNotContext(UnifactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterUniFactorNot(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitUniFactorNot(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitUniFactorNot(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnifactorContext unifactor() throws RecognitionException {
		UnifactorContext _localctx = new UnifactorContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_unifactor);
		try {
			setState(453);
			switch (_input.LA(1)) {
			case T__20:
				_localctx = new UniFactorNotContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(450); match(T__20);
				setState(451); factor();
				}
				break;
			case T__45:
			case ID:
				_localctx = new UniFactorFactorContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(452); factor();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	 
		public FactorContext() { }
		public void copyFrom(FactorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FactorIDContext extends FactorContext {
		public TerminalNode ID() { return getToken(SqlParser.ID, 0); }
		public FactorIDContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterFactorID(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitFactorID(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitFactorID(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FactorExpressionContext extends FactorContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FactorExpressionContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterFactorExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitFactorExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitFactorExpression(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class FactorID2Context extends FactorContext {
		public List<TerminalNode> ID() { return getTokens(SqlParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SqlParser.ID, i);
		}
		public FactorID2Context(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterFactorID2(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitFactorID2(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof SqlVisitor ) return ((SqlVisitor<? extends T>)visitor).visitFactorID2(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_factor);
		try {
			setState(463);
			switch ( getInterpreter().adaptivePredict(_input,40,_ctx) ) {
			case 1:
				_localctx = new FactorExpressionContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(455); match(T__45);
				setState(456); expression(0);
				setState(457); match(T__3);
				}
				break;
			case 2:
				_localctx = new FactorIDContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(459); match(ID);
				}
				break;
			case 3:
				_localctx = new FactorID2Context(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(460); match(ID);
				setState(461);
				matchWildcard();
				setState(462); match(ID);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 37: return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 38: return expr1_sempred((Expr1Context)_localctx, predIndex);
		case 39: return expr3_sempred((Expr3Context)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0: return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr3_sempred(Expr3Context _localctx, int predIndex) {
		switch (predIndex) {
		case 2: return precpred(_ctx, 4);
		case 3: return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr1_sempred(Expr1Context _localctx, int predIndex) {
		switch (predIndex) {
		case 1: return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3@\u01d4\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
		"\2\6\2X\n\2\r\2\16\2Y\3\3\3\3\5\3^\n\3\3\4\3\4\5\4b\n\4\3\5\3\5\5\5f\n"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6r\n\6\3\7\3\7\3\b\3\b\3"+
		"\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\6\t\u0080\n\t\r\t\16\t\u0081\3\t\3\t\3"+
		"\t\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3"+
		"\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\3\17\3\20\3\20\3\20\5\20\u00ab\n\20\3\20\3\20\5\20\u00af\n\20\5"+
		"\20\u00b1\n\20\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u00b9\n\21\3\22\3\22"+
		"\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u00c5\n\23\f\23\16\23\u00c8"+
		"\13\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u00d2\n\23\f\23\16"+
		"\23\u00d5\13\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u00de\n\23\f\23"+
		"\16\23\u00e1\13\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u00ea\n\23"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0102\n\25\3\26\3\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\5\30\u0112\n\30"+
		"\3\31\3\31\3\31\3\31\3\31\3\31\3\31\7\31\u011b\n\31\f\31\16\31\u011e\13"+
		"\31\5\31\u0120\n\31\3\31\5\31\u0123\n\31\3\31\3\31\3\31\3\31\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\7\32\u0133\n\32\f\32\16\32\u0136"+
		"\13\32\3\32\3\32\5\32\u013a\n\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\5"+
		"\33\u0143\n\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\7\34\u014c\n\34\f\34"+
		"\16\34\u014f\13\34\5\34\u0151\n\34\3\34\3\34\3\34\3\34\5\34\u0157\n\34"+
		"\3\34\3\34\3\34\5\34\u015c\n\34\3\34\3\34\3\35\3\35\3\35\3\35\7\35\u0164"+
		"\n\35\f\35\16\35\u0167\13\35\5\35\u0169\n\35\3\35\5\35\u016c\n\35\3\36"+
		"\3\36\3\36\3\36\5\36\u0172\n\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3"+
		"#\3#\3#\3#\5#\u0182\n#\3$\3$\3$\3$\3$\3$\5$\u018a\n$\3%\3%\3%\3%\3%\3"+
		"%\5%\u0192\n%\3&\3&\5&\u0196\n&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\7\'\u019f"+
		"\n\'\f\'\16\'\u01a2\13\'\3(\3(\3(\3(\3(\3(\3(\7(\u01ab\n(\f(\16(\u01ae"+
		"\13(\3)\3)\3)\3)\3)\3)\5)\u01b6\n)\3)\3)\3)\3)\3)\3)\3)\3)\7)\u01c0\n"+
		")\f)\16)\u01c3\13)\3*\3*\3*\5*\u01c8\n*\3+\3+\3+\3+\3+\3+\3+\3+\5+\u01d2"+
		"\n+\3+\2\5LNP,\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64"+
		"\668:<>@BDFHJLNPRT\2\3\4\2\f\f\63\63\u01f0\2W\3\2\2\2\4]\3\2\2\2\6a\3"+
		"\2\2\2\be\3\2\2\2\nq\3\2\2\2\fs\3\2\2\2\16u\3\2\2\2\20z\3\2\2\2\22\u0086"+
		"\3\2\2\2\24\u008b\3\2\2\2\26\u0091\3\2\2\2\30\u0096\3\2\2\2\32\u009e\3"+
		"\2\2\2\34\u00a2\3\2\2\2\36\u00b0\3\2\2\2 \u00b8\3\2\2\2\"\u00ba\3\2\2"+
		"\2$\u00e9\3\2\2\2&\u00eb\3\2\2\2(\u0101\3\2\2\2*\u0103\3\2\2\2,\u0107"+
		"\3\2\2\2.\u0111\3\2\2\2\60\u0113\3\2\2\2\62\u0128\3\2\2\2\64\u013d\3\2"+
		"\2\2\66\u0146\3\2\2\28\u016b\3\2\2\2:\u0171\3\2\2\2<\u0173\3\2\2\2>\u0175"+
		"\3\2\2\2@\u0177\3\2\2\2B\u0179\3\2\2\2D\u0181\3\2\2\2F\u0189\3\2\2\2H"+
		"\u0191\3\2\2\2J\u0195\3\2\2\2L\u0197\3\2\2\2N\u01a3\3\2\2\2P\u01b5\3\2"+
		"\2\2R\u01c7\3\2\2\2T\u01d1\3\2\2\2VX\5\4\3\2WV\3\2\2\2XY\3\2\2\2YW\3\2"+
		"\2\2YZ\3\2\2\2Z\3\3\2\2\2[^\5\6\4\2\\^\5\f\7\2][\3\2\2\2]\\\3\2\2\2^\5"+
		"\3\2\2\2_b\5\b\5\2`b\5\n\6\2a_\3\2\2\2a`\3\2\2\2b\7\3\2\2\2cf\5\16\b\2"+
		"df\5\20\t\2ec\3\2\2\2ed\3\2\2\2f\t\3\2\2\2gr\5\22\n\2hr\5\24\13\2ir\5"+
		"\26\f\2jr\5\30\r\2kr\5\34\17\2lr\5\32\16\2mr\5&\24\2nr\5*\26\2or\5,\27"+
		"\2pr\5.\30\2qg\3\2\2\2qh\3\2\2\2qi\3\2\2\2qj\3\2\2\2qk\3\2\2\2ql\3\2\2"+
		"\2qm\3\2\2\2qn\3\2\2\2qo\3\2\2\2qp\3\2\2\2r\13\3\2\2\2st\5\66\34\2t\r"+
		"\3\2\2\2uv\7\27\2\2vw\7\64\2\2wx\7:\2\2xy\7 \2\2y\17\3\2\2\2z{\7\27\2"+
		"\2{|\7\33\2\2|}\7:\2\2}\177\7\b\2\2~\u0080\5\36\20\2\177~\3\2\2\2\u0080"+
		"\u0081\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\u0083\3\2\2"+
		"\2\u0083\u0084\7\62\2\2\u0084\u0085\7 \2\2\u0085\21\3\2\2\2\u0086\u0087"+
		"\7(\2\2\u0087\u0088\7\64\2\2\u0088\u0089\7:\2\2\u0089\u008a\7 \2\2\u008a"+
		"\23\3\2\2\2\u008b\u008c\7/\2\2\u008c\u008d\7\33\2\2\u008d\u008e\7:\2\2"+
		"\u008e\u008f\5(\25\2\u008f\u0090\7 \2\2\u0090\25\3\2\2\2\u0091\u0092\7"+
		"(\2\2\u0092\u0093\7\33\2\2\u0093\u0094\7:\2\2\u0094\u0095\7 \2\2\u0095"+
		"\27\3\2\2\2\u0096\u0097\7/\2\2\u0097\u0098\7\64\2\2\u0098\u0099\7:\2\2"+
		"\u0099\u009a\7,\2\2\u009a\u009b\7+\2\2\u009b\u009c\7:\2\2\u009c\u009d"+
		"\7 \2\2\u009d\31\3\2\2\2\u009e\u009f\7\26\2\2\u009f\u00a0\7\32\2\2\u00a0"+
		"\u00a1\7 \2\2\u00a1\33\3\2\2\2\u00a2\u00a3\7\60\2\2\u00a3\u00a4\7\64\2"+
		"\2\u00a4\u00a5\7:\2\2\u00a5\u00a6\7 \2\2\u00a6\35\3\2\2\2\u00a7\u00a8"+
		"\7:\2\2\u00a8\u00aa\5 \21\2\u00a9\u00ab\7\t\2\2\u00aa\u00a9\3\2\2\2\u00aa"+
		"\u00ab\3\2\2\2\u00ab\u00b1\3\2\2\2\u00ac\u00ae\5\"\22\2\u00ad\u00af\7"+
		"\t\2\2\u00ae\u00ad\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b1\3\2\2\2\u00b0"+
		"\u00a7\3\2\2\2\u00b0\u00ac\3\2\2\2\u00b1\37\3\2\2\2\u00b2\u00b9\7*\2\2"+
		"\u00b3\u00b9\7\61\2\2\u00b4\u00b5\7\30\2\2\u00b5\u00b6\7;\2\2\u00b6\u00b9"+
		"\7\62\2\2\u00b7\u00b9\7)\2\2\u00b8\u00b2\3\2\2\2\u00b8\u00b3\3\2\2\2\u00b8"+
		"\u00b4\3\2\2\2\u00b8\u00b7\3\2\2\2\u00b9!\3\2\2\2\u00ba\u00bb\7\4\2\2"+
		"\u00bb\u00bc\5$\23\2\u00bc#\3\2\2\2\u00bd\u00be\7:\2\2\u00be\u00bf\7\13"+
		"\2\2\u00bf\u00c0\7$\2\2\u00c0\u00c1\7\b\2\2\u00c1\u00c6\7:\2\2\u00c2\u00c3"+
		"\7\t\2\2\u00c3\u00c5\7:\2\2\u00c4\u00c2\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6"+
		"\u00c4\3\2\2\2\u00c6\u00c7\3\2\2\2\u00c7\u00c9\3\2\2\2\u00c8\u00c6\3\2"+
		"\2\2\u00c9\u00ea\7\62\2\2\u00ca\u00cb\7:\2\2\u00cb\u00cc\7\3\2\2\u00cc"+
		"\u00cd\7$\2\2\u00cd\u00ce\7\b\2\2\u00ce\u00d3\7:\2\2\u00cf\u00d0\7\t\2"+
		"\2\u00d0\u00d2\7:\2\2\u00d1\u00cf\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1"+
		"\3\2\2\2\u00d3\u00d4\3\2\2\2\u00d4\u00d6\3\2\2\2\u00d5\u00d3\3\2\2\2\u00d6"+
		"\u00d7\7\62\2\2\u00d7\u00d8\7\6\2\2\u00d8\u00d9\7:\2\2\u00d9\u00da\7\b"+
		"\2\2\u00da\u00df\7:\2\2\u00db\u00dc\7\t\2\2\u00dc\u00de\7:\2\2\u00dd\u00db"+
		"\3\2\2\2\u00de\u00e1\3\2\2\2\u00df\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0"+
		"\u00e2\3\2\2\2\u00e1\u00df\3\2\2\2\u00e2\u00ea\7\62\2\2\u00e3\u00e4\7"+
		":\2\2\u00e4\u00e5\7\16\2\2\u00e5\u00e6\7\b\2\2\u00e6\u00e7\5L\'\2\u00e7"+
		"\u00e8\7\62\2\2\u00e8\u00ea\3\2\2\2\u00e9\u00bd\3\2\2\2\u00e9\u00ca\3"+
		"\2\2\2\u00e9\u00e3\3\2\2\2\u00ea%\3\2\2\2\u00eb\u00ec\7/\2\2\u00ec\u00ed"+
		"\7\33\2\2\u00ed\u00ee\7:\2\2\u00ee\u00ef\7,\2\2\u00ef\u00f0\7+\2\2\u00f0"+
		"\u00f1\7:\2\2\u00f1\u00f2\7 \2\2\u00f2\'\3\2\2\2\u00f3\u00f4\7#\2\2\u00f4"+
		"\u00f5\7\31\2\2\u00f5\u00f6\7:\2\2\u00f6\u00f7\5 \21\2\u00f7\u00f8\5\""+
		"\22\2\u00f8\u0102\3\2\2\2\u00f9\u00fa\7#\2\2\u00fa\u0102\5\"\22\2\u00fb"+
		"\u00fc\7(\2\2\u00fc\u00fd\7\31\2\2\u00fd\u0102\7:\2\2\u00fe\u00ff\7(\2"+
		"\2\u00ff\u0100\7\4\2\2\u0100\u0102\7:\2\2\u0101\u00f3\3\2\2\2\u0101\u00f9"+
		"\3\2\2\2\u0101\u00fb\3\2\2\2\u0101\u00fe\3\2\2\2\u0102)\3\2\2\2\u0103"+
		"\u0104\7\26\2\2\u0104\u0105\7\23\2\2\u0105\u0106\7 \2\2\u0106+\3\2\2\2"+
		"\u0107\u0108\7\26\2\2\u0108\u0109\7\n\2\2\u0109\u010a\7\5\2\2\u010a\u010b"+
		"\7:\2\2\u010b\u010c\7 \2\2\u010c-\3\2\2\2\u010d\u0112\5\60\31\2\u010e"+
		"\u0112\5\62\32\2\u010f\u0112\5\64\33\2\u0110\u0112\5\66\34\2\u0111\u010d"+
		"\3\2\2\2\u0111\u010e\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0110\3\2\2\2\u0112"+
		"/\3\2\2\2\u0113\u0114\7\25\2\2\u0114\u0115\7\36\2\2\u0115\u0122\7:\2\2"+
		"\u0116\u011f\7\b\2\2\u0117\u011c\7:\2\2\u0118\u0119\7\t\2\2\u0119\u011b"+
		"\7:\2\2\u011a\u0118\3\2\2\2\u011b\u011e\3\2\2\2\u011c\u011a\3\2\2\2\u011c"+
		"\u011d\3\2\2\2\u011d\u0120\3\2\2\2\u011e\u011c\3\2\2\2\u011f\u0117\3\2"+
		"\2\2\u011f\u0120\3\2\2\2\u0120\u0121\3\2\2\2\u0121\u0123\7\62\2\2\u0122"+
		"\u0116\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0124\3\2\2\2\u0124\u0125\7\r"+
		"\2\2\u0125\u0126\58\35\2\u0126\u0127\7 \2\2\u0127\61\3\2\2\2\u0128\u0129"+
		"\7\17\2\2\u0129\u012a\7:\2\2\u012a\u012b\7\65\2\2\u012b\u012c\7:\2\2\u012c"+
		"\u012d\7\7\2\2\u012d\u0134\5:\36\2\u012e\u012f\7\t\2\2\u012f\u0130\7:"+
		"\2\2\u0130\u0131\7\7\2\2\u0131\u0133\5:\36\2\u0132\u012e\3\2\2\2\u0133"+
		"\u0136\3\2\2\2\u0134\u0132\3\2\2\2\u0134\u0135\3\2\2\2\u0135\u0139\3\2"+
		"\2\2\u0136\u0134\3\2\2\2\u0137\u0138\7\35\2\2\u0138\u013a\5L\'\2\u0139"+
		"\u0137\3\2\2\2\u0139\u013a\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013c\7 "+
		"\2\2\u013c\63\3\2\2\2\u013d\u013e\7\20\2\2\u013e\u013f\7\5\2\2\u013f\u0142"+
		"\7:\2\2\u0140\u0141\7\35\2\2\u0141\u0143\5L\'\2\u0142\u0140\3\2\2\2\u0142"+
		"\u0143\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0145\7 \2\2\u0145\65\3\2\2\2"+
		"\u0146\u0150\7\'\2\2\u0147\u0151\7&\2\2\u0148\u014d\7:\2\2\u0149\u014a"+
		"\7\t\2\2\u014a\u014c\7:\2\2\u014b\u0149\3\2\2\2\u014c\u014f\3\2\2\2\u014d"+
		"\u014b\3\2\2\2\u014d\u014e\3\2\2\2\u014e\u0151\3\2\2\2\u014f\u014d\3\2"+
		"\2\2\u0150\u0147\3\2\2\2\u0150\u0148\3\2\2\2\u0151\u0152\3\2\2\2\u0152"+
		"\u0153\7\5\2\2\u0153\u0156\7:\2\2\u0154\u0155\7\35\2\2\u0155\u0157\5L"+
		"\'\2\u0156\u0154\3\2\2\2\u0156\u0157\3\2\2\2\u0157\u015b\3\2\2\2\u0158"+
		"\u0159\7%\2\2\u0159\u015a\7\34\2\2\u015a\u015c\t\2\2\2\u015b\u0158\3\2"+
		"\2\2\u015b\u015c\3\2\2\2\u015c\u015d\3\2\2\2\u015d\u015e\7 \2\2\u015e"+
		"\67\3\2\2\2\u015f\u0168\7\b\2\2\u0160\u0165\5:\36\2\u0161\u0162\7\t\2"+
		"\2\u0162\u0164\5:\36\2\u0163\u0161\3\2\2\2\u0164\u0167\3\2\2\2\u0165\u0163"+
		"\3\2\2\2\u0165\u0166\3\2\2\2\u0166\u0169\3\2\2\2\u0167\u0165\3\2\2\2\u0168"+
		"\u0160\3\2\2\2\u0168\u0169\3\2\2\2\u0169\u016a\3\2\2\2\u016a\u016c\7\62"+
		"\2\2\u016b\u015f\3\2\2\2\u016b\u016c\3\2\2\2\u016c9\3\2\2\2\u016d\u0172"+
		"\5<\37\2\u016e\u0172\5> \2\u016f\u0172\5@!\2\u0170\u0172\5B\"\2\u0171"+
		"\u016d\3\2\2\2\u0171\u016e\3\2\2\2\u0171\u016f\3\2\2\2\u0171\u0170\3\2"+
		"\2\2\u0172;\3\2\2\2\u0173\u0174\7;\2\2\u0174=\3\2\2\2\u0175\u0176\7<\2"+
		"\2\u0176?\3\2\2\2\u0177\u0178\7>\2\2\u0178A\3\2\2\2\u0179\u017a\7=\2\2"+
		"\u017aC\3\2\2\2\u017b\u0182\7\22\2\2\u017c\u0182\7-\2\2\u017d\u0182\7"+
		"\"\2\2\u017e\u0182\7\21\2\2\u017f\u0182\7\7\2\2\u0180\u0182\7\24\2\2\u0181"+
		"\u017b\3\2\2\2\u0181\u017c\3\2\2\2\u0181\u017d\3\2\2\2\u0181\u017e\3\2"+
		"\2\2\u0181\u017f\3\2\2\2\u0181\u0180\3\2\2\2\u0182E\3\2\2\2\u0183\u018a"+
		"\7\22\2\2\u0184\u018a\7-\2\2\u0185\u018a\7\"\2\2\u0186\u018a\7\21\2\2"+
		"\u0187\u018a\7\7\2\2\u0188\u018a\7\24\2\2\u0189\u0183\3\2\2\2\u0189\u0184"+
		"\3\2\2\2\u0189\u0185\3\2\2\2\u0189\u0186\3\2\2\2\u0189\u0187\3\2\2\2\u0189"+
		"\u0188\3\2\2\2\u018aG\3\2\2\2\u018b\u0192\7\22\2\2\u018c\u0192\7-\2\2"+
		"\u018d\u0192\7\"\2\2\u018e\u0192\7\21\2\2\u018f\u0192\7\7\2\2\u0190\u0192"+
		"\7\24\2\2\u0191\u018b\3\2\2\2\u0191\u018c\3\2\2\2\u0191\u018d\3\2\2\2"+
		"\u0191\u018e\3\2\2\2\u0191\u018f\3\2\2\2\u0191\u0190\3\2\2\2\u0192I\3"+
		"\2\2\2\u0193\u0196\7\37\2\2\u0194\u0196\7.\2\2\u0195\u0193\3\2\2\2\u0195"+
		"\u0194\3\2\2\2\u0196K\3\2\2\2\u0197\u0198\b\'\1\2\u0198\u0199\5N(\2\u0199"+
		"\u01a0\3\2\2\2\u019a\u019b\f\4\2\2\u019b\u019c\5J&\2\u019c\u019d\5N(\2"+
		"\u019d\u019f\3\2\2\2\u019e\u019a\3\2\2\2\u019f\u01a2\3\2\2\2\u01a0\u019e"+
		"\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1M\3\2\2\2\u01a2\u01a0\3\2\2\2\u01a3"+
		"\u01a4\b(\1\2\u01a4\u01a5\5P)\2\u01a5\u01ac\3\2\2\2\u01a6\u01a7\f\4\2"+
		"\2\u01a7\u01a8\5J&\2\u01a8\u01a9\5P)\2\u01a9\u01ab\3\2\2\2\u01aa\u01a6"+
		"\3\2\2\2\u01ab\u01ae\3\2\2\2\u01ac\u01aa\3\2\2\2\u01ac\u01ad\3\2\2\2\u01ad"+
		"O\3\2\2\2\u01ae\u01ac\3\2\2\2\u01af\u01b0\b)\1\2\u01b0\u01b1\5:\36\2\u01b1"+
		"\u01b2\5H%\2\u01b2\u01b3\5P)\3\u01b3\u01b6\3\2\2\2\u01b4\u01b6\5R*\2\u01b5"+
		"\u01af\3\2\2\2\u01b5\u01b4\3\2\2\2\u01b6\u01c1\3\2\2\2\u01b7\u01b8\f\6"+
		"\2\2\u01b8\u01b9\5D#\2\u01b9\u01ba\5R*\2\u01ba\u01c0\3\2\2\2\u01bb\u01bc"+
		"\f\4\2\2\u01bc\u01bd\5F$\2\u01bd\u01be\5:\36\2\u01be\u01c0\3\2\2\2\u01bf"+
		"\u01b7\3\2\2\2\u01bf\u01bb\3\2\2\2\u01c0\u01c3\3\2\2\2\u01c1\u01bf\3\2"+
		"\2\2\u01c1\u01c2\3\2\2\2\u01c2Q\3\2\2\2\u01c3\u01c1\3\2\2\2\u01c4\u01c5"+
		"\7!\2\2\u01c5\u01c8\5T+\2\u01c6\u01c8\5T+\2\u01c7\u01c4\3\2\2\2\u01c7"+
		"\u01c6\3\2\2\2\u01c8S\3\2\2\2\u01c9\u01ca\7\b\2\2\u01ca\u01cb\5L\'\2\u01cb"+
		"\u01cc\7\62\2\2\u01cc\u01d2\3\2\2\2\u01cd\u01d2\7:\2\2\u01ce\u01cf\7:"+
		"\2\2\u01cf\u01d0\13\2\2\2\u01d0\u01d2\7:\2\2\u01d1\u01c9\3\2\2\2\u01d1"+
		"\u01cd\3\2\2\2\u01d1\u01ce\3\2\2\2\u01d2U\3\2\2\2+Y]aeq\u0081\u00aa\u00ae"+
		"\u00b0\u00b8\u00c6\u00d3\u00df\u00e9\u0101\u0111\u011c\u011f\u0122\u0134"+
		"\u0139\u0142\u014d\u0150\u0156\u015b\u0165\u0168\u016b\u0171\u0181\u0189"+
		"\u0191\u0195\u01a0\u01ac\u01b5\u01bf\u01c1\u01c7\u01d1";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}