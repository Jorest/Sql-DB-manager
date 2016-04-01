
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
    private ArrayList <PrimaryKey> primaryk; 
    private ArrayList <ForeignKey> foreignk; 
    private ArrayList <Check> check; 
    

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

    public ArrayList<PrimaryKey> getPrimaryk() {
        return primaryk;
    }

    public void setPrimaryk(ArrayList<PrimaryKey> primaryk) {
        this.primaryk = primaryk;
    }

    public ArrayList<ForeignKey> getForeignk() {
        return foreignk;
    }

    public void setForeignk(ArrayList<ForeignKey> foreignk) {
        this.foreignk = foreignk;
    }

    public ArrayList<Check> getCheck() {
        return check;
    }

    public void setCheck(ArrayList<Check> check) {
        this.check = check;
    }
    
}
