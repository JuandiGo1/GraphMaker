/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphmaker;

import java.util.ArrayList;

/**
 *
 * @author ASUS TUF GAMING F15
 */
public class Grafo {

    ArrayList<vertices> vertices = null;
    ArrayList<aristas> conexiones = null;
    int nvertices =0;

    public Grafo() {
        this.conexiones= new ArrayList<aristas>();
        this.vertices = new ArrayList<vertices>();
    }
    
    public void aumentar(){
        this.nvertices++;
    }
    
    
}
