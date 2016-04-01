
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luis (wecaso)
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
}
