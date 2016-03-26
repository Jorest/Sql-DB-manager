
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luis
 */
public class Tabla {
    private String nombre; 
    private ArrayList columnas; 

    public Tabla(String nombre) {
        this.nombre = nombre;
        columnas= new ArrayList();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList getColumnas() {
        return columnas;
    }

    public void setColumna(Columna col) {
        columnas.add(col);
    }
    
    
    
}
