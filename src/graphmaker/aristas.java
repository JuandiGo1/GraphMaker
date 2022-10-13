/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphmaker;

import java.awt.Color;
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

    public aristas(int ix, int iy, int fx, int fy, int costo) {
//        this.inicio = inicio;
//        this.fin = fin;
        this.costo = costo;
        this.ix = ix + 20;
        this.iy = iy + 20;
        this.fx = fx + 20;
        this.fy = fy + 20;

    }

    public void pintar(Graphics g) {
        g.setColor(Color.black);
        g.drawLine(ix, iy, fx, fy);
        g.setColor(Color.red);
        g.setFont(new java.awt.Font("Segoe UI Black", 0, 14));
        if (ix > fx && iy > fy) {
            g.drawString("" + costo, (ix - 20) - Math.abs(ix - fx) / 2, (iy - 20) - Math.abs(iy - fy) / 2);
        }
        if (ix < fx && iy < fy) {
            g.drawString("" + costo, (fx - 20) - Math.abs(ix - fx) / 2, (fy - 20) - Math.abs(iy - fy) / 2);
        }
        if (ix > fx && iy < fy) {
            g.drawString(""+costo, (ix-20)-Math.abs(ix-fx)/2, (fy-20)-Math.abs(iy-fy)/2);
        }
        if (ix < fx && iy > fy) {
            g.drawString(""+costo, (fx-20)-Math.abs(ix-fx)/2, (iy-20)-Math.abs(iy-fy)/2);
        }
    }

}
