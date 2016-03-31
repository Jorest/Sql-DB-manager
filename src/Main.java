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
}
