/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphmaker;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author ASUS TUF GAMING F15
 */
public class aristas {

    vertices inicio;
    vertices fin;
    int costo;
    int ix, iy, fx, fy; //Coor inicio, coor final

    public aristas(int ix, int iy, int fx, int fy, int costo, vertices in, vertices out) {
        this.inicio = in;
        this.fin = out;
        this.costo = costo;
        this.ix = ix + 20;
        this.iy = iy + 20;
        this.fx = fx + 20;
        this.fy = fy + 20;

    }

    public void pintar(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        BasicStroke grosor1 = new BasicStroke(3);
        g2d.setStroke(grosor1);
        g2d.setColor(Color.black);
        g2d.drawLine(ix, iy, fx, fy);
        g.setColor(Color.blue);
        g.setFont(new java.awt.Font("Segoe UI Black", 0, 15));
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
