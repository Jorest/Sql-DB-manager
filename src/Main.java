
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
     */
    public static void main(String[] args) {
        Controlador c= new Controlador(); 
        c.createDB("prueba");
        c.useDB("prueba");
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
        
        
   }
}
