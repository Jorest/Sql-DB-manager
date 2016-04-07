

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luis
 */
public class ControladorDB {
    private ArrayList nombresBD; 
    private ArrayList cantTablas; 
    private BaseDatos actual;
    private Tabla tablaActual ;
    private ArrayList Data;
    private ArrayList Error;
    private ArrayList log;
    
    public ControladorDB() {
        Data=new ArrayList();
        Error=new ArrayList();
        log=new ArrayList();
        actual=null;
    }

    public ArrayList getData() {
        return Data;
    }

    public void setData(ArrayList Data) {
        this.Data = Data;
    }

    public ArrayList getError() {
        return Error;
    }

    public void setError(ArrayList Error) {
        this.Error = Error;
    }

    public ArrayList getLog() {
        return log;
    }

    public void setLog(ArrayList log) {
        this.log = log;
    }
    
    

    public BaseDatos getActual() {
            return actual;
    }


    public void setActual(BaseDatos actual) {
            this.actual = actual;
    }


    public Tabla getTablaActual() {
            return tablaActual;
    }


    public void setTablaActual(Tabla tablaActual) {
            this.tablaActual = tablaActual;
    }


    public void createDB(String nombre){
        BaseDatos b=new BaseDatos(nombre);
         try{
                    File directorio = new File("BasesDatos/"+b.getNombre());
                    if(directorio.mkdir()==false){
                        Error.add("No se pudo crear Base de Datos :"+nombre + ", compruebe que ese nombre no exista.");
                    }
                    else{
                        generarA();
                        log.add("Base de Datos creada: "+nombre);
                    }
                    
         }catch(Exception e) {
               Error.add("No se pudo crear Bases de Datos :"+nombre + ", compruebe que ese nombre no exista.");
         }
  
}
    public void alterDB(String nombre, String newname) throws IOException{
        File directorio= new File("BasesDatos/"+nombre);
        if(directorio.exists()==true){
            File directorio1= new File("BasesDatos/"+newname);
            boolean resul=directorio.renameTo(directorio1);
            if(resul==false){
                Error.add("Error en el cambio de nombre a Base de Datos: "+ nombre);
            }else{
                generarA();
                log.add("Base de Datos renombrada, Nuevo nombre: "+newname+", Nombre anterior: "+nombre);
            }
        }else{
            System.out.println("No existe");
            Error.add("Error en el cambio de nombre a Base de Datos, Bases de Datos "+ nombre+" no existe");
        }
    }
    public void dropDB(String nombre) throws IOException{
        File directorio= new File("BasesDatos/"+nombre);
        if(directorio.exists()==true){
            int response = JOptionPane.showConfirmDialog(null, "Esta seguro de quere eliminar la Base de Datos: "+nombre+" ?", "Confirm",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (response == JOptionPane.YES_OPTION) {
                //System.out.println("ssisisi");
                boolean resul=directorio.delete();
                if(resul==false){
                    Error.add("Error en el borrado de nombre a Base de Datos "+ nombre);
                }else{
                    generarA();
                    log.add("Base de Datos "+nombre+" elimnada.");

                }

            }
        }else{
            Error.add("Error al intentar elimnar Base de Datos, BD "+ nombre+" no existe");
        }
    }
    public ArrayList showDB(){
        ArrayList nombre= new ArrayList();
        File directorio= new File("BasesDatos");
        File[] bases=directorio.listFiles();
        for(int i=0; i<bases.length;i++){
            nombre.add(bases[i].getName());
        }
        log.add("Cargando Bases de Datos");
        return nombre;
    }
    public void useDB(String nombre) throws IOException{
         File directorio= new File("BasesDatos");
         File[] bases=directorio.listFiles();
         File base=null;
         for(int i=0; i<bases.length;i++){
             if(bases[i].getName().equals(nombre)){
                 base=bases[i];
                 break;
             }
         }
         if(base!=null){
            actual= new BaseDatos(base.getName());
            log.add("Bases de Datos ");
            log.add("Base de Datos en uso: "+nombre);
            cargarTablas();
            generarA();
         }//Ingresar las tablas a la base de datos con el set
         else{
             Error.add("Error al cargar Base de Datos para ser utilizada, BD "+ nombre+" no existe");
         }
    }
    public void generarA() throws IOException{
         Map <String,Integer> archivo = new HashMap();
         File directorio= new File("BasesDatos");
         File[] bases=directorio.listFiles();
         for(int i=0; i<bases.length;i++){
            File directorio1= new File("BasesDatos/"+bases[i].getName());
            File [] files=directorio1.listFiles();
            if(files!=null){
                archivo.put(bases[i].getName(), files.length);
         
            }
        }
        GsonBuilder builder = new GsonBuilder();
        builder.serializeNulls();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(archivo);
        File fichero = new File ("BasesDatos","basesDato.json");
        if(fichero.exists()==false){
            boolean a=fichero.createNewFile();
            escribir(json,fichero.getPath());
        }else{
            escribir(json,fichero.getPath());
        }
    }
    public void cargarTablas() throws IOException{
         ArrayList <Tabla> tablas=new ArrayList();
         File directorio= new File("BasesDatos/"+actual.getNombre());
         File[] bases=directorio.listFiles();
         Gson gson1 = new Gson();
         for(int i=0; i<bases.length; i++){
             String json=readFile(bases[i].getPath());
             Tabla t = gson1.fromJson(json, Tabla.class);
             tablas.add(t);
         }
         actual.setTablas(tablas);
    }
    public void createT(Tabla t) throws IOException{
        GsonBuilder builder = new GsonBuilder();
        builder.serializeNulls();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(t);
        System.out.println(json);
        File fichero = new File ("BasesDatos/"+actual.getNombre(), t.getNombre()+".json");
        //if(fichero.exists()==false){
            boolean a=fichero.createNewFile();
            escribir(json,fichero.getPath());
            log.add("Tabla "+t.getNombre()+" creada, en Base de Datos "+actual.getNombre());
            cargarTablas();
            generarA();
        /*}else{
            Error.add("Error al intentar crear Tabla, Tabla"+ t.getNombre()+" ya existe");
        }*/
    }

    public void renameT(String nombre, String nnombre) throws IOException{
        File directorio= new File("BasesDatos/"+actual.getNombre()+"/"+nombre+".json");
        if(directorio.exists()){
            String json= readFile(directorio.getPath());
            Gson gson1 = new Gson();
            Tabla t = gson1.fromJson(json, Tabla.class);
            t.setNombre(nnombre);
            dropT(nombre);
            GsonBuilder builder = new GsonBuilder();
            builder.serializeNulls();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            json = gson.toJson(t);
            File fichero = new File ("BasesDatos/"+actual.getNombre(),t.getNombre()+".json");
            fichero.createNewFile();
            escribir(json,fichero.getPath()); 
            log.add("Tabla  renombrada. Nomnre Actual: "+nnombre+", Nombre Anterior: "+nombre);
            cargarTablas();
            generarA();
        }else{
            Error.add("Error al intentar renombra Tabla, Tabla "+ nombre+" no existe");
        }
     
    }
   
    public Tabla aletT(String nombre) throws IOException{
         File directorio= new File("BasesDatos/"+actual.getNombre(),nombre+".json");
         if(directorio.exists()){
            String json= readFile(directorio.getPath());
            Gson gson1 = new Gson();
            Tabla t = gson1.fromJson(json, Tabla.class);
            return t;
          }else{
            Tabla t= null;
            Error.add("Error al intentar cargar Tabla, Tabla "+ nombre+" no existe");
            return t; 
          }
    }
    public void dropT(String nombre) throws IOException{
        File directorio= new File("BasesDatos/"+actual.getNombre(),nombre+".json");
        if(directorio.exists()){
            boolean resul=directorio.delete();
            if(resul==false){
                System.out.println("Error AL BORRAR TABLA "+ nombre);
            }else{
                log.add("Tabla "+nombre+ " eliminada.");
                cargarTablas();
                generarA();
            }
        }else{
            Error.add("Error al intentar eliminar Tabla, Tabla "+ nombre+" no existe");
           
        }
        
    }
    
    public ArrayList showTables(){
        ArrayList resul=new ArrayList();
        if(actual!=null){
            File directorio= new File("BasesDatos/"+actual.getNombre());
            File[] bases=directorio.listFiles();
            File base=null; 
            for(int i=0; i<bases.length;i++){
                resul.add(bases[i].getName().replace(".json", ""));
            }
        }
        return resul;
    }
    public ArrayList showCololums(String nombre) throws IOException{
         ArrayList resul=new ArrayList();
         String json= readFile("BasesDatos/"+actual.getNombre()+"/"+nombre+".json");
         Gson gson1 = new Gson();
         Tabla t = gson1.fromJson(json, Tabla.class);
         ArrayList columnas=t.getColumnas();
         for(int i=0;i<columnas.size();i++){
             Columna c=(Columna)columnas.get(i);
             resul.add(c.getNombre());
         }
        return resul; 
    }
    public String escribir(String datos,  String path){
       //codigo=codigo.replace(' ', '\n');
       try{
           FileWriter fw= new FileWriter(path);
           BufferedWriter bw = new BufferedWriter(fw);
           try (PrintWriter salida = new PrintWriter(bw)) {
               salida.println(datos);
           }
                   
       }
       catch(java.io.IOException ioex){
           System.out.println("Se presento un error: " + ioex);
       }
       return path;
   }
    //agregado por jorge
    public Columna getIDvalues (String id){  
    	Columna columnareturn = null;
    	for (Columna columna : tablaActual.getColumnas()) {
    	    if (columna.getNombre().equals(id)){
    	    	columnareturn = columna ;
    	    }
    	}
    	return columnareturn;
    }
    
    public Columna getColumna (ArrayList <Columna> columnas,String id){  
    	Columna columnareturn = null;
    	for (Columna columna : columnas) {
    	    if (columna.getNombre().equals(id)){
    	    	columnareturn = columna ;
    	    }
    	}
    	return columnareturn;
    }
    
    private static String readFile(String filePath) throws java.io.IOException{
	    byte[] buffer = new byte[(int) new File(filePath).length()];
	    BufferedInputStream f = null;
	    try {
	        f = new BufferedInputStream(new FileInputStream(filePath));
	        f.read(buffer);
	        if (f != null) try { f.close(); } catch (IOException ignored) { }
	    } catch (IOException ignored) { System.out.println("File not found or invalid path.");}
            f.close();
	    return new String(buffer);
	}
}
