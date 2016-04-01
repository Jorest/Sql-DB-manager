

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
import java.util.Map;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luis
 */
public class Controlador {
    private ArrayList nombresBD; 
    private ArrayList cantTablas; 
    private BaseDatos actual;

    public Controlador() {
    }
    
    
    public void createDB(String nombre){
        BaseDatos b=new BaseDatos(nombre);
         try{
                    File directorio = new File("BasesDatos/"+b.getNombre());
                    directorio.mkdir();
        
         }catch(Exception e) {
              System.out.println("No se pudo crear la Base de Datos "+ nombre);
         }
  
}
    public void alterDB(String nombre, String newname){
        File directorio= new File("BasesDatos/"+nombre);
        File directorio1= new File("BasesDatos/"+newname);
        boolean resul=directorio.renameTo(directorio1);
        if(resul==false){
            System.out.println("Error en el cambio de nombre a Base de Datos "+ nombre);
        }
        
    }
    public void dropDB(String nombre){
        File directorio= new File("BasesDatos/"+nombre);
        boolean resul=directorio.delete();
        if(resul==false){
            System.out.println("Error en el cambio de nombre a Base de Datos "+ nombre);
        }
    }
    public void useDB(String nombre){
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
         //Ingresar las tablas a la base de datos con el set
        
    }
    private void createT(String nombre,ArrayList columnas,ArrayList primary, ArrayList fore, ArrayList check){
        Tabla t=new Tabla(nombre);
        t.setColumnas(columnas);
        t.setForeignk(fore);
        t.setPrimaryk(primary);
        t.setCheck(check);
        GsonBuilder builder = new GsonBuilder();
        builder.serializeNulls();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(t);
        String path= "BaseDatos/"+actual.getNombre()+"/"+t.getNombre()+".json";
        escribir(json,path);
        actual.setTabla(t);
    }
    private void renameT(String nombre, String nnombre) throws IOException{
        String json= readFile("BasesDatos/"+actual.getNombre()+"/"+nombre+".json");
        Gson gson1 = new Gson();
        Tabla t = gson1.fromJson(json, Tabla.class);
        t.setNombre(nnombre);
        dropT(nombre);
        GsonBuilder builder = new GsonBuilder();
        builder.serializeNulls();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        json = gson.toJson(t);
        String path= "BaseDatos/"+actual.getNombre()+"/"+t.getNombre()+".json";
        escribir(json,path); 
     
    }
    private void addColum(){
        
    }
    private void addConstraint(){
        
    }
    private void dropColumn(){
        
    }
    public void dropT(String nombre){
        File directorio= new File("BaseDatos/"+actual.getNombre()+"/"+nombre+".json");
        boolean resul=directorio.delete();
        if(resul==false){
            System.out.println("Error en el cambio de nombre a Base de Datos "+ nombre);
        }
        
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
    private static String readFile(String filePath) throws java.io.IOException{
	    byte[] buffer = new byte[(int) new File(filePath).length()];
	    BufferedInputStream f = null;
	    try {
	        f = new BufferedInputStream(new FileInputStream(filePath));
	        f.read(buffer);
	        if (f != null) try { f.close(); } catch (IOException ignored) { }
	    } catch (IOException ignored) { System.out.println("File not found or invalid path.");}
	    return new String(buffer);
	}
}

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luis
 */
public class Controlador {
    private ArrayList nombresBD; 
    private ArrayList cantTablas; 
    private BaseDatos actual;

    public Controlador() {
    }
    
    
    public void createDB(String nombre){
        BaseDatos b=new BaseDatos(nombre);
         try{
                    File directorio = new File("BasesDatos/"+b.getNombre());
                    directorio.mkdir();
        
         }catch(Exception e) {
              System.out.println("No se pudo crear la Base de Datos "+ nombre);
         }
  
}
    public void alterDB(String nombre, String newname){
        File directorio= new File("BasesDatos/"+nombre);
        File directorio1= new File("BasesDatos/"+newname);
        boolean resul=directorio.renameTo(directorio1);
        if(resul==false){
            System.out.println("Error en el cambio de nombre a Base de Datos "+ nombre);
        }
        
    }
    public void dropDB(String nombre){
        File directorio= new File("BasesDatos/"+nombre);
        boolean resul=directorio.delete();
        if(resul==false){
            System.out.println("Error en el cambio de nombre a Base de Datos "+ nombre);
        }
    }
    public void useDB(String nombre){
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
         //Ingresar las tablas a la base de datos con el set
        
    }
    private void createT(String nombre,ArrayList columnas,ArrayList primary, ArrayList fore, ArrayList check){
        Tabla t=new Tabla(nombre);
        t.setColumnas(columnas);
        t.setForeignk(fore);
        t.setPrimaryk(primary);
        t.setCheck(check);
        GsonBuilder builder = new GsonBuilder();
        builder.serializeNulls();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(t);
        String path= "BaseDatos/"+actual.getNombre()+"/"+t.getNombre()+".json";
        escribir(json,path);
        actual.setTabla(t);
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
}





















