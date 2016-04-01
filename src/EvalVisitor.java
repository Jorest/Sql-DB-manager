import java.util.ArrayList;

import org.antlr.v4.runtime.misc.NotNull;

public class EvalVisitor<T> extends SqlBaseVisitor<Object> {
	
	Controlador controlador = new Controlador() ;
	
	
	//*** Todo visitor va de esta forma, podemos retornos cualquier cosa
	//progam es el la raiz de los demas visitors
	
	@Override  
	public T visitProgram (SqlParser.ProgramContext ctx) {
		for (int i = 0;i<ctx.getChildCount();i++){
	         //  visito todas los hijos
			visit(ctx.getChild(i));
	            }  

		  return (T)"";
	  }
	
	//******************EJERCICIO #1: DDL**************************
	@Override 
	public T visitSql_schema_definition_statement(SqlParser.Sql_schema_definition_statementContext ctx) {
		controlador.createDB(ctx.getChild(2).getText());
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
	
	//-----Todas las formas basicas de los tipos -----------	
	
	@Override 
	public T visitTipo_literal(SqlParser.Tipo_literalContext ctx) {
		return (T)ctx.getText();
	}
	
		@Override 
		public T visitInt_literal(SqlParser.Int_literalContext ctx) {
			Dato dato = new Dato() ;
			dato.setTipo("int");
			dato.setInteger(Integer.parseInt(ctx.getText()));
			return (T) dato ;
		}
		
		@Override 
		public T visitFloat_literal(SqlParser.Float_literalContext ctx) {
			Dato dato = new Dato() ;
			dato.setTipo("float");
			dato.setFloating(Float.parseFloat(ctx.getText()));
			return (T) dato ;
		}
		@Override 
		public T visitChar_literal(SqlParser.Char_literalContext ctx) {
			Dato dato = new Dato() ;
			dato.setTipo("char");
			dato.setCharacter(ctx.getText());
			return (T) dato ;
		}
		
		@Override
		public T visitDate_literal(SqlParser.Date_literalContext ctx) {
			Dato dato = new Dato() ;
			dato.setTipo("date");
			dato.setDate(ctx.getText());
			return (T) dato ;
		}
	
				


		//----- todas las expresiones ---------------------
		
		@Override
		public T visitLiteral(SqlParser.LiteralContext ctx) {
			Dato dato = new Dato() ;
			dato= (Dato)visit(ctx.getChild(0));
			return (T) dato ;
		}
		@Override
		public T visitFactorExpression(SqlParser.FactorExpressionContext ctx) {
			Dato dato = new Dato() ;
			dato= (Dato)visit(ctx.getChild(1));
			return (T) dato ;
		}
		
		@Override
		public T visitUniFactorNot(SqlParser.UniFactorNotContext ctx) {
			Dato dato = new Dato() ;
			dato= (Dato)visit(ctx.getChild(1));
			dato.setBool(!dato.getBool());
			return (T) dato ;
		}
		@Override
		public T visitUniFactorFactor(SqlParser.UniFactorFactorContext ctx) {
			Dato dato = new Dato() ;
			dato= (Dato)visit(ctx.getChild(1));
			return (T) dato ;
		}
		@Override
		public T visitExpr32(SqlParser.Expr32Context ctx) {
			Dato dato = new Dato() ;
			dato= (Dato)visit(ctx.getChild(0));
			return (T) dato ;
		}
		@Override
		public T visitRelL(SqlParser.RelLContext ctx) {
			Dato dato1 = (Dato) ctx.getParent().getChild(0);
			Dato dato2 = (Dato) ctx.getParent().getChild(2);
			Dato newdato =new Dato() ;
			
			if (dato1.getTipo().equals("float")|dato1.getTipo().equals("float")){
				if (dato1.getInteger()<dato2.getInteger()){
			 		newdato.setBool(true) ;
			 	}
			 	else newdato.setBool(false) ;
	           
			}
			else  newdato.setBool(false) ;
				
			return (T) newdato ;
		}
		@Override
		public T visitRekB(SqlParser.RekBContext ctx) {
			Dato dato1 = (Dato) ctx.getParent().getChild(0);
			Dato dato2 = (Dato) ctx.getParent().getChild(2);
			Dato newdato =new Dato() ;
			
			if (dato1.getTipo().equals("float")|dato1.getTipo().equals("float")){
				if (dato1.getInteger()>dato2.getInteger()){
			 		newdato.setBool(true) ;
			 	}
			 	else newdato.setBool(false) ;
	           
			}
			else  newdato.setBool(false) ;
				
			return (T) newdato ;
		}
		@Override
		public T visitRelLE(SqlParser.RelLEContext ctx) {
			Dato dato1 = (Dato) ctx.getParent().getChild(0);
			Dato dato2 = (Dato) ctx.getParent().getChild(2);
			Dato newdato =new Dato() ;
			
			if (dato1.getTipo().equals("float")|dato1.getTipo().equals("float")){
				if (dato1.getInteger()<=dato2.getInteger()){
			 		newdato.setBool(true) ;
			 	}
			 	else newdato.setBool(false) ;
	           
			}
			else  newdato.setBool(false) ;
				
			return (T) newdato ;
		}
		
		@Override
		public T visitRelBE(SqlParser.RelBEContext ctx) {
			Dato dato1 = (Dato) ctx.getParent().getChild(0);
			Dato dato2 = (Dato) ctx.getParent().getChild(2);
			Dato newdato =new Dato() ;
			
			if (dato1.getTipo().equals("float")|dato1.getTipo().equals("float")){
				if (dato1.getInteger()>=dato2.getInteger()){
			 		newdato.setBool(true) ;
			 	}
			 	else newdato.setBool(false) ;
	           
			}
			else  newdato.setBool(false) ;
				
			return (T) newdato ;
		}
		
		@Override
		public T visitExpr31(SqlParser.Expr31Context ctx) {
			Dato dato = (Dato) visit(ctx.getChild(1));
			return (T)dato ;
		}

		
	
}


