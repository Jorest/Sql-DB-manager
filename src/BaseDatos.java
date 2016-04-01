
import java.util.ArrayList;

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
    private ArrayList tablas; 

    public BaseDatos(String nombre) {
        this.nombre = nombre;
        tablas=new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList getTablas() {
        return tablas;
    }

    public void setTabla(Tabla tab) {
        tablas.add(tab);
    }
    
    
    
}
