import java.util.ArrayList;

import org.antlr.v4.runtime.misc.NotNull;

public class EvalVisitor<T> extends SqlBaseVisitor<Object> {
	
	
	//*** Todo visitor va de esta forma, podemos retornos cualquier cosa
	@Override  
	public T visitSql2003Parser (SqlParser.Sql2003ParserContext ctx) {
		  
		  return (T)"";
	  }
	
	
	
	
	
	
	//Regresaremos un arraylist de datos 
	@Override 
	public T visitList_values(SqlParser.List_valuesContext ctx) {
		ArrayList<Dato> values = new ArrayList<Dato>() ;
		for (int i = 0;i<ctx.getChildCount();i++){
			if(! ctx.getChild(i).getText().equals(",")){
				Dato value = (Dato) visit(ctx.getChild(i));
				values.add(value);
			}
		}
		return (T) values ;
	}
	
	
	
	@Override 
	public T visitTipo_literal(SqlParser.Tipo_literalContext ctx) {
		return (T)ctx.getText();
	}
	//-----Todas las formas basicas de los tipos -----------
	
		@Override 
		public T visitInt_literal(SqlParser.Int_literalContext ctx) {
			Dato dato = new Dato() ;
			dato.setInteger(Integer.parseInt(ctx.getText()));
			return (T) dato ;
		}
		
		@Override 
		public T visitFloat_literal(SqlParser.Float_literalContext ctx) {
			Dato dato = new Dato() ;
			dato.setFloating(Float.parseFloat(ctx.getText()));
			return (T) dato ;
		}
		
		@Override
		public T visitDate_literal(SqlParser.Date_literalContext ctx) {
			Dato dato = new Dato() ;
			dato.setDate(ctx.getText());
			return (T) dato ;
		}
	// falta el visitChar_literal
	
				
		@Override
		public T visitValue(SqlParser.ValueContext ctx) {
			Dato dato = new Dato() ;
			dato= (Dato)visit(ctx.getChild(0));
			return (T) dato ;
		}
		
		//-----Todas las formas basicas de los tipos -----------	
		
		
}
