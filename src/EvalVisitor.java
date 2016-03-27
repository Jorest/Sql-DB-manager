import org.antlr.v4.runtime.misc.NotNull;

public class EvalVisitor<T>  extends 	SqlBaseVisitor<Object>  {

	//Este es el primer visitor , asi debemos escrbir el resto
	 public T visitSql2003Parser(SqlParser.Sql2003ParserContext ctx) {
		 
		 return (T) "" ; 
	 }
	
	
	
}
