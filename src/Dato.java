import java.util.ArrayList;

public class Dato {

    private int integer ;
    private String character ;
    private float floating ;
    private String date ;
    private String tipo ;
    private ArrayList<Integer> filas = new  ArrayList<Integer>() ;
    private ArrayList columna ;

    public Dato() {
    }

	public ArrayList getColumna() {
		return columna;
	}
	public void setColumna(ArrayList columna) {
		this.columna = columna;
	}
	public ArrayList<Integer> getFilas() {
		return filas;
	}
	public void setFilas(ArrayList<Integer> filas) {
		this.filas = filas;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public int getInteger() {
		return integer;
	}
	public void setInteger(int integer) {
		this.integer = integer;
	}
	public String getCharacter() {
		return character;
	}
	public void setCharacter(String character) {
		this.character = character;
	}
	public float getFloating() {
		return floating;
	}
	public void setFloating(float floating) {
		this.floating = floating;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
    public Object getValor(){
        if(tipo.equals("int")){
            return integer;
        }
        
        if(tipo.equals("char")){
            return character;
        }
        
        if(tipo.equals("float")){
            return floating;
        }
        
        if(tipo.equals("date")){
            return date;
        }
        return null; 
    }	
}
