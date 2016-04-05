
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Luis
 */
public class Columna {
    private String nombre;
    private String tipo; 
    private ArrayList valores;

    public Columna(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        valores= new ArrayList();
    }


    public Columna() {
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList getValores() {
        return valores;
    }

   
    public void setValor( Object valor) {
        valores.add(valor);
    }

    public int getTamaño() {
        return valores.size();
    }
    
    
    
    
}
