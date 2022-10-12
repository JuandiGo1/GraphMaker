/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphmaker;

import static graphmaker.crear.name;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author ASUS TUF GAMING F15
 */
public class Lienzo extends javax.swing.JPanel implements MouseListener {

    ArrayList<vertices> Nodos = null;
    ArrayList<aristas> Enlaces = null;
    public static int x = 0;
    public static int y = 0;
    public static Point p1, p2;
    int n=0;

    public Lienzo() {
        this.Nodos = new ArrayList<>();
        this.Enlaces = new ArrayList<>();
        addMouseListener(this);
    }

    public static ArrayList<vertices> getNodos() {
        return Maker.graf.vertices;
    }

    public static ArrayList<aristas> getEnlaces() {
        return Maker.graf.conexiones;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (aristas a : getEnlaces()) {
            a.pintar(g);
        }
        for (vertices v : getNodos()) {
            v.pintar(g);

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        n++;
        System.out.println("cp: "+(n));
        if (e.getButton() == 1) {
            if (Maker.vertice.isSelected()) {
                x = e.getX() - 20;
                y = e.getY() - 20;
                crear v1 = new crear(x, y);
                v1.setVisible(true);
                Maker.obl.setEnabled(false);
            } else if (Maker.arista.isSelected()) {
                for (vertices n : getNodos()) {
                    if (new Rectangle(n.getX() - 20, n.getY() - 20, n.d, n.d).contains(e.getPoint())) {
                        System.out.println("SI ESTÁ CONTENIDO");
                        if (p1 == null) {
                            p1 = new Point(n.getX(), n.getY());
                            System.out.println("P1 " + p1.x);
                        } else {
                            p2 = new Point(n.getX(), n.getY());
                            System.out.println("P2:" + p2.x);
//                            Conectar v2 = new Conectar();
//                            v2.setVisible(true);
                            getEnlaces().add(new aristas(p1.x, p1.y, p2.x, p2.y, 1));
                           // repaint();
                           Maker.linea(p1.x, p1.y, p2.x, p2.y);
                            System.out.println("YA PINTO ESA MONDA");
                            p1 = null;
                            p2 = null;
                        }
                    }
                }
            }

        }

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

}
