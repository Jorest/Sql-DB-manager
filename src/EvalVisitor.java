
public class EvalVisitor<T> extends SqlBaseVisitor<Object> {
	
	
	//*** Todo visitor va de esta forma, podemos retornos cualquier cosa
	  public T visitSql2003Parser (SqlParser.Sql2003ParserContext ctx) {
		  
		  return (T)"";
	  }
	
	

	
}
