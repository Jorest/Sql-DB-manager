/*
 * Universidad del Valle Guatemala
 * CC3040 Bases de datos
 * Proyecto 1: DBMS
 * Jorge Estuardo Garcia 13175
 * Luis Humberto Duarte 13003
 * Kevin Eduardo Rivera 13389
 */

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;


/*
 * Clase principal que redirecciona a la interfaz
 * @author Luis
 * version 07/04/2016/A
 */

public class Main {

    /**
     * @param args the command line arguments
     * @throws IOException 
     */
    public static void main(String[] args) throws IOException {

       /* ControladorDB c= new ControladorDB(); 
        c.createDB("prueba");
        c.useDB("prueba");
        */
        
        //Enlace a la interfaz
        Consola ventana=new Consola();
        ventana.setVisible(true);  
        ventana.setResizable(false);
       
     
        
}
}
