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
<<<<<<< HEAD

=======
>>>>>>> origin/master
        Controlador c= new Controlador(); 
        c.createDB("prueba");
        c.useDB("prueba");
        
        System.out.println(" hola");
        Consola ventana=new Consola();
        ventana.setVisible(true);       
       
        /*****************************************Leer el texto****************************************/

        String text = readFileAsString("C:\\Users\\jores\\workspace\\PruebaAnt3\\src\\editor.txt");
        //awevos que hay que cambiar esa direccion 
        ANTLRInputStream input = new ANTLRInputStream(text);

        // Create an Lexer that receives the char stream
        SqlLexer lexer = new SqlLexer(input);
        lexer.removeErrorListeners();
        // Create a token stream from the lexer
        CommonTokenStream tokens = new CommonTokenStream(lexer);

    // Create a parser that receives the token stream
        SqlParser parser = new SqlParser(tokens);


     
    }

    
    /*********************************************FUNCIONES UTULES  ************************************************/

		
	private static String readFileAsString(String filePath) throws java.io.IOException{
	    byte[] buffer = new byte[(int) new File(filePath).length()];
	    BufferedInputStream f = null;
	    try {
	        f = new BufferedInputStream(new FileInputStream(filePath));
	        f.read(buffer);
	        if (f != null) try { f.close(); } catch (IOException ignored) { }
	    } catch (IOException ignored) { System.out.println("File not found or invalid path.");}
	    return new String(buffer);
	}
       /** c.alterDB("prueba","pute");
        c.createDB("pru");
        c.dropTable("pute");

        
        /***System.out.println(" hola");
        GsonBuilder builder = new GsonBuilder();

        builder.serializeNulls();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BaseDatos b1=new BaseDatos();
        b1.setNombre("Prueba");
        Tabla t=new Tabla("hola");
        Tabla t1=new Tabla("hol11a");
        b1.setTabla(t);
        b1.setTabla(t1);
        String json = gson.toJson(b1);
        System.out.println(json);
        
        Gson gson1 = new Gson();

        BaseDatos aa = gson1.fromJson(json, BaseDatos.class);
        System.out.println(aa.getNombre());
        List<Tabla> ab=aa.getTablas();
        Tabla c= (Tabla)ab.get(0);
        System.out.println(c.getNombre());
       Consola ventana=new Consola();
        ventana.setVisible(true);
       /** BaseDatos b1=new BaseDatos("Prueba");
        Tabla t=new Tabla("hola");
        Tabla t1=new Tabla("hol11a");
        b1.setTabla(t);
        b1.setTabla(t1);
        System.out.println(b1.getTablas().size());
        JSONObject j= JSONObject.fromObject(b1);
        System.out.println(j);**/
       
       /*** JSONObject a=JSONObject.fromObject("{\"nombre\":\"Prueba\",\"tablas\":[{\"columnas\":[],\"nombre\":\"hola\"},{\"columnas\":[],\"nombre\":\"hol11a\"}]}");
        BaseDatos aa=(BaseDatos)JSONObject.toBean(a, BaseDatos.class);
        
        System.out.println(aa.getNombre());
        List<Tabla> ab=aa.getTablas();
        Tabla c= (Tabla)ab.get(0);
        System.out.println(c.getNombre());**/
        
        
<<<<<<< HEAD
   }
=======
   }
>>>>>>> origin/master
