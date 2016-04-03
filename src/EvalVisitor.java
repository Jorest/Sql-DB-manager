import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.antlr.v4.runtime.misc.NotNull;
public class EvalVisitor<T> extends SqlBaseVisitor<Object> {
        private Tabla actual; 
	
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
        @Override
        public T visitAlter_database_statement( SqlParser.Alter_database_statementContext ctx) { 
            controlador.alterDB(ctx.getChild(2).getText(), ctx.getChild(5).getText());
            return null;
        } 
        //drop database
        @Override
        public T visitDrop_schema_statement(SqlParser.Drop_schema_statementContext ctx) { 
            controlador.dropDB(ctx.getChild(2).getText());
            return null;
        }
        
        //show databases
        @Override
        public T visitShow_schema_statement(SqlParser.Show_schema_statementContext ctx) { 
            return (T)controlador.showTables();
        }
        //use database
        @Override
        public T visitUse_schema_statement(SqlParser.Use_schema_statementContext ctx) { 
            controlador.useDB(ctx.getChild(2).getText());
            return null; 
        }
        
        //create table 
        @Override
         public T visitTable_definition(SqlParser.Table_definitionContext ctx) { 
             actual= new Tabla(ctx.getChild(2).getText());
             visit(ctx.getChild(4));
             controlador.createT(actual);
             return null;  
         }
        
         //def colulumna
         public T visitDefcolumna(SqlParser.DefcolumnaContext ctx, Tabla t) { 
             Columna c= new Columna(ctx.getChild(0).getText(),ctx.getChild(1).getText());
             actual.setColumna(c);
             return null; 
         }
	//agregando primarykey
         @Override 
         public T visitPrimaryK(SqlParser.PrimaryKContext ctx) { 
             ArrayList<String> ids=new ArrayList();
             for (int i=4;i<ctx.getChildCount()-1;i++){
                 String a= ctx.getChild(i).getText();
                 if(!",".equals(a)){
                     ids.add(a);
                 }
                 
             }
             String nombre=ctx.getChild(0).getText();
             nombre=nombre.replace("PK", "");
             PrimaryKey p=new PrimaryKey(nombre,ids);
             actual.agregarPK(p);
             return null; 
         }
         //agregando foreignK
         @Override 
         public T visitForeignK(SqlParser.ForeignKContext ctx) { 
             int particion=0;
             ArrayList<String> ids=new ArrayList();
             for (int i=4;i<ctx.getChildCount()-1;i++){
                 String a= ctx.getChild(i).getText();
                 if("REFERENCES".equals(a)){
                     particion=i;
                     break;
                 }
                 if(!",".equals(a)){
                     ids.add(a);
                 }
                 
             }
             ArrayList<String> ids1=new ArrayList();
             for (int i=particion+1;i<ctx.getChildCount()-1;i++){
                 String a= ctx.getChild(i).getText();
                if(!",".equals(a)){
                     ids1.add(a);
                 }
                 
             }
             String nombre=ctx.getChild(0).getText();
             nombre=nombre.replace("FK", "");
             ForeignKey p=new ForeignKey(nombre,ids,ids1);
             actual.agregarFK(p);
             return null; 
         }
         //agregando check 
         @Override public T visitCheck(SqlParser.CheckContext ctx) { 
              String nombre=ctx.getChild(0).getText();
             nombre=nombre.replace("CH", "");
             String a="";
             for (int i=3;i<ctx.getChildCount()-1;i++){
                 a= a+ctx.getChild(i).getText();
             }
             Check c=new Check(nombre,a);
             actual.agregarCheck(c);
             return null; 
         }
	
	
	
         
         //renombrar tabla 
        @Override
         public T visitRename_table_statement(SqlParser.Rename_table_statementContext ctx) { 
            try {
                controlador.renameT(ctx.getChild(2).getText(),ctx.getChild(5).getText());
                return null;
            } catch (IOException ex) {
                Logger.getLogger(EvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
	
        //drop tabla
        @Override 
        public Object visitDrop_table_statement(SqlParser.Drop_table_statementContext ctx) { 
            controlador.dropT(ctx.getChild(2).getText());
            return null; 
        }
        
        //show tablas
        @Override 
        public T visitShow_table_statement(SqlParser.Show_table_statementContext ctx) { 
            return (T)controlador.showTables();
        }
	
        //show columnas
        @Override 
        public T visitShow_column_statement(@NotNull SqlParser.Show_column_statementContext ctx) {  
            try {
                return (T) controlador.showCololums(ctx.getChild(3).getText()); 
            } catch (IOException ex) {
                Logger.getLogger(EvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
        
        //alterar tabla
        @Override public T visitAlter_table_statement(SqlParser.Alter_table_statementContext ctx) {
            return null;
        }
	
        
        ///--------------------------------------------------------------------------------------------------------------
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
		
		//-----expr1 y expression operqdores
		@Override 
		public T visitCond_op1(SqlParser.Cond_op1Context ctx) {
			Dato dato1 = (Dato) ctx.getParent().getChild(0);
			Dato dato2 = (Dato) ctx.getParent().getChild(2);
			Dato newdato =new Dato() ;
			if (!(dato1.getTipo().equals("bool"))& !(dato1.getTipo().equals("bool"))){
				System.out.println("error and con operaciones no boleanas");
				return null ;
			}
			else {
				if ((dato1.getBool()==true)&(dato1.getBool()==true)){
					newdato.setBool(true);
				}
				else{
					newdato.setBool(false);
				}
				return (T) newdato ;
			}
			
		}
		
		@Override 
		public T visitCond_op2(SqlParser.Cond_op2Context ctx) {
			Dato dato1 = (Dato) ctx.getParent().getChild(0);
			Dato dato2 = (Dato) ctx.getParent().getChild(2);
			Dato newdato =new Dato() ;
			if (!(dato1.getTipo().equals("bool"))& !(dato1.getTipo().equals("bool"))){
				System.out.println("error and con operaciones no boleanas");
				return null ;
			}
			else {
				if ((dato1.getBool()==true)|(dato1.getBool()==true)){
					newdato.setBool(true);
				}
				else{
					newdato.setBool(false);
				}
				return (T) newdato ;
			}
			
		}
		
		
		@Override
		public T visitExpr11(SqlParser.Expr11Context ctx) {
			Dato dato = (Dato) visit(ctx.getChild(1));
			return (T)dato ;
		}
		
		@Override
		public T visitExpr12(SqlParser.Expr12Context ctx) {
			Dato dato = (Dato) visit(ctx.getChild(0));
			return (T)dato ;
		}
		
		
		
}


