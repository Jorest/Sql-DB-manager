/*
 * Universidad del Valle Guatemala
 * CC3040 Bases de datos
 * Proyecto 1: DBMS
 * Jorge Estuardo Garcia 13175
 * Luis Humberto Duarte 13003
 * Kevin Eduardo Rivera 13389
 */

import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Clase encargada de trabajar con las llaves foraneas en una base de datos
 * @author Luis
 * @version 06/06/2016/A
 */
 
public class ForeignKey {
    //Campos de la clase
    private String nombre; 
    private ArrayList <String>  id1;
    private String tablaref;
    private ArrayList <String>  id2; 

    public ForeignKey() {
    }

    public ForeignKey(String nombre, ArrayList<String> id1, ArrayList<String> id2) {
        this.nombre = nombre;
        this.id1 = id1;
        this.id2 = id2;
    }

    public ForeignKey(String nombre, ArrayList<String> id1, String tablaref, ArrayList<String> id2) {
        this.nombre = nombre;
        this.id1 = id1;
        this.tablaref = tablaref;
        this.id2 = id2;
    }

    public String getTablaref() {
        return tablaref;
    }

    public void setTablaref(String tablaref) {
        this.tablaref = tablaref;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getId1() {
        return id1;
    }

    public void setId1(ArrayList<String> id1) {
        this.id1 = id1;
    }

    public ArrayList<String> getId2() {
        return id2;
    }

    public void setId2(ArrayList<String> id2) {
        this.id2 = id2;
    }

}
