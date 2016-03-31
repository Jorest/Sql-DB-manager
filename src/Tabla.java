
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
public class Tabla {
    private String nombre; 
    private ArrayList <Columna> columnas; 
    private ArrayList primaryk; 
    private Map foreignk; 
    private String check; 
    

    public Tabla(String nombre) {
        this.nombre = nombre;
        columnas= new ArrayList();
    }

    public Tabla() {
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Columna> getColumnas() {
        return columnas;
    }

    public void setColumnas(ArrayList<Columna> columnas) {
        this.columnas = columnas;
    }

    public void setColumna(Columna col) {
        columnas.add(col);
    }
    
    
    
}
