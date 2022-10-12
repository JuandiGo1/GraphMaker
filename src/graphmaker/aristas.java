/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphmaker;

import java.awt.Graphics;

/**
 *
 * @author ASUS TUF GAMING F15
 */
public class aristas {
    vertices inicio;
    vertices fin;
    int costo;
    int ix, iy, fx, fy; //Coor inicio, coor final

    public aristas(int ix,int iy,int fx,int fy, int costo) {
//        this.inicio = inicio;
//        this.fin = fin;
        this.costo = costo;
        this.ix = ix;
        this.iy = iy;
        this.fx = fx;
        this.fy = fy;
        
    }
    
    public void pintar(Graphics g){
        g.drawLine(ix+20, iy+20, fx+20, fy+20);
    }
    
    
    
}
