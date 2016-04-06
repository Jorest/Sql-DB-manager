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
        
        @Override
        public T visitSql_executable_statement(SqlParser.Sql_executable_statementContext ctx) { 
            for (int i = 0;i<ctx.getChildCount();i++){
	         //  visito todas los hijos
			visit(ctx.getChild(i));
	            }  
		  return (T)"";
        }
	
        @Override 
        public T visitSql_schema_statement(SqlParser.Sql_schema_statementContext ctx) { 
            for (int i = 0;i<ctx.getChildCount();i++){
	         //  visito todas los hijos
			visit(ctx.getChild(i));
	            }  
		  return (T)"";
        } 
	
        @Override 
        public T visitSql_schema_manipulation_statement( SqlParser.Sql_schema_manipulation_statementContext ctx) { 
            for (int i = 0;i<ctx.getChildCount();i++){
	         //  visito todas los hijos
			visit(ctx.getChild(i));
	            }  
		  return (T)"";
        }
	
        @Override 
        public T visitSql_schema_definition_statement(SqlParser.Sql_schema_definition_statementContext ctx) { 
            for (int i = 0;i<ctx.getChildCount();i++){
	         //  visito todas los hijos
			visit(ctx.getChild(i));
	            }  
		  return (T)"";
        }
	
	
	//******************EJERCICIO #1: DDL**************************
	@Override
        public T visitSchema_definition( SqlParser.Schema_definitionContext ctx) { 
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
            try {
                controlador.useDB(ctx.getChild(2).getText());
            } catch (IOException ex) {
                Logger.getLogger(EvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null; 
        }
        
        //create table 
        @Override
         public T visitTable_definition(SqlParser.Table_definitionContext ctx) { 
             actual= new Tabla(ctx.getChild(2).getText());
              for (int i = 0;i<ctx.getChildCount();i++){
	         //  visito todas los hijos
			visit(ctx.getChild(i));
	            }  
            try {
                controlador.createT(actual);
            } catch (IOException ex) {
                Logger.getLogger(EvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
            }
             return null;  
         }
        
         @Override public T visitDefcolumna(SqlParser.DefcolumnaContext ctx) {  
             //System.out.println("NO TE OLVIDES DE MI");
             Columna c= new Columna(ctx.getChild(0).getText(),ctx.getChild(1).getText());
             actual.agregarColumna(c);
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
         @Override 
         public T visitCheck(SqlParser.CheckContext ctx) { 
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
            try {
                controlador.dropT(ctx.getChild(2).getText());
            } catch (IOException ex) {
                Logger.getLogger(EvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
            }
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
            try {
                actual=controlador.aletT(ctx.getChild(2).getText());
            } catch (IOException ex) {
                Logger.getLogger(EvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
            }
            visit(ctx.getChild(3));
            try {
                controlador.createT(actual);
            } catch (IOException ex) {
                Logger.getLogger(EvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
            }
            ///seteralo
            return null;
        }
	
        @Override 
        public T visitAddColumn(SqlParser.AddColumnContext ctx) { 
            Columna c= new Columna(ctx.getChild(2).getText(),ctx.getChild(3).getText());
            actual.agregarColumna(c);
            visit(ctx.getChild(4));
            return null;
        }
	
        @Override
        public T visitAddConstraint( SqlParser.AddConstraintContext ctx) { 
            //lo hace en constraintType
            return null;
        }
	
        @Override
        public T visitDropColumn( SqlParser.DropColumnContext ctx) { 
            ArrayList <Columna> colum=actual.getColumnas();
            String busqueda=ctx.getChild(2).getText();
            for(int i=0;i<colum.size();i++){
                if(colum.get(i).getNombre().equals(busqueda)){
                    colum.remove(i);
                    break;
                }
            }
            actual.setColumnas(colum);
            return null; 
        }
	
        @Override
        public T visitDropConstraint(SqlParser.DropConstraintContext ctx) {
            String nombreCons=ctx.getChild(2).getText();
            ArrayList <PrimaryKey> p=actual.getPrimaryk();
            ArrayList <ForeignKey> f=actual.getForeignk();
            ArrayList <Check> c=actual.getCheck();
            for(int i=0; i<p.size();i++){
                 if(p.get(i).getNombre().equals(nombreCons)){
                    p.remove(i);
                }
            }
            for(int i=0; i<f.size();i++){
                 if(f.get(i).getNombre().equals(nombreCons)){
                    f.remove(i);
                }
            }
            for(int i=0; i<c.size();i++){
                 if(c.get(i).getNombre().equals(nombreCons)){
                    c.remove(i);
                }
            }
            actual.setForeignk(f);
            actual.setPrimaryk(p);
            actual.setCheck(c);
            return null; 
            }
	
        
        ///--------------------------------------------------------------------------------------------------------------
	//Regresaremos un arraylist de datos 
	@Override 
	public T visitList_values(SqlParser.List_valuesContext ctx) {
		ArrayList <Dato> values = new ArrayList() ;
		for (int i = 0;i<ctx.getChildCount();i++){
			if(! ctx.getChild(i).getText().equals(",")){
				values.add((Dato)visit(ctx.getChild(i)));
			}
		}
		return (T) values ;
	}
	
	//-----Todas las formas basicas de los tipos -----------	

	
		@Override 
		public T visitInt_literal(SqlParser.Int_literalContext ctx) {
			Dato dato = new Dato() ;
			dato.setTipo("int");
			dato.setInteger(Integer.parseInt(ctx.getText()));
                        return (T)dato;
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
	
                // DML .........................................................
                @Override 
                public T visitInsert_value(SqlParser.Insert_valueContext ctx) { 
                   //Tomamos la tabla en la cual insertar
                    try {
                        actual=controlador.aletT(ctx.getChild(2).getText());
                    } catch (IOException ex) {
                        Logger.getLogger(EvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    controlador.setTablaActual(actual);
                    ArrayList columnas =new ArrayList();
                    ArrayList <Dato> valores;
                    int indicador=0; 
                    //Si hay columnas declaradas
                    
                    if(ctx.getChildCount()>6){
                        //Tomamos las columnas a ingresar
                          for(int i=4;i<ctx.getChildCount();i++){
                              String nombre=ctx.getChild(i).getText();
                              if(nombre.equals(")")){
                                  indicador=i; 
                                  break;
                              }
                              if(!";".equals(nombre)){
                                  columnas.add(nombre);
                              }
                          }
                          //Tomamos los valores
                          valores=(ArrayList <Dato>) visit(ctx.getChild(indicador+2));
                          //Contador de valores en value
                          int valuescont=valores.size();
                          if(valuescont<=columnas.size()){
                              
                              
                          }
                    }
                    //no especifica columnas
                    else{
                        
                    }
                     return null; 
                }
                
                //Order By
             /**   @Override 
                public T orderBy_Asc(SqlParser.OrderBy_Asc ctx) { 
                   //Tomamos la tabla en la cual insertar
                    for(i=1;i<valores.length;i++){
                        for(j=0;j<valores.lenght;j++){
                            if (valores[j]>valores[j+1]){
                                aux = valores[j];
                                valoress[j] = valores[j+1];
                                valores[j+1] = aux;
                            }
                        }
                    } 
                }
                
                 @Override 
                public T orderBy_Desc(sqlParser.OrderBy_Desc ctx) { 
                   //Tomamos la tabla en la cual insertar
                    for(i=1;i<valores.length;i++){
                        for(j=0;j<valores.lenght;j++){
                            if (valores[j]<valores[j+1]){
                                aux = valores[j];
                                valores[j] = valores[j+1];
                                valores[j+1] = aux;
                            }
                        }
                    } 
                }**/
                      
                
	
                             


		//----- todas las expresiones ---------------------
		
		@Override
		public T visitLiteral(SqlParser.LiteralContext ctx) {
			/**Dato dato = new Dato() ;
			dato= (Dato)visit(ctx.getChild(0));
			return (T) dato ;*/
                    return (T) visit(ctx.getChild(0));
                    
		}

		@Override
		public T visitFactorExpression(SqlParser.FactorExpressionContext ctx) {
			Dato dato = new Dato() ;
			dato= (Dato)visit(ctx.getChild(1));
			return (T) dato ;
		}
		
		
		@Override
		public T visitFactorID(SqlParser.FactorIDContext ctx) {
			Columna col = controlador.getIDvalues(ctx.getText());
			Dato dato = new Dato();
			dato.setTipo(col.getTipo());
			
			return (T) dato;
		}
		
		
		@Override
		public T visitUniFactorNot(SqlParser.UniFactorNotContext ctx) {
			Dato dato = new Dato() ;
			dato= (Dato)visit(ctx.getChild(1));
			ArrayList<Integer> filas =dato.getFilas();
			ArrayList<Integer> notFilas = new  ArrayList<Integer>();

			int tamanio = dato.getColumna().size();
			for (int i=0; i < tamanio ; i++){
				if (!(filas.contains(i))){
					notFilas.add(i);
				}
			}
			dato.setFilas(notFilas);
			return (T) dato  ;
		}

		@Override
		public T visitUniFactorFactor(SqlParser.UniFactorFactorContext ctx) {
			Dato dato = new Dato() ;
			dato= (Dato)visit(ctx.getChild(0));
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
		
		
	
		
		
		//----****************** REL_OP OPERADORES 3!!! < > <= ETC *****************************
		
		@Override
		public T visitRelL3(SqlParser.RelL3Context ctx) {
						
			Dato dato1 = (Dato) ctx.getParent().getChild(0);
			Dato dato2 = (Dato) ctx.getParent().getChild(2);
			ArrayList<Integer> lista = new ArrayList<Integer>();
			Dato newdato =new Dato() ;
			if (dato1.getTipo().equals(dato2.getTipo())){ 
				switch (dato1.getTipo()) {
	            case ("int"): 
	            	for( int i= 0;i < dato2.getFilas().size();i++){
	            		if (dato1.getInteger()<(int)dato2.getColumna().get(dato2.getFilas().get(i))){
	            			lista.add(i);
	            		}
	            	}
	            	break;
	            	          
	            case "float": 
	            	for( int i= 0;i < dato2.getFilas().size();i++){
	            		if (dato1.getFloating()<(float)dato2.getColumna().get(dato2.getFilas().get(i))){
	            			lista.add(i);
	            		}
	            	}
	                break;
	                
	            default: 
	            	System.out.println("error dato no reconocido");
	            	
				}
			}
			else {
				System.out.println("los tipos deben coindicidir");
			}
			newdato.setFilas(lista);
			newdato.setColumna(dato2.getColumna()); newdato.setTipo(dato2.getTipo());
			return (T) newdato ;
			
		}
		
		@Override
		public T visitRekB3( SqlParser.RekB3Context ctx) {
			
			Dato dato1 = (Dato) ctx.getParent().getChild(0);
			Dato dato2 = (Dato) ctx.getParent().getChild(2);
			ArrayList<Integer> lista = new ArrayList<Integer>();
			Dato newdato =new Dato() ;
			if (dato1.getTipo().equals(dato2.getTipo())){ 
				switch (dato1.getTipo()) {
	            case ("int"): 
	            	for( int i= 0;i < dato2.getFilas().size();i++){
	            		if (dato1.getInteger()<(int)dato2.getColumna().get(dato2.getFilas().get(i))){
	            			lista.add(i);
	            		}
	            	}
	            	break;
	            	          
	            case "float": 
	            	for( int i= 0;i < dato2.getFilas().size();i++){
	            		if (dato1.getFloating()<(float)dato2.getColumna().get(dato2.getFilas().get(i))){
	            			lista.add(i);
	            		}
	            	}
	                break;
	                
	            default: 
	            	System.out.println("error dato no reconocido");
	            	
				}
			}
			else {
				System.out.println("los tipos deben coindicidir");
			}
			newdato.setFilas(lista);
			newdato.setColumna(dato2.getColumna()); newdato.setTipo(dato2.getTipo());
			return (T) newdato ;
				}
		
		@Override
		public T visitRelLE3(SqlParser.RelLE3Context ctx) {
			Dato dato1 = (Dato) ctx.getParent().getChild(0);
			Dato dato2 = (Dato) ctx.getParent().getChild(2);
			ArrayList<Integer> lista = new ArrayList<Integer>();
			Dato newdato =new Dato() ;
			if (dato1.getTipo().equals(dato2.getTipo())){ 
				switch (dato1.getTipo()) {
	            case ("int"): 
	            	for( int i= 0;i < dato2.getFilas().size();i++){
	            		if (dato1.getInteger()<=(int)dato2.getColumna().get(dato2.getFilas().get(i))){
	            			lista.add(i);
	            		}
	            	}
	            	break;
	            	          
	            case "float": 
	            	for( int i= 0;i < dato2.getFilas().size();i++){
	            		if (dato1.getFloating()<=(float)dato2.getColumna().get(dato2.getFilas().get(i))){
	            			lista.add(i);
	            		}
	            	}
	                break;
	                
	            default: 
	            	System.out.println("error dato no reconocido");
	            	
				}
			}
			else {
				System.out.println("los tipos deben coindicidir");
			}
			newdato.setFilas(lista);
			newdato.setColumna(dato2.getColumna()); newdato.setTipo(dato2.getTipo());

			return (T) newdato ;
				}
		
		
		@Override
		public T visitRelBE3(SqlParser.RelBE3Context ctx) {

			Dato dato1 = (Dato) ctx.getParent().getChild(0);
			Dato dato2 = (Dato) ctx.getParent().getChild(2);
			ArrayList<Integer> lista = new ArrayList<Integer>();
			Dato newdato =new Dato() ;
			if (dato1.getTipo().equals(dato2.getTipo())){ 
				switch (dato1.getTipo()) {
	            case ("int"): 
	            	for( int i= 0;i < dato2.getFilas().size();i++){
	            		if (dato1.getInteger()>=(int)dato2.getColumna().get(dato2.getFilas().get(i))){
	            			lista.add(i);
	            		}
	            	}
	            	break;
	            	          
	            case "float": 
	            	for( int i= 0;i < dato2.getFilas().size();i++){
	            		if (dato1.getInteger()>=(float)dato2.getColumna().get(dato2.getFilas().get(i))){
	            			lista.add(i);
	            		}
	            	}
	                break;
	                
	            default: 
	            	System.out.println("error dato no reconocido");
	            	
				}
			}
			else {
				System.out.println("los tipos deben coindicidir");
			}
			newdato.setFilas(lista);
			newdato.setColumna(dato2.getColumna()); newdato.setTipo(dato2.getTipo());
			return (T) newdato ;
		}
		
				
		//OPERADORES de igualdad
		
		
		@Override
		public T visitEqE3(SqlParser.EqE3Context ctx) {
			Dato dato1 = (Dato) ctx.getParent().getChild(0);
			Dato dato2 = (Dato) ctx.getParent().getChild(2);
			Dato newdato =new Dato() ;
			ArrayList<Integer> lista = new ArrayList<Integer>();
			if (dato1.getTipo().equals(dato2.getTipo())){  
				switch (dato1.getTipo()) {
	            case "int": 
	            	for( int i= 0;i < dato2.getFilas().size();i++){
	            		if (dato1.getInteger()==(int)dato2.getColumna().get(dato2.getFilas().get(i))){
	            			lista.add(i);
	            		}
	            	}
	            	break ;
	          
	            case "float": 
	            	for( int i= 0;i < dato2.getFilas().size();i++){
	            		if (dato1.getFloating()==(float)dato2.getColumna().get(dato2.getFilas().get(i))){
	            			lista.add(i);
	            		}
	            	}
	            	break ;
	                
	            case "char": 
	            	for( int i= 0;i < dato2.getFilas().size();i++){
	            		if (dato1.getDate().equals(dato2.getColumna().get(dato2.getFilas().get(i)))){
	            			lista.add(i);
	            		}
	            	}
	            	break ;
	         
	            case "date": 
	            	for( int i= 0;i < dato2.getFilas().size();i++){
	            		if (dato1.getDate().equals(dato2.getColumna().get(dato2.getFilas().get(i)))){
	            			lista.add(i);
	            		}
	            	}
	            	break ;
	                
	            default: 
	            	System.out.println("error eqE dato no reconocido");
	                break;
	          
				}
			}
			else {
				System.out.println("los tipos deben coindicidir");
			}
			newdato.setFilas(lista);
			newdato.setColumna(dato2.getColumna()); newdato.setTipo(dato2.getTipo());

			return (T) newdato ;
			
			
			
		}
				
			
		@Override
		public T visitEqNE3(SqlParser.EqNE3Context ctx) {
			Dato dato1 = (Dato) ctx.getParent().getChild(0);
			Dato dato2 = (Dato) ctx.getParent().getChild(2);
			Dato newdato =new Dato() ;
			ArrayList<Integer> lista = new ArrayList<Integer>();
			if (dato1.getTipo().equals(dato2.getTipo())){  
				switch (dato1.getTipo()) {
	            case "int": 
	            	for( int i= 0;i < dato2.getFilas().size();i++){
	            		if (dato1.getInteger()!=(int)dato2.getColumna().get(dato2.getFilas().get(i))){
	            			lista.add(i);
	            		}
	            	}
	            	break ;
	          
	            case "float": 
	            	for( int i= 0;i < dato2.getFilas().size();i++){
	            		if (dato1.getFloating()!=(float)dato2.getColumna().get(dato2.getFilas().get(i))){
	            			lista.add(i);
	            		}
	            	}
	            	break ;
	                
	            case "char": 
	            	for( int i= 0;i < dato2.getFilas().size();i++){
	            		if (!(dato1.getCharacter().equals(dato2.getColumna().get(dato2.getFilas().get(i))))){
	            			lista.add(i);
	            		}
	            	}
	            	break ;
	         
	            case "date": 
	            	for( int i= 0;i < dato2.getFilas().size();i++){
	            		if (!(dato1.getDate().equals(dato2.getColumna().get(dato2.getFilas().get(i))))){
	            			lista.add(i);
	            		}
	            	}
	            	break ;
	                
	            default: 
	            	System.out.println("error eqE dato no reconocido");
	                break;
	          
				}
			}
			else {
				System.out.println("los tipos deben coindicidir");
			}
			newdato.setFilas(lista);
			newdato.setColumna(dato2.getColumna()); newdato.setTipo(dato2.getTipo());

			return (T) newdato ;
		}


		//----****************** REL_OP OPERADORES 2!!!! < > <= ETC *****************************
		
		
        @Override
		public T visitRelL2(SqlParser.RelL2Context ctx) {
						
			Dato dato1 = (Dato) ctx.getParent().getChild(0);
			Dato dato2 = (Dato) ctx.getParent().getChild(2);
			ArrayList<Integer> lista = new ArrayList<Integer>();
			Dato newdato =new Dato() ;
			if (dato1.getTipo().equals(dato2.getTipo())){ 
				switch (dato1.getTipo()) {
	            case ("int"): 
	            	for( int i= 0;i < dato1.getFilas().size();i++){
	            		if ((int)dato1.getColumna().get(dato1.getFilas().get(i))<dato2.getInteger()){
	            			lista.add(i);
	            		}
	            	}
	            	break;
	            	          
	            case "float": 
	            	for( int i= 0;i < dato1.getFilas().size();i++){
	            		if ((float)dato1.getColumna().get(dato1.getFilas().get(i))<dato2.getFloating()){
	            			lista.add(i);
	            		}
	            	}
	                break;
	                
	            default: 
	            	System.out.println("error dato no reconocido");
	            	
				}
			}
			else {
				System.out.println("los tipos deben coindicidir");
			}
			newdato.setColumna(dato1.getColumna()); newdato.setTipo(dato1.getTipo());
			newdato.setFilas(lista);
			return (T) newdato ;
		}
		
		
		

@Override
		
		
		public T visitRekB2(SqlParser.RekB2Context ctx) {
			
			Dato dato1 = (Dato) ctx.getParent().getChild(0);
			Dato dato2 = (Dato) ctx.getParent().getChild(2);
			ArrayList<Integer> lista = new ArrayList<Integer>();
			Dato newdato =new Dato() ;
			if (dato1.getTipo().equals(dato2.getTipo())){ 
				switch (dato1.getTipo()) {
	            case ("int"): 
	            	for( int i= 0;i < dato1.getFilas().size();i++){
	            		if ((int)dato1.getColumna().get(dato1.getFilas().get(i))<dato2.getInteger()){
	            			lista.add(i);
	            		}
	            	}
	            	break;
	            	          
	            case "float": 
	            	for( int i= 0;i < dato1.getFilas().size();i++){
	            		if ((float)dato1.getColumna().get(dato1.getFilas().get(i))<dato2.getFloating()){
	            			lista.add(i);
	            		}
	            	}
	                break;
	                
	            default: 
	            	System.out.println("error dato no reconocido");
	            	
				}
			}
			else {
				System.out.println("los tipos deben coindicidir");
			}
			newdato.setFilas(lista);
			newdato.setColumna(dato1.getColumna()); newdato.setTipo(dato1.getTipo());
			return (T) newdato ;
				}
		
		

		@Override
		public T visitRelLE2(SqlParser.RelLE2Context ctx) {
			
			Dato dato1 = (Dato) ctx.getParent().getChild(0);
			Dato dato2 = (Dato) ctx.getParent().getChild(2);
			ArrayList<Integer> lista = new ArrayList<Integer>();
			Dato newdato =new Dato() ;
			if (dato1.getTipo().equals(dato2.getTipo())){ 
				switch (dato1.getTipo()) {
	            case ("int"): 
	            	for( int i= 0;i < dato1.getFilas().size();i++){
	            		if ((int)dato1.getColumna().get(dato1.getFilas().get(i))<=dato2.getInteger()){
	            			lista.add(i);
	            		}
	            	}
	            	break;
	            	          
	            case "float": 
	            	for( int i= 0;i < dato1.getFilas().size();i++){
	            		if ((float)dato1.getColumna().get(dato1.getFilas().get(i))<=dato2.getFloating()){
	            			lista.add(i);
	            		}
	            	}
	                break;
	                
	            default: 
	            	System.out.println("error dato no reconocido");
	            	
				}
			}
			else {
				System.out.println("los tipos deben coindicidir");
			}
			newdato.setFilas(lista);
			newdato.setColumna(dato1.getColumna()); newdato.setTipo(dato1.getTipo());
			return (T) newdato ;
				}
		
				

		@Override
		public T visitRelBE2(SqlParser.RelBE2Context ctx) {

			
			Dato dato1 = (Dato) ctx.getParent().getChild(0);
			Dato dato2 = (Dato) ctx.getParent().getChild(2);
			ArrayList<Integer> lista = new ArrayList<Integer>();
			Dato newdato =new Dato() ;
			if (dato1.getTipo().equals(dato2.getTipo())){ 
				switch (dato1.getTipo()) {
	            case ("int"): 
	            	for( int i= 0;i < dato1.getFilas().size();i++){
	            		if ((int)dato1.getColumna().get(dato1.getFilas().get(i))>=dato2.getInteger()){
	            			lista.add(i);
	            		}
	            	}
	            	break;
	            	          
	            case "float": 
	            	for( int i= 0;i < dato1.getFilas().size();i++){
	            		if ((float)dato1.getColumna().get(dato1.getFilas().get(i))>=dato2.getFloating()){
	            			lista.add(i);
	            		}
	            	}
	                break;
	                
	            default: 
	            	System.out.println("error dato no reconocido");
	            	
				}
			}
			else {
				System.out.println("los tipos deben coindicidir");
			}
			newdato.setFilas(lista);
			newdato.setColumna(dato1.getColumna()); newdato.setTipo(dato1.getTipo());
			return (T) newdato ;
			
		}
		

	
		//OPERADORES de igualdad
		
				
		@Override
		public T visitEqE2(SqlParser.EqE2Context ctx) {
			Dato dato1 = (Dato) ctx.getParent().getChild(0);
			Dato dato2 = (Dato) ctx.getParent().getChild(2);
			Dato newdato =new Dato() ;
			ArrayList<Integer> lista = new ArrayList<Integer>();
			if (dato1.getTipo().equals(dato2.getTipo())){  
				switch (dato1.getTipo()) {
	            case "int": 
	            	for( int i= 0;i < dato1.getFilas().size();i++){
	            		if ((int)dato1.getColumna().get(dato1.getFilas().get(i))==dato2.getInteger()){
	            			lista.add(i);
	            		}
	            	}
	            	break ;
	          
	            case "float": 
	            	for( int i= 0;i < dato1.getFilas().size();i++){
	            		if ((float)dato1.getColumna().get(dato1.getFilas().get(i))==dato2.getFloating()){
	            			lista.add(i);
	            		}
	            	}
	            	break ;
	                
	            case "char": 
	            	for( int i= 0;i < dato1.getFilas().size();i++){
	            		if (dato1.getColumna().get(dato1.getFilas().get(i)).equals(dato2.getCharacter())){
	            			lista.add(i);
	            		}
	            	}
	            	break ;
	         
	            case "date": 
	            	for( int i= 0;i < dato1.getFilas().size();i++){
	            		if (dato1.getColumna().get(dato1.getFilas().get(i)).equals(dato2.getDate())){
	            			lista.add(i);
	            		}
	            	}
	            	break ;
	                
	            default: 
	            	System.out.println("error eqE dato no reconocido");
	                break;
	          
				}
			}
			else {
				System.out.println("los tipos deben coindicidir");
			}
			newdato.setColumna(dato1.getColumna()); newdato.setTipo(dato1.getTipo());
			newdato.setFilas(lista);
			return (T) newdato ;
		}
				
		@Override
		public T visitEqNE2(SqlParser.EqNE2Context ctx) {
			Dato dato1 = (Dato) ctx.getParent().getChild(0);
			Dato dato2 = (Dato) ctx.getParent().getChild(2);
			Dato newdato =new Dato() ;
			ArrayList<Integer> lista = new ArrayList<Integer>();
			if (dato1.getTipo().equals(dato2.getTipo())){  
				switch (dato1.getTipo()) {
	            case "int": 
	            	for( int i= 0;i < dato1.getFilas().size();i++){
	            		if ((int)dato1.getColumna().get(dato1.getFilas().get(i))!=dato2.getInteger()){
	            			lista.add(i);
	            		}
	            	}
	            	break ;
	          
	            case "float": 
	            	for( int i= 0;i < dato1.getFilas().size();i++){
	            		if ((float)dato1.getColumna().get(dato1.getFilas().get(i))!=dato2.getFloating()){
	            			lista.add(i);
	            		}
	            	}
	            	break ;
	                
	            case "char": 
	            	for( int i= 0;i < dato1.getFilas().size();i++){
	            		if (!(dato1.getColumna().get(dato1.getFilas().get(i)).equals(dato2.getCharacter()))){
	            			lista.add(i);
	            		}
	            	}
	            	break ;
	         
	            case "date": 
	            	for( int i= 0;i < dato1.getFilas().size();i++){
	            		if (!(dato1.getColumna().get(dato1.getFilas().get(i)).equals(dato2.getDate()))){
	            			lista.add(i);
	            		}
	            	}
	            	break ;
	                
	            default: 
	            	System.out.println("error eqE dato no reconocido");
	                break;
	          
				}
			}
			else {
				System.out.println("los tipos deben coindicidir");
			}
			newdato.setFilas(lista);
			newdato.setColumna(dato1.getColumna()); newdato.setTipo(dato1.getTipo());

			return (T) newdato ;
		}



		
		
		//----****************** REL_OP OPERADORES 1!!! < > <= ETC *****************************
		@Override
		public T visitRelL(SqlParser.RelLContext ctx) {
						
			Dato dato1 = (Dato) ctx.getParent().getChild(0);
			Dato dato2 = (Dato) ctx.getParent().getChild(2);
			ArrayList<Integer> lista = new ArrayList<Integer>();
			Dato newdato =new Dato() ;
			if (dato1.getTipo().equals(dato2.getTipo())){ 
				switch (dato1.getTipo()) {
	            case ("int"): 
	            	for( int i= 0;i < dato1.getColumna().size();i++){
	            		if ((int)dato1.getColumna().get(i)<(int)dato2.getColumna().get(i)){
	            			lista.add(i);
	            		}
	            	}
	            	break;
	            	          
	            case "float": 
	            	for( int i= 0;i < dato1.getColumna().size();i++){
	            		if ((float)dato1.getColumna().get(i)<(float)dato2.getColumna().get(i)){
	            			lista.add(i);
	            		}
	            	}
	            	break;
	                
	            default: 
	            	System.out.println("error dato no reconocido");
	            	
				}
			}
			else {
				System.out.println("los tipos deben coindicidir");
			}
			newdato.setFilas(lista);
			newdato.setColumna(dato1.getColumna()); newdato.setTipo(dato1.getTipo());
			return (T) newdato ;
		}
				
		@Override
		public T visitRekB(SqlParser.RekBContext ctx) {
			
			Dato dato1 = (Dato) ctx.getParent().getChild(0);
			Dato dato2 = (Dato) ctx.getParent().getChild(2);
			ArrayList<Integer> lista = new ArrayList<Integer>();
			Dato newdato =new Dato() ;
			if (dato1.getTipo().equals(dato2.getTipo())){ 
				switch (dato1.getTipo()) {
	            case ("int"): 
	            	for( int i= 0;i < dato1.getColumna().size();i++){
	            		if ((int)dato1.getColumna().get(i)>(int)dato2.getColumna().get(i)){
	            			lista.add(i);
	            		}
	            	}
	            	break;
	            	          
	            case "float": 
	            	for( int i= 0;i < dato1.getColumna().size();i++){
	            		if ((float)dato1.getColumna().get(i)>(float)dato2.getColumna().get(i)){
	            			lista.add(i);
	            		}
	            	}
	            	break;
	                
	            default: 
	            	System.out.println("error dato no reconocido");
	            	
				}
			}
			else {
				System.out.println("los tipos deben coindicidir");
			}
			newdato.setFilas(lista);
			newdato.setColumna(dato1.getColumna()); newdato.setTipo(dato1.getTipo());
			return (T) newdato ;
				}
		
		
		@Override
		public T visitRelLE(SqlParser.RelLEContext ctx) {
			Dato dato1 = (Dato) ctx.getParent().getChild(0);
			Dato dato2 = (Dato) ctx.getParent().getChild(2);
			ArrayList<Integer> lista = new ArrayList<Integer>();
			Dato newdato =new Dato() ;
			if (dato1.getTipo().equals(dato2.getTipo())){ 
				switch (dato1.getTipo()) {
	            case ("int"): 
	            	for( int i= 0;i < dato1.getColumna().size();i++){
	            		if ((int)dato1.getColumna().get(i)<=(int)dato2.getColumna().get(i)){
	            			lista.add(i);
	            		}
	            	}
	            	break;
	            	          
	            case "float": 
	            	for( int i= 0;i < dato1.getColumna().size();i++){
	            		if ((float)dato1.getColumna().get(i)<=(float)dato2.getColumna().get(i)){
	            			lista.add(i);
	            		}
	            	}
	            	break;
	                
	            default: 
	            	System.out.println("error dato no reconocido");
	            	
				}
			}
			else {
				System.out.println("los tipos deben coindicidir");
			}
			newdato.setFilas(lista);
			newdato.setColumna(dato1.getColumna()); newdato.setTipo(dato1.getTipo());
			return (T) newdato ;
				}
		
		
		@Override
		public T visitRelBE(SqlParser.RelBEContext ctx) {

			Dato dato1 = (Dato) ctx.getParent().getChild(0);
			Dato dato2 = (Dato) ctx.getParent().getChild(2);
			ArrayList<Integer> lista = new ArrayList<Integer>();
			Dato newdato =new Dato() ;
			if (dato1.getTipo().equals(dato2.getTipo())){ 
				switch (dato1.getTipo()) {
	            case ("int"): 
	            	for( int i= 0;i < dato1.getColumna().size();i++){
	            		if ((int)dato1.getColumna().get(i)>=(int)dato2.getColumna().get(i)){
	            			lista.add(i);
	            		}
	            	}
	            	break;
	            	          
	            case "float": 
	            	for( int i= 0;i < dato1.getColumna().size();i++){
	            		if ((float)dato1.getColumna().get(i)>=(float)dato2.getColumna().get(i)){
	            			lista.add(i);
	            		}
	            	}
	            	break;
	                
	            default: 
	            	System.out.println("error dato no reconocido");
	            	
				}
			}
			else {
				System.out.println("los tipos deben coindicidir");
			}
			newdato.setFilas(lista);
			newdato.setColumna(dato1.getColumna()); newdato.setTipo(dato1.getTipo());
			return (T) newdato ;
		}
		
		
				
		//OPERADORES de igualdad
		
		@Override
		public T visitEqE(SqlParser.EqEContext ctx) {
			Dato dato1 = (Dato) ctx.getParent().getChild(0);
			Dato dato2 = (Dato) ctx.getParent().getChild(2);
			Dato newdato =new Dato() ;
			ArrayList<Integer> lista = new ArrayList<Integer>();
			if (dato1.getTipo().equals(dato2.getTipo())){  
				switch (dato1.getTipo()) {
	            case "int": 
	            	for( int i= 0;i < dato1.getColumna().size();i++){
	            		if ((int)dato1.getColumna().get(i)==(int)dato2.getColumna().get(i)){
	            			lista.add(i);
	            		}
	            	}
	            	break;
	          
	            case "float": 
	            	for( int i= 0;i < dato1.getColumna().size();i++){
	            		if ((float)dato1.getColumna().get(i)==(float)dato2.getColumna().get(i)){
	            			lista.add(i);
	            		}
	            	}
	            	break;
	                
	            case "char": 
	            	for( int i= 0;i < dato1.getColumna().size();i++){
	            		if (dato1.getColumna().get(i).equals(dato2.getColumna().get(i))){
	            			lista.add(i);
	            		}
	            	}
	            	break;
	         
	            case "date": 
	            	for( int i= 0;i < dato1.getColumna().size();i++){
	            		if (dato1.getColumna().get(i).equals(dato2.getColumna().get(i))){
	            			lista.add(i);
	            		}
	            	}
	            	break;
	                
	            default: 
	            	System.out.println("error eqE dato no reconocido");
	                break;
	          
				}
			}
			else {
				System.out.println("los tipos deben coindicidir");
			}
			newdato.setFilas(lista);
			newdato.setColumna(dato1.getColumna()); newdato.setTipo(dato1.getTipo());
			return (T) newdato ;
		}
				
		
		
		@Override
		public T visitEqNE(SqlParser.EqNEContext ctx) {
			Dato dato1 = (Dato) ctx.getParent().getChild(0);
			Dato dato2 = (Dato) ctx.getParent().getChild(2);
			Dato newdato =new Dato() ;
			ArrayList<Integer> lista = new ArrayList<Integer>();
			if (dato1.getTipo().equals(dato2.getTipo())){  
				switch (dato1.getTipo()) {
	            case "int": 
	            	for( int i= 0;i < dato1.getColumna().size();i++){
	            		if ((int)dato1.getColumna().get(i)!=(int)dato2.getColumna().get(i)){
	            			lista.add(i);
	            		}
	            	}
	            	break;
	            case "float": 
	            	for( int i= 0;i < dato1.getColumna().size();i++){
	            		if ((float)dato1.getColumna().get(i)!=(float)dato2.getColumna().get(i)){
	            			lista.add(i);
	            		}
	            	}
	            	break;
	                
	            case "char": 
	            	for( int i= 0;i < dato1.getColumna().size();i++){
	            		if ((!dato1.getColumna().get(i).equals(dato2.getColumna().get(i)))){
	            			lista.add(i);
	            		}
	            	}
	            	break;
	         
	            case "date": 
	            	for( int i= 0;i < dato1.getColumna().size();i++){
	            		if ((!dato1.getColumna().get(i).equals(dato2.getColumna().get(i)))){
	            			lista.add(i);
	            		}
	            	}
	            	break;
	                
	            default: 
	            	System.out.println("error eqE dato no reconocido");
	                break;
	          
				}
			}
			else {
				System.out.println("los tipos deben coindicidir");
			}
			newdato.setFilas(lista);
			newdato.setColumna(dato1.getColumna()); newdato.setTipo(dato1.getTipo());
			return (T) newdato ;
		}
		
		//-----expr1 y expression operqdores
		@Override 
		public T visitCond_op1(SqlParser.Cond_op1Context ctx) {
			Dato dato1 = (Dato) ctx.getParent().getChild(0);
			Dato dato2 = (Dato) ctx.getParent().getChild(2);
			Dato newdato =new Dato() ;
			
				return (T) newdato ;
			
			
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
		
	
		
		
		
		
		//********expr1 y expression operqdores**************
		@Override
		public T visitExpr33(SqlParser.Expr33Context ctx) {
			Dato dato = new Dato() ;
			dato= (Dato)visit(ctx.getChild(1));
			return (T) dato ;
		}
		
		@Override
		public T visitExpr34(SqlParser.Expr34Context ctx) {
			Dato dato = new Dato() ;
			dato= (Dato)visit(ctx.getChild(1));
			return (T) dato ;
		}
		
		
		@Override
		public T visitExpr12(SqlParser.Expr12Context ctx) {
			Dato dato = new Dato() ;
			dato= (Dato)visit(ctx.getChild(0));
			return (T) dato ;
		}
		
		
		@Override
		public T visitExpression1(SqlParser.Expression1Context ctx) {
			Dato dato = (Dato) visit(ctx.getChild(1));
			return (T)dato ;
		}
		
		@Override
		public T visitExpression2(SqlParser.Expression2Context ctx) {
			Dato dato = (Dato) visit(ctx.getChild(0));
			return (T)dato ;
		}
		
		
	
}


