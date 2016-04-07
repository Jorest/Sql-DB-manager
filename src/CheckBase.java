
import java.util.ArrayList;


public class CheckBase {
	
	private String tabla;  //nombre de la tabla
    private String nombre ;
    private String exp = null;
    private ArrayList<String> trees ;
    public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getBase() {
		return Base;
	}


	public void setBase(String base) {
		Base = base;
	}


	private String Base; 
    



    public String getTabla() {
        return tabla;
    }

    public void setTabla(String nombre) {
        this.tabla = nombre;
    }
    
    public ArrayList<String> getTrees() {
		return trees;
	}


	public void setTrees(ArrayList<String> trees) {
		this.trees = trees;
	}


	public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }
    
    
    public void addTree(String parseTree) {
        this.trees.add(parseTree);
    }
    

}
