
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.antlr.runtime.tree.ParseTree;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.NotNull;
public class EvalVisitor<T> extends SqlBaseVisitor<Object> {
	private Tabla actual; 
        private boolean error=false;
	private ControladorDB controlador = new ControladorDB() ;
	private ArrayList<Check> checks = new ArrayList();
	private ArrayList<CheckBase> checksB = new ArrayList();
       
	public ControladorDB getControlador() {
            return controlador;
        }

        public void setControlador(ControladorDB controlador) {
            this.controlador = controlador;
        }
        	
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
            try {
                controlador.alterDB(ctx.getChild(2).getText(), ctx.getChild(5).getText());
            } catch (IOException ex) {
                Logger.getLogger(EvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        } 
        
        //drop database
        @Override
        public T visitDrop_schema_statement(SqlParser.Drop_schema_statementContext ctx) { 
            try {
                controlador.dropDB(ctx.getChild(2).getText());
            } catch (IOException ex) {
                Logger.getLogger(EvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
        }
        
        //show databases
        @Override
        public T visitShow_schema_statement(SqlParser.Show_schema_statementContext ctx) { 
            ArrayList da=controlador.getData(); 
            da.addAll(controlador.showDB());
            controlador.setData(da);
            return null;
            
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
            if(controlador.getActual()!=null){
                actual= new Tabla(ctx.getChild(2).getText());
                controlador.setTablaActual(actual);
                 for (int i = 4;i<ctx.getChildCount()-2;i++){
                    //  visito todas los hijos
                           visit(ctx.getChild(i));
                       }  
               if(error==false){
                    try {
                        controlador.createT(actual);
                    } catch (IOException ex) {
                        Logger.getLogger(EvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    error=false;
               }
            }else{
                ArrayList errores=controlador.getError();
                errores.add("Error no se establecido que Base de Datos usar."); 
                controlador.setError(errores);
            }
             return null;  
         }
        
         @Override public T visitDefcolumna(SqlParser.DefcolumnaContext ctx) {  
             //System.out.println("NO TE OLVIDES DE MI");
             Columna c= (Columna)visit(ctx.getChild(1));
             c.setNombre(ctx.getChild(0).getText());
             actual.agregarColumna(c);
             return null; 
         }
         
	//agregando primarykey
         @Override 
         public T visitPrimaryK(SqlParser.PrimaryKContext ctx) { 
             if(actual.getForeignk().isEmpty()){
                ArrayList<String> ids=new ArrayList();
                for (int i=4;i<ctx.getChildCount()-1;i++){
                    String a= ctx.getChild(i).getText();
                    if(!",".equals(a)){
                        ids.add(a);
                    }
                }
                int cont=0; 
                for(int i=0; i<ids.size();i++){
                    if(controlador.getColumna(actual.getColumnas(), ids.get(i))!=null){
                        cont++;
                    }
                }
                if(cont==ids.size()){
                    String nombre=ctx.getChild(0).getText();
                    nombre=nombre.replace("PK", "");
                    PrimaryKey p=new PrimaryKey(nombre,ids);
                    actual.agregarPK(p);
                }else{
                    ArrayList errores=controlador.getError();
                    errores.add("Error al intentar agregar primary key, los ids de referencia no se encontraron como columnas de la tabla."); 
                    controlador.setError(errores);
                    error=true;
                }
             }else{
                ArrayList errores=controlador.getError();
                errores.add("Error al intentar agregar primary key, la tabla ya posee una."); 
                controlador.setError(errores);
                error=true;
            }
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
                 if(!",".equals(a) && !")".equals(a)){
                     ids.add(a);
                 }
                 
             }
             int cont=0; 
             for(int i=0; i<ids.size();i++){
                if(controlador.getColumna(actual.getColumnas(), ids.get(i))!=null){
                    cont++;
                }
             }
             if(cont==ids.size()){
                ArrayList<String> ids1=new ArrayList();
                for (int i=particion+3;i<ctx.getChildCount()-1;i++){
                    String a= ctx.getChild(i).getText();
                   if(!",".equals(a)&& !")".equals(a)){
                        ids1.add(a);
                    }
                }
                Tabla ref=null;
                 try {
                     ref = controlador.aletT(ctx.getChild(particion+1).getText());
                 } catch (IOException ex) {
                     Logger.getLogger(EvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
                 }
                if(ref!=null){
                    int cont1=0;
                    for(int i=0; i<ids1.size();i++){
                       if(controlador.getColumna(ref.getColumnas(), ids1.get(i))!=null){
                           cont1++;
                       }
                    }
                    if(cont1==ids1.size()){
                        String nombre=ctx.getChild(0).getText();
                        nombre=nombre.replace("FK", "");
                        ForeignKey p=new ForeignKey(nombre,ids,ref.getNombre(),ids1);
                        actual.agregarFK(p);
                    }else{
                        ArrayList errores=controlador.getError();
                        errores.add("Error al intentar agregar foreign key, ids de referencia no fueron encontrados como columnas en tabla de referencia."); 
                        controlador.setError(errores);
                        error=true;
                    }
                }else{
                    ArrayList errores=controlador.getError();
                    errores.add("Error al intentar agregar foreign key, tabla de referencia no existe."); 
                    controlador.setError(errores);
                    error=true;
                    
                }
             }else{
                ArrayList errores=controlador.getError();
                errores.add("Error al intentar agregar foreign key, los ids de referencia no se encontraron como columnas de la tabla."); 
                controlador.setError(errores);
                error=true;
             }              
             return null; 
         }
         
         //****agregando check 
         @Override 
         public T visitCheck(SqlParser.CheckContext ctx) { 
             boolean contains = false ;
             
             for (Check check : checks){
            	 //si la tabla ya tiene un check solo agregamos el nuevo arbol
            	 if (check.getTabla().equals(controlador.getTablaActual().getNombre())){
            		 contains= true ;
            		 check.addTree(ctx.getChild(3));
            	 }
             }
             
             //si no creamos un nuevo check para la tabla 
             if (contains ==false ){
                 Check regla = new Check();
                 regla.setTabla(actual.getNombre());
            	 regla.addTree(ctx.getChild(3));
            	 regla.setNombre(ctx.getChild(0).getText());
            	 
            	 //creacion del checkbase 
            	 
            	 
            	 
                 checks.add(regla);
             }
             //generarCheck();
             actual.agregarColumna(new Columna(ctx.getChild(0).getText()));
             return null; 
         }

         
         public void CheckstoBase() {
        	 ArrayList<CheckBase> result = new ArrayList<CheckBase>(); 
        	 for (int i=0 ; i<checks.size();i++){
        		 CheckBase checkb = new CheckBase() ;
        		 checkb.setBase(checks.get(i).getBase());
        		 checkb.setExp(checks.get(i).getExp());
        		 checkb.setNombre(checks.get(i).getNombre());
        		 checkb.setTabla(checks.get(i).getTabla());
        		 for (int j =0 ; j< checks.get(i).getTrees().size(); j++){
        			 checkb.addTree(checks.get(i).getTrees().get(j).getText());
        		 }
        		 result.add(checkb);
        	 }
        	 checksB=result ;
         }
         
         
         public void BasetoCheck() {
        	 ArrayList<Check> result = new ArrayList<Check>(); 
        	 for (int i=0 ; i<checksB.size();i++){
        		 Check check = new Check() ;
        		 check.setBase(checksB.get(i).getBase());
        		 check.setExp(checksB.get(i).getExp());
        		 check.setNombre(checksB.get(i).getNombre());
        		 check.setTabla(checksB.get(i).getTabla());
        		 for (int j =0 ; j< checksB.get(i).getTrees().size(); j++){
				 	ANTLRInputStream input = new ANTLRInputStream(checksB.get(i).getTrees().get(j));
	
		            // Create an Lexer that receives the char stream
		            SqlLexer lexer = new SqlLexer(input);
		            //lexer.removeErrorListeners();
		            // Create a token stream from the lexer
		            CommonTokenStream tokens = new CommonTokenStream(lexer);
	
		            // Create a parser that receives the token stream
		            SqlParser parser = new SqlParser(tokens);
	
		            SqlParser.ProgramContext arbol = parser.program();
		            
		            check.addTree(arbol);
		            
        		 }
        		 result.add(check);
        	 }
        	 checks=result;
         }
	

	public void generarCheck(){
            GsonBuilder builder = new GsonBuilder();
            builder.serializeNulls();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json = gson.toJson(checks, ArrayList.class);
            File fichero = new File ("BasesDatos","check.json");
            if(fichero.exists()==false){
                try {
                    boolean a=fichero.createNewFile();
                } catch (IOException ex) {
                    Logger.getLogger(EvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
                }
                controlador.escribir(json,fichero.getPath());
            }else{
                controlador.escribir(json,fichero.getPath());
            }
        }

         //metodo para devolver las filas que pasan el check
         public ArrayList<Integer> getcheck (String tabla){
        	 ArrayList<Integer> lista = new ArrayList<Integer>();
        	 ArrayList<org.antlr.v4.runtime.tree.ParseTree> arboles = new ArrayList<org.antlr.v4.runtime.tree.ParseTree>();
        	 for (Check check : checks){
        		 if (check.getTabla().equals(tabla)){
        			 arboles = check.getTrees();
        		 }        	 		 
        	 }
 
        	 
        	 for (org.antlr.v4.runtime.tree.ParseTree arbol : arboles)
        	 {
        		Dato dato = (Dato) visitExpression2((SqlParser.Expression2Context)arbol);
        		 for (int num : dato.getFilas()){
        			 if (!(lista.contains(num))){
        				 lista.add(num);
        			 }
        		 }
        	 }

        	 return lista;
         }
	
         
         //renombrar tabla 
        @Override
         public T visitRename_table_statement(SqlParser.Rename_table_statementContext ctx) {
            if(controlador.getActual()!=null){
                try {
                    controlador.renameT(ctx.getChild(2).getText(),ctx.getChild(5).getText());
                    return null;
                } catch (IOException ex) {
                    Logger.getLogger(EvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                ArrayList errores=controlador.getError();
                errores.add("Error no se establecido que Base de Datos usar.");
                controlador.setError(errores);
            }
            return null;
        }
	
        //drop tabla
        @Override 
        public Object visitDrop_table_statement(SqlParser.Drop_table_statementContext ctx) { 
            if(controlador.getActual()!=null){
                try {
                    controlador.dropT(ctx.getChild(2).getText());
                } catch (IOException ex) {
                    Logger.getLogger(EvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                ArrayList errores=controlador.getError();
                errores.add("Error no se establecido que Base de Datos usar.");
                controlador.setError(errores);
            }
            return null; 
        }
        
        //show tablas
        @Override 
        public T visitShow_table_statement(SqlParser.Show_table_statementContext ctx) { 
            if(controlador.getActual()!=null){
                ArrayList da=controlador.getData(); 
                da.addAll(controlador.showTables());
                controlador.setData(da);
                return null; 
            }else{
                ArrayList errores=controlador.getError();
                errores.add("Error no se establecido que Base de Datos usar.");
                controlador.setError(errores);
                return null;
            }
        }
	
        //show columnas
        @Override 
        public T visitShow_column_statement(SqlParser.Show_column_statementContext ctx) {
            if(controlador.getActual()!=null){
                try {
                    ArrayList da=controlador.getData(); 
                    da.addAll(controlador.showCololums(ctx.getChild(3).getText()));
                    controlador.setData(da);
                    return null; 
                } catch (IOException ex) {
                    Logger.getLogger(EvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
                    return null;
                }
            }else{
                ArrayList errores=controlador.getError();
                errores.add("Error no se establecido que Base de Datos usar.");
                controlador.setError(errores);
                return null; 
            }
        }
        
        //alterar tabla
        @Override public T visitAlter_table_statement(SqlParser.Alter_table_statementContext ctx) {
            if(controlador.getActual()!=null){
                try {
                    actual=controlador.aletT(ctx.getChild(2).getText());
                    controlador.setTablaActual(actual);
                } catch (IOException ex) {
                    Logger.getLogger(EvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
                }
                if(actual!=null){
                    visit(ctx.getChild(3));
                    try {
                        controlador.createT(actual);
                    } catch (IOException ex) {
                        Logger.getLogger(EvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            
            }else{
                ArrayList errores=controlador.getError();
                errores.add("Error no se establecido que Base de Datos usar.");
                controlador.setError(errores);
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
            visit(ctx.getChild(1));
            return null;
        }
	
        @Override
        public T visitDropColumn( SqlParser.DropColumnContext ctx) { 
            
        	//verificamos si no existe alguna tabla que lo referencie 
        	boolean fkexist= false ;
        	for (int i= 0 ; i< controlador.getActual().getTablas().size();i++){
        		ArrayList <ForeignKey> fks =controlador.getActual().getTablas().get(i).getForeignk();
        		for (int j= 0 ; j< fks.size();j++){
        			if (fks.get(j).getTablaref().equals(actual.getNombre())){
        				for (int k= 0 ; k< fks.get(j).getId2().size();k++){
        					if (fks.get(j).getId2().get(k).equals(ctx.getChild(2).getText())){
        						fkexist=true ;
        					}
        				}
        			}
        		}
        	}
        	
        	if (fkexist==false ){
        	
		    	ArrayList <Columna> colum=actual.getColumnas();
		        String busqueda=ctx.getChild(2).getText();
		        busqueda=busqueda.replace(" ", "");
		        System.out.println(busqueda);
		        for(int i=0;i<colum.size();i++){
		            System.out.println(colum.get(i).getNombre());
		            if(colum.get(i).getNombre().equals(busqueda)){
		                colum.remove(i);
		                break;
		            }
		        }
		        actual.setColumnas(colum);
		    	}
        	else {
        		System.out.println("no puede borrar columna ya que es referncia de una PK");
        	}
            return null; 
        }
	@Override public T visitConstraint(SqlParser.ConstraintContext ctx) { 
            System.out.println("siiiip ");
            visit(ctx.getChild(1)); 
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
                 if(c.get(i).getTabla().equals(nombreCons)){
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
                System.out.println("CONTADOR"+ctx.getChildCount());
		for (int i = 0;i<ctx.getChildCount();i++){
			if(! ctx.getChild(i).getText().equals(",")){
                            //System.out.println("");
				values.add((Dato)visit(ctx.getChild(i)));
                                Dato a=(Dato)visit(ctx.getChild(i));
                                System.out.println(a.getValor());
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
                        String valor=ctx.getText();
                        valor=valor.replace("'","");
			dato.setCharacter(valor);
			return (T) dato ;
		}
		
		@Override
		public T visitDate_literal(SqlParser.Date_literalContext ctx) {
			Dato dato = new Dato() ;
			dato.setTipo("date");
                        String valor=ctx.getText().replace("'", "");
			dato.setDate(valor);
			return (T) dato ;
		}
	
                // DML .........................................................
                @Override 
                public T visitDmlstatement(SqlParser.DmlstatementContext ctx) { 
                    for(int i=0; i<ctx.getChildCount();i++){
                        visit(ctx.getChild(i));
                    }
                    return null; 
                }
	
                
                
                @Override 
                public T visitInsert_value(SqlParser.Insert_valueContext ctx) { 
                   
                   //Tomamos la tabla en la cual insertar
                    System.out.println("puta aqui estoy");
                    try {
                        actual=controlador.aletT(ctx.getChild(2).getText());
                        controlador.setTablaActual(actual);
                    } catch (IOException ex) {
                        Logger.getLogger(EvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     //cargamos la lista de pks
                    ArrayList <String> pk=actual.getPrimaryk().get(0).getIdref();
                    controlador.setTablaActual(actual);
                    int cantidadDatos=actual.getColumnas().get(0).getValores().size();
                    ArrayList <String> columnas  =new ArrayList();
                    ArrayList <Dato> valores;
                    int indicador=0; 
                    //Si hay columnas declaradas
                    
                    if(!ctx.getChild(3).getText().equals("VALUES")){
                        //Tomamos las columnas a ingresar
                          for(int i=4;i<ctx.getChildCount();i++){
                              String nombre=ctx.getChild(i).getText();
                              if(nombre.equals(")")){
                                  indicador=i;
                                  System.out.println(indicador);
                                  break;
                              }
                              if(!",".equals(nombre)){
                                  columnas.add(nombre);
                              }
                          }
                          //Tomamos los valores
                          valores=(ArrayList <Dato>) visit(ctx.getChild(indicador+3));
                          ArrayList <Columna> col=actual.getColumnas();
                          //Contador de valores en value
                          int valuescont=valores.size();
                          //valores ingresados igual a columnas declaradas
                          if(valuescont==columnas.size()){
                              System.out.println("aqui toy");
                              //verificacion que no exceda cantidad de columnas
                              if(columnas.size()<=col.size()){
                                  for(int i=0; i<columnas.size();i++){
                                        Columna c=controlador.getColumna(col,(String)columnas.get(i));
                                        System.out.println(c.getNombre());
                                        if(c.getTipo().equals("char")){
                                            int cant=valores.get(i).getValor().toString().length();
                                            if(cant>c.getCharCant()){
                                                ArrayList errores=controlador.getError();
                                                errores.add("Error el valor ingresado sobrepasa la cantidad de caracters."); 
                                                controlador.setError(errores);
                                                error=true;
                                                break;
                                            }
                                        }
                                        boolean ingreso=true;
                                        if(c.getTipo().equals(valores.get(i).getTipo())){
                                            //Ingresamos valor
                                            ingreso=c.setValor(valores.get(i).getValor(),pk);
                                            System.out.println("ooooollleeeee");
                                        }else{
                                            //Realizamos casteoo
                                            if("int".equals(c.getTipo()) && "float".equals(valores.get(i).getTipo())){
                                                float valor= (float)valores.get(i).getValor();
                                                int val=Math.round(valor);
                                                ingreso=c.setValor(val,pk);

                                            }
                                            if("float".equals(c.getTipo()) && "int".equals(valores.get(i).getTipo())){
                                                int valor= (int)valores.get(i).getValor();
                                                float val=(float)valor;
                                                ingreso=c.setValor(val,pk);

                                            }
                                            if("char".equals(c.getTipo()) && "float".equals(valores.get(i).getTipo())){
                                                float valor= (float)valores.get(i).getValor();
                                                String val=Float.toString(valor);
                                                ingreso=c.setValor(val,pk);

                                            }
                                            if("char".equals(c.getTipo()) && "int".equals(valores.get(i).getTipo())){
                                                int valor= (int)valores.get(i).getValor();
                                                String val=Integer.toString(valor);
                                                ingreso=c.setValor(val,pk);
                                            }
                                            if("char".equals(c.getTipo()) && "date".equals(valores.get(i).getTipo())){
                                                ingreso=c.setValor(valores.get(i).getValor(),pk);
                                            }
                                            else{
                                                System.out.println("Tipos de datos no compatibles");
                                            }
                                        }
                                        if(ingreso==false){
                                            ArrayList errores=controlador.getError();
                                            errores.add("Error una primary no puede tener valores repetidos."); 
                                            controlador.setError(errores);
                                            error=true;
                                            break;
                                        }
                                        //Lo ingresamos a la lista de columnas
                                        for(int l=0; l<col.size();l++){
                                            if(col.get(l).equals(c.getNombre())){
                                                col.set(l, c);
                                            }
                                        }
                                      
                                  }
                                  //si no estan definidos todas las columnas
                                 if(columnas.size()<col.size()){
                                      //buscar que columnas estan vacios
                                        for(int i=0; i<col.size();i++){
                                            if(columnas.contains(col.get(i).getNombre())==false){
                                                col.get(i).setValor(null);
                                            }
                                        }
                                  }
                                  
                              }else{
                                ArrayList errores=controlador.getError();
                                errores.add("Error cantidad de columnas instanciadas sobrepasa la cantidad de columnas en la tabla."); 
                                controlador.setError(errores);
                                error=true;
                                  
                              }
                           }else{
                                ArrayList errores=controlador.getError();
                                errores.add("Error cantidad de columnas instanciadas no conincide con cantidad de valores."); 
                                controlador.setError(errores);
                                error=true;
                              
                          }
                          //AGREGAMOS EL VALOR SI NO HAY ERROR
                          if(error==false){
                              actual.setColumnas(col);
                              try {
                                  controlador.createT(actual);
                              } catch (IOException ex) {
                                  Logger.getLogger(EvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
                              }
                              ArrayList <Integer> vals= getcheck(actual.getNombre());
                              if(vals.contains(cantidadDatos)==false){
                                  ArrayList <Columna> c=actual.getColumnas();
                                  for(int i=0;i<c.size();i++){
                                      ArrayList a=c.get(i).getValores();
                                      a.remove(cantidadDatos);
                                      c.get(i).setValores(a);
                                  }
                                  actual.setColumnas(c);
                                   try {
                                  controlador.createT(actual);
                                } catch (IOException ex) {
                                    Logger.getLogger(EvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
                                }

                                }
                          }
                    }
                    //no especifica columnas
                    else{
                        System.out.println("sippp aqui putito");
                        ArrayList <Columna> col=actual.getColumnas();
                        valores=(ArrayList <Dato>) visit(ctx.getChild(5));
                         //Si existe values para cada columna 
                        int valuescont=valores.size();
                        System.out.println(valuescont);
                        System.out.println(col.size());
                        if(valuescont<=col.size()){
                            System.out.println("ssssiiii qui");
                                for(int i=0; i<valores.size();i++){
                                        //Si son del mismo tipo
                                        if(col.get(i).getTipo().equals("char")){
                                            int cant=valores.get(i).getValor().toString().length();
                                            if(cant>col.get(i).getCharCant()){
                                                ArrayList errores=controlador.getError();
                                                errores.add("Error el valor ingresado sobrepasa la cantidad de caracters."); 
                                                controlador.setError(errores);
                                                error=true;
                                                break;
                                            }
                                        }
                                        boolean ingreso=true;
                                        if(col.get(i).getTipo().equals(valores.get(i).getTipo())){
                                            System.out.println("oppp");
                                                //Ingresamos valor
                                                //verficar aqui
                                                 ingreso=col.get(i).setValor(valores.get(i).getValor(),pk);
                                                 System.out.println("oleee");
                                        }else{
                                                //Realizamos casteoo
                                                if("int".equals(col.get(i).getTipo()) && "float".equals(valores.get(i).getTipo())){
                                                        System.out.println("noo?");
                                                        float valor= (float)valores.get(i).getValor();
                                                        int val=(int)valor;
                                                        ingreso=col.get(i).setValor(val,pk);

                                                }
                                                if("float".equals(col.get(i).getTipo()) && "int".equals(valores.get(i).getTipo())){
                                                        int valor= (int)valores.get(i).getValor();
                                                        float val=(float)valor;
                                                        ingreso=col.get(i).setValor(val,pk);

                                                }
                                                if("char".equals(col.get(i).getTipo()) && "float".equals(valores.get(i).getTipo())){
                                                        float valor= (float)valores.get(i).getValor();
                                                        String val=Float.toString(valor);
                                                        ingreso=col.get(i).setValor(val,pk);

                                                }
                                                if("char".equals(col.get(i).getTipo()) && "int".equals(valores.get(i).getTipo())){
                                                        int valor= (int)valores.get(i).getValor();
                                                        String val=Integer.toString(valor);
                                                        ingreso=col.get(i).setValor(val,pk);
                                                }
                                                if("char".equals(col.get(i).getTipo()) && "date".equals(valores.get(i).getTipo())){
                                                        ingreso=col.get(i).setValor(valores.get(i).getValor(),pk);
                                                }
                                                else{
                                                        System.out.println("Tipos de datos no compatibles");
                                                }
                                        }
                                        if(ingreso==false){
                                            ArrayList errores=controlador.getError();
                                            errores.add("Error una primary no puede tener valores repetidos."); 
                                            controlador.setError(errores);
                                            error=true;
                                            break;
                                        }
                                        //fin else
                                }//fin for 
                                if(valuescont<col.size()){
                                    System.out.println("menor?");
                                         for(int i=valuescont; i<col.size();i++){
                                                col.get(i).setValor(null);
                                                }
                                        }
                        }else{
                            ArrayList errores=controlador.getError();
                            errores.add("Error cantidad de columnas instanciadas sobrepasa la cantidad de columnas en la tabla."); 
                            controlador.setError(errores);
                            error=true;
                        }
                        if(error==false){
                              actual.setColumnas(col);
                              try {
                                  controlador.createT(actual);
                              } catch (IOException ex) {
                                  Logger.getLogger(EvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
                              }
                              ArrayList <Integer> vals= getcheck(actual.getNombre());
                              if(vals.contains(cantidadDatos)==false){
                                  ArrayList <Columna> c=actual.getColumnas();
                                  for(int i=0;i<c.size();i++){
                                      ArrayList a=c.get(i).getValores();
                                      a.remove(cantidadDatos);
                                      c.get(i).setValores(a);
                                  }
                                  actual.setColumnas(c);
                                   try {
                                  controlador.createT(actual);
                                } catch (IOException ex) {
                                    Logger.getLogger(EvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
                                }

                                }
                          }
                    }
                    error=false;
                     return null; 
                }
       
                //update
                
                @Override 
                public T visitUpdate_value(SqlParser.Update_valueContext ctx) { 
                    try {
                        actual=controlador.aletT(ctx.getChild(1).getText());
                    } catch (IOException ex) {
                        Logger.getLogger(EvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    if(actual!=null){
                        controlador.setTablaActual(actual);
                        Map <String, Dato> map= new HashMap <String, Dato>();
                        int cont=0;
                        String id="";
                        Dato literal=null;
                        boolean where=false;
                        int indicador=0; 
                        for(int i=3;i<ctx.getChildCount()-1;i++){
                          if(ctx.getChild(i).getText().equals("WHERE")){
                                indicador=i;
                                where=true;
                                break; 
                            }
                            if(!",".equals(ctx.getChild(i).getText())&&!"=".equals(ctx.getChild(i).getText())){
                                if(cont==1){
                                    System.out.println("ingresando");
                                    System.out.println(id);
                                    literal=(Dato)visit(ctx.getChild(i));
                                    map.put(id,literal);
                                    cont=0;
                                }
                                if(cont==0){
                                    id=ctx.getChild(i).getText();
                                    cont++;
                                }
                            }
                        }
                        if(where==true){
                            Dato data=(Dato) visit(ctx.getChild(indicador+1));
                            ArrayList <Integer> valores=data.getFilas();
                            ArrayList <Columna> columnas=actual.getColumnas();
                            for(int i=0; i<columnas.size();i++){
                                Dato ingreso=map.get(columnas.get(i).getNombre());
                                if(ingreso!= null){
                                    ArrayList datos=columnas.get(i).getValores();
                                    for(int l=0; l<valores.size();l++){
                                        datos.set(valores.get(l), ingreso.getValor());
                                        columnas.get(i).setValores(datos);
                                    }
                                }
                            }
                            actual.setColumnas(columnas);
                        }
                        else{
                            ArrayList <Columna> columnas=actual.getColumnas();
                            for(int i=0; i<columnas.size();i++){
                                Dato ingreso=map.get(columnas.get(i).getNombre());
                                if(ingreso!= null){
                                    System.out.println("ingreso cargado listo para update");
                                    ArrayList datos=columnas.get(i).getValores();
                                    for(int l=0; l<datos.size();l++){
                                        datos.set(l, ingreso.getValor());
                                        columnas.get(i).setValores(datos);
                                    }
                                }
                            }
                            actual.setColumnas(columnas);
                        }
                        try {
                            controlador.createT(actual);
                        } catch (IOException ex) {
                            Logger.getLogger(EvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    return null; 
                }
                
                
                @Override 
                public T visitDelete_value(SqlParser.Delete_valueContext ctx) { 
                    
                     try {
                        actual=controlador.aletT(ctx.getChild(2).getText());
                    } catch (IOException ex) {
                        Logger.getLogger(EvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                     System.out.println("que ishee");
                    if(actual!=null){
                        controlador.setTablaActual(actual);
                        System.out.println("passoo");
                        if(ctx.getChildCount()>4){
                            Dato data=(Dato) visit(ctx.getChild(4));
                            System.out.println("si regesa al visitor");
                            ArrayList <Integer> valores=data.getFilas();
                            ArrayList <Columna> columnas=actual.getColumnas();
                            for(int i=0; i<columnas.size();i++){
                                ArrayList datos=columnas.get(i).getValores();
                                 for(int l=0; l<valores.size();l++){
                                     System.out.println("e");
                                     datos.remove(valores.get(l));
                                     datos.remove(valores.get(l));
                                     columnas.get(i).setValores(datos);
                                 }
                                 System.out.println("aqui como mueve la colita");
                                 columnas.get(i).setValores(datos);
                            }
                            actual.setColumnas(columnas);
                        }
                        else{
                            ArrayList <Columna> columnas=actual.getColumnas();
                            for(int i=0; i<columnas.size();i++){
                                columnas.get(i).setValores(new ArrayList());
                            }
                            actual.setColumnas(columnas);
                        }
                        try {
                            controlador.createT(actual);
                        } catch (IOException ex) {
                            Logger.getLogger(EvalVisitor.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    return null; 
                }
	
	
                //Order By
             /**   @Override 
                public T visitorderBy_Asc(SqlParser.OrderBy_Asc ctx) { 
                   //Tomamos la tabla en la cual insertar
                    controlador.setTablaActual(actual);
                    ArrayList columnas =new ArrayList();
                    ArrayList <Dato> valores;
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
                public T visitorderBy_Desc(sqlParser.OrderBy_Desc ctx) { 
                   //Tomamos la tabla en la cual insertar
                    controlador.setTablaActual(actual);
                    ArrayList columnas =new ArrayList();
                    ArrayList <Dato> valores;
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
		
		//****
		@Override
		public T visitFactorID(SqlParser.FactorIDContext ctx) {
			Columna col = controlador.getIDvalues(ctx.getText());
			Dato dato = new Dato();
			dato.setTipo(col.getTipo());
			ArrayList<Integer> lista = new ArrayList<Integer>();
			for (int i =0 ; i< col.getTamanio(); i++){
				lista.add(i);
			}
			
			dato.setColumna(col.getValores());
			dato.setFilas(lista);
			dato.setTipo(col.getTipo());
			return (T) dato;
		}
		
		public T visitFactorID2(SqlParser.FactorID2Context ctx) {
			Columna col = controlador.getIDvalues(ctx.getChild(2).getText());
			Dato dato = new Dato();
			dato.setTipo(col.getTipo());
			ArrayList<Integer> lista = new ArrayList<Integer>();
			for (int i =0 ; i< col.getTamanio(); i++){
				lista.add(i);
			}
			
			dato.setColumna(col.getValores());
			dato.setFilas(lista);
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
						
			Dato dato1 = (Dato) visit(ctx.getParent().getChild(0));
			Dato dato2 = (Dato) visit(ctx.getParent().getChild(2));
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
			
			Dato dato1 = (Dato) visit(ctx.getParent().getChild(0));
			Dato dato2 = (Dato) visit(ctx.getParent().getChild(2));
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
			Dato dato1 = (Dato) visit(ctx.getParent().getChild(0));
			Dato dato2 = (Dato) visit(ctx.getParent().getChild(2));
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

			Dato dato1 = (Dato) visit(ctx.getParent().getChild(0));
			Dato dato2 = (Dato) visit(ctx.getParent().getChild(2));
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
			Dato dato1 = (Dato) visit(ctx.getParent().getChild(0));
			Dato dato2 = (Dato) visit(ctx.getParent().getChild(2));
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
			Dato dato1 = (Dato) visit(ctx.getParent().getChild(0));
			Dato dato2 = (Dato) visit(ctx.getParent().getChild(2));
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
						
			Dato dato1 = (Dato) visit(ctx.getParent().getChild(0));
			Dato dato2 = (Dato) visit(ctx.getParent().getChild(2));
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
			
			Dato dato1 = (Dato) visit(ctx.getParent().getChild(0));
			Dato dato2 = (Dato) visit(ctx.getParent().getChild(2));
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
			
			Dato dato1 = (Dato) visit(ctx.getParent().getChild(0));
			Dato dato2 = (Dato) visit(ctx.getParent().getChild(2));
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

			
			Dato dato1 = (Dato) visit(ctx.getParent().getChild(0));
			Dato dato2 = (Dato) visit(ctx.getParent().getChild(2));
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
			Dato dato1 = (Dato) visit(ctx.getParent().getChild(0));
			Dato dato2 = (Dato) visit(ctx.getParent().getChild(2));
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
			Dato dato1 = (Dato) visit(ctx.getParent().getChild(0));
			Dato dato2 = (Dato) visit(ctx.getParent().getChild(2));
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
						
			Dato dato1 = (Dato) visit(ctx.getParent().getChild(0));
			Dato dato2 = (Dato) visit(ctx.getParent().getChild(2));
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
			
			Dato dato1 = (Dato) visit(ctx.getParent().getChild(0));
			Dato dato2 = (Dato) visit(ctx.getParent().getChild(2));
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
			Dato dato1 = (Dato) visit(ctx.getParent().getChild(0));
			Dato dato2 = (Dato) visit(ctx.getParent().getChild(2));
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

			Dato dato1 = (Dato) visit(ctx.getParent().getChild(0));
			Dato dato2 = (Dato) visit(ctx.getParent().getChild(2));
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
			Dato dato1 = (Dato) visit(ctx.getParent().getChild(0));
			Dato dato2 = (Dato) visit(ctx.getParent().getChild(2));
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
			Dato dato1 = (Dato) visit(ctx.getParent().getChild(0));
			Dato dato2 = (Dato) visit(ctx.getParent().getChild(2));
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
			Dato dato1 = (Dato) visit(ctx.getParent().getChild(0));
			Dato dato2 = (Dato) visit(ctx.getParent().getChild(2));
			ArrayList<Integer> lista =dato2.getFilas();
			ArrayList<Integer> lista2 = new ArrayList<Integer>(); 
			//agegamos los del primer dato
			for (int i=0 ; i<dato1.getFilas().size(); i++){
				if (!(lista.contains(dato1.getFilas().get(i)))){
					lista2.add(dato1.getFilas().get(i));
				}
			}
			
			dato2.setFilas(lista2);
			return (T) dato2;
		}
		

		
		@Override 
		public T visitCond_op2(SqlParser.Cond_op2Context ctx) {
			Dato dato1 = (Dato) visit(ctx.getParent().getChild(0));
			Dato dato2 = (Dato) visit(ctx.getParent().getChild(2));
			ArrayList<Integer> lista =dato2.getFilas();
					
			//agegamos los del primer dato
			for (int i=0 ; i<dato1.getFilas().size(); i++){
				if (!(lista.contains(dato1.getFilas().get(i)))){
					lista.add(dato1.getFilas().get(i));
				}
			}
			
			dato2.setFilas(lista);
			return (T) dato2;
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
		
		//***************tipo_liteals ***************************
		
		@Override
		public T visitTipoInt(SqlParser.TipoIntContext ctx) {
			Columna col = new Columna("","int");
			return (T)col;
		}
		
		public T visitTipoFloat(SqlParser.TipoFloatContext ctx) {
			Columna col = new Columna("","float");
			return (T)col;
		}
		
		public T visitTipoDate(SqlParser.TipoDateContext ctx) {
			Columna col = new Columna("","date");
			return (T)col;
		}
		

		public T visitTipoChar(SqlParser.TipoCharContext ctx) {
			Columna col = new Columna("","char");
			col.setCharCant(Integer.parseInt(ctx.getChild(1).getText()));
			return (T)col;
		}

}


