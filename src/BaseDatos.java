
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luis
 */
public class BaseDatos {
    private String nombre; 

    private List <Tabla> tablas; 

    public BaseDatos(String nombre) {
        this.nombre = nombre;
        tablas=new ArrayList() ;
    }

    public BaseDatos() {
    	
    }
    

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
 
