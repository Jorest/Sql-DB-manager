

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


/*Universidad del Valle de Guatemala
 * 
 * 
 * @author Luis
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
        //System.out.println(" hola");
        Consola ventana=new Consola();
        ventana.setVisible(true);  
        ventana.setResizable(false);
       
     
        
}
}
