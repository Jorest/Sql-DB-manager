
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
    private int charCant ; 

    public int getCharCant() {
		return charCant;
	}

    public Columna(String nombre) {
        this.nombre = nombre;
    }
    
    


	public void setCharCant(int charCant) {
		this.charCant = charCant;
	}


	public Columna(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        valores = new ArrayList();
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
     public boolean setValor( Object valor, ArrayList <String> datos) {
         if(datos.contains(nombre)==false){
             System.out.println("no es");
             valores.add(valor);
             return true;
         }else{
             System.out.println("Si es");
             if(valor.getClass().getSimpleName().equals("Integer")){
                 System.out.println("neeeelll");
                 int coso=(int)valor;
                 double val= (double) coso;
                 System.out.println(val);
                 if(valores.contains(val)==false){
                    valores.add(valor);
                    return true;
                }else{
                     System.out.println("si ta1");
                    return false;
                }
             }
                if(valores.contains(valor)==false){
                    valores.add(valor);
                    return true;
                }else{
                    return false;
                }
         
         }
        
    }
     public boolean verificar(ArrayList lista, Object valor){
         System.out.println("skskskksks");
         for(int i=0; i<lista.size();i++){
             if(lista.getClass().getSimpleName().equals("Float")){
                 System.out.println("qasdajdk");
                 float val=(float)lista.get(i);
                 float val1=(float)valor;
                 if(val==val1){
                     return true;
                 }
                 
             }
         }
         
         return false;
     }
//Cambio en columnas
    public int getTamanio() {
        return valores.size();
    }

    public void setValores(ArrayList valores) {
        this.valores = valores;
    }
    
    
    
    
}
