import java.util.ArrayList;
public class EvalVisitor<T> extends SqlBaseVisitor<Object> {
	
	ControladorDB controlador = new ControladorDB() ;
	
	
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
	
	//alter database
        public T visitAlter_database_statement( SqlParser.Alter_database_statementContext ctx) { 
            controlador.alterDB(ctx.getChild(2).getText(), ctx.getChild(5).getText());
            return null;
        } 
        //drop database
        public T visitDrop_schema_statement(SqlParser.Drop_schema_statementContext ctx) { 
            controlador.dropDB(ctx.getChild(2).getText());
            return null;
        }
        
        //show databases
        public T visitShow_schema_statement(SqlParser.Show_schema_statementContext ctx) { 
            return (T)controlador.showTables();
        }
        //use database
        public T visitUse_schema_statement(SqlParser.Use_schema_statementContext ctx) { 
            controlador.useDB(ctx.getChild(2).getText());
            return null; 
        }
        
        //create table 
         public T visitTable_definition(SqlParser.Table_definitionContext ctx) { 
             //controlador.createT();
             
             return null;  
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
		//tengo que quitarle las orillas -----------------------------------------------
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
		public T visitFactorLiteral(SqlParser.FactorLiteralContext ctx) {
			Dato dato = new Dato() ;
			dato= (Dato)visit(ctx.getChild(0));
			return (T) dato ;
		}
		
		@Override
		public T visitFactorID(SqlParser.FactorIDContext ctx) {
			Dato dato = new Dato() ;
			dato.setId(ctx.getText());
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
		//expr3
		@Override
		public T visitExpr32(SqlParser.Expr32Context ctx) {
			Dato dato = new Dato() ;
			dato= (Dato)visit(ctx.getChild(0));
			return (T) dato ;
		}
		@Override
		public T visitExpr31(SqlParser.Expr31Context ctx) {
			Dato dato = (Dato) visit(ctx.getChild(1));
			return (T)dato ;
		}
		//----- rel_op operqadores 
		
		@Override
		public T visitRelL(SqlParser.RelLContext ctx) {
			Dato dato1 = (Dato) ctx.getParent().getChild(0);
			Dato dato2 = (Dato) ctx.getParent().getChild(2);
			Dato newdato =new Dato() ;
			
			switch (dato1.getTipo()) {
            case "int": 
            	if (dato1.getInteger()<dato2.getInteger()){
			 		newdato.setBool(true) ;
			 	}
			 	else newdato.setBool(false) ;
            	newdato.setTipo("bool");
                break;
          
            case "float": 
            	if (dato1.getFloating()<dato2.getFloating()){
			 		newdato.setBool(true) ;
			 	}
			 	else newdato.setBool(false) ;
            	newdato.setTipo("bool");
                break;
			}
				
			return (T) newdato ;
		}
		@Override
		public T visitRekB(SqlParser.RekBContext ctx) {
			Dato dato1 = (Dato) ctx.getParent().getChild(0);
			Dato dato2 = (Dato) ctx.getParent().getChild(2);
			Dato newdato =new Dato() ;
			switch (dato1.getTipo()) {
            case "int": 
            	if (dato1.getInteger()>dato2.getInteger()){
			 		newdato.setBool(true) ;
			 	}
			 	else newdato.setBool(false) ;
            	newdato.setTipo("bool");
                break;
          
            case "float": 
            	if (dato1.getFloating()>dato2.getFloating()){
			 		newdato.setBool(true) ;
			 	}
			 	else newdato.setBool(false) ;
            	newdato.setTipo("bool");
                break;
			}
			return (T) newdato ;
		}
		@Override
		public T visitRelLE(SqlParser.RelLEContext ctx) {
			Dato dato1 = (Dato) ctx.getParent().getChild(0);
			Dato dato2 = (Dato) ctx.getParent().getChild(2);
			Dato newdato =new Dato() ;
			
			switch (dato1.getTipo()) {
            case "int": 
            	if (dato1.getInteger()<=dato2.getInteger()){
			 		newdato.setBool(true) ;
			 	}
			 	else newdato.setBool(false) ;
            	newdato.setTipo("bool");
                break;
          
            case "float": 
            	if (dato1.getFloating()<=dato2.getFloating()){
			 		newdato.setBool(true) ;
			 	}
			 	else newdato.setBool(false) ;
            	newdato.setTipo("bool");
                break;
			}
				
			return (T) newdato ;
		}
		
		@Override
		public T visitRelBE(SqlParser.RelBEContext ctx) {
			Dato dato1 = (Dato) ctx.getParent().getChild(0);
			Dato dato2 = (Dato) ctx.getParent().getChild(2);
			Dato newdato =new Dato() ;
			
			switch (dato1.getTipo()) {
            case "int": 
            	if (dato1.getInteger()>=dato2.getInteger()){
			 		newdato.setBool(true) ;
			 	}
			 	else newdato.setBool(false) ;
            	newdato.setTipo("bool");
                break;
          
            case "float": 
            	if (dato1.getFloating()>=dato2.getFloating()){
			 		newdato.setBool(true) ;
			 	}
			 	else newdato.setBool(false) ;
            	newdato.setTipo("bool");
                break;
			}
				
			return (T) newdato ;
		}
		
		
		
		
		//--------eq_op operadores 
		
		@Override
		public T visitEqE(SqlParser.EqEContext ctx) {
			Dato dato1 = (Dato) ctx.getParent().getChild(0);
			Dato dato2 = (Dato) ctx.getParent().getChild(2);
			Dato newdato =new Dato() ;
			
			switch (dato1.getTipo()) {
            case "int": 
            	if (dato1.getInteger()==dato2.getInteger()){
			 		newdato.setBool(true) ;
			 	}
			 	else newdato.setBool(false) ;
            	newdato.setTipo("bool");
                break;
          
            case "float": 
            	if (dato1.getFloating()==dato2.getFloating()){
			 		newdato.setBool(true) ;
			 	}
			 	else newdato.setBool(false) ;
            	newdato.setTipo("bool");
                break;
                
            case "char": 
            	if (dato1.getCharacter().equals(dato2.getCharacter())){
			 		newdato.setBool(true) ;
			 	}
			 	else newdato.setBool(false) ;
            	newdato.setTipo("bool");
                break;
         
            case "date": 
            	if (dato1.getCharacter().equals(dato2.getCharacter())){
			 		newdato.setBool(true) ;
			 	}
			 	else newdato.setBool(false) ;
            	newdato.setTipo("bool");
                break;
                
            default: 
            	System.out.println("eror eqE dato no reconocido");
            	newdato.setBool(false) ;
            	newdato.setTipo("bool");
                break;
          
        }


				
			return (T) newdato ;
		}
		
		
		@Override
		public T visitEqNE(SqlParser.EqNEContext ctx) {
			Dato dato1 = (Dato) ctx.getParent().getChild(0);
			Dato dato2 = (Dato) ctx.getParent().getChild(2);
			Dato newdato =new Dato() ;
			
			switch (dato1.getTipo()) {
            case "int": 
            	if (!(dato1.getInteger()==dato2.getInteger())){
			 		newdato.setBool(true) ;
			 	}
			 	else newdato.setBool(false) ;
            	newdato.setTipo("bool");
                break;
          
            case "float": 
            	if (!(dato1.getFloating()==dato2.getFloating())){
			 		newdato.setBool(true) ;
			 	}
			 	else newdato.setBool(false) ;
            	newdato.setTipo("bool");
                break;
                
            case "char": 
            	if (!(dato1.getCharacter().equals(dato2.getCharacter()))){
			 		newdato.setBool(true) ;
			 	}
			 	else newdato.setBool(false) ;
            	newdato.setTipo("bool");
                break;
         
            case "date": 
            	if (!(dato1.getCharacter().equals(dato2.getCharacter()))){
			 		newdato.setBool(true) ;
			 	}
			 	else newdato.setBool(false) ;
            	newdato.setTipo("bool");
                break;
                
            default: 
            	System.out.println("eror eqE dato no reconocido");
            	newdato.setBool(false) ;
            	newdato.setTipo("bool");
                break;
          
        }


				
			return (T) newdato ;
		}

		// expr2
		@Override
		public T visitExpr22(SqlParser.Expr22Context ctx) {
			Dato dato = new Dato() ;
			dato= (Dato)visit(ctx.getChild(0));
			return (T) dato ;
		}
		@Override
		public T visitExpr21(SqlParser.Expr21Context ctx) {
			Dato dato = (Dato) visit(ctx.getChild(1));
			return (T)dato ;
		}
		
		
}


