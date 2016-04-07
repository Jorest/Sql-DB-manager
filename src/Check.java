
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import org.antlr.runtime.tree.ParseTree;

public class Check {
    private String nombre;  //nombre de la tabla
    private String exp = null;
    private ArrayList<org.antlr.v4.runtime.tree.ParseTree> trees ;

    public Check() {
        trees=new ArrayList();
      
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public ArrayList<org.antlr.v4.runtime.tree.ParseTree> getTrees() {
		return trees;
	}


	public void setTrees(ArrayList<org.antlr.v4.runtime.tree.ParseTree> trees) {
		this.trees = trees;
	}


	public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }
    
    
    public void addTree(org.antlr.v4.runtime.tree.ParseTree parseTree) {
        this.trees.add(parseTree);
    }
    
}
