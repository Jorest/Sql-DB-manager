

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
                    log.add("Base de Datos creada: "+nombre);
        
         }catch(Exception e) {
               Error.add("No se pudo crear Bases de Datos :"+nombre + ", compruebe que ese nombre no exista.");
         }
  
}
    public void alterDB(String nombre, String newname){
        File directorio= new File("BasesDatos/"+nombre);
        File directorio1= new File("BasesDatos/"+newname);
        boolean resul=directorio.renameTo(directorio1);
        if(resul==false){
            Error.add("Error en el cambio de nombre a Base de Datos: "+ nombre);
        }
        log.add("Base de Datos renombrada, Nuevo nombre: "+newname+", Nombre anterior: "+nombre);
        
    }
    public void dropDB(String nombre){
        File directorio= new File("BasesDatos/"+nombre);
        JOptionPane optionPane = new JOptionPane(
        "Esta seguro de quere eliminar la Base de Datos: "+nombre,
        JOptionPane.QUESTION_MESSAGE,
        JOptionPane.YES_NO_OPTION);
        boolean resul=directorio.delete();
        if(resul==false){
            System.out.println("Error en el borrado de nombre a Base de Datos "+ nombre);
        }
    }
    public ArrayList showDB(){
        ArrayList nombre= new ArrayList();
        File directorio= new File("BasesDatos");
        File[] bases=directorio.listFiles();
        for(int i=0; i<bases.length;i++){
            nombre.add(bases[i].getName());
        }
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
         System.out.println("Encontrado");
         actual= new BaseDatos(base.getName());
         cargarTablas();
         System.out.println("yapppp");
         //Ingresar las tablas a la base de datos con el set
        
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
        //String path= "BaseDatos/"+actual.getNombre();
        File fichero = new File ("BasesDatos/"+actual.getNombre(), t.getNombre()+".json");
        boolean a=fichero.createNewFile();
        System.out.println(a);
        System.out.println("mmmmeiureireiu");
        escribir(json,fichero.getPath());
        //actual.setTabla(t);
        cargarTablas();
    }

    public void renameT(String nombre, String nnombre) throws IOException{
        File directorio= new File("BasesDatos/"+actual.getNombre()+"/"+nombre+".json");
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
        cargarTablas();
     
    }
   
    public Tabla aletT(String nombre) throws IOException{
         File directorio= new File("BasesDatos/"+actual.getNombre(),nombre+".json");
         String json= readFile(directorio.getPath());
         Gson gson1 = new Gson();
         Tabla t = gson1.fromJson(json, Tabla.class);
         return t; 
    }
    public void dropT(String nombre) throws IOException{
        File directorio= new File("BasesDatos/"+actual.getNombre(),nombre+".json");
        boolean resul=directorio.delete();
        if(resul==false){
            System.out.println("Error AL BORRAR TABLA "+ nombre);
        }
        cargarTablas();
        
    }
   
    public ArrayList showTables(){
        ArrayList resul=new ArrayList();
        if(actual!=null){
            File directorio= new File("BasesDatos/"+actual.getNombre());
            File[] bases=directorio.listFiles();
            File base=null; 
            for(int i=0; i<bases.length;i++){
                resul.add(bases[i].getName());
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
           PrintWriter salida= new PrintWriter(bw);
           salida.println(datos);
           salida.close();
                   
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
