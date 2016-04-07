
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Esta clase posee un metodo constructor, los sets y los gets de atributos comunmente utilizados en el manejo de tablas en una base de datos
 * @author Luis
 * @version 07/04/2016/A
 */

 
public class BaseDatos {
    
    //Campos de la clase
    private String nombre; 
    private List <Tabla> tablas; 

    //Constructor
    public BaseDatos(String nombre) {
        this.nombre = nombre;
        tablas=new ArrayList() ;
    }

    public BaseDatos() {
    	
    }
    
    //Gets y Sets
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Tabla> getTablas() {
         return tablas;
    }

    public void setTabla(Tabla ta) {
        tablas.add(ta);
    }

    public void setTablas(List<Tabla> tablas) {
        this.tablas = tablas;
    }
    
}
