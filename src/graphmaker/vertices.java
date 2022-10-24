/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphmaker;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author ASUS TUF GAMING F15
 */
public class vertices {

    private String name;
    ArrayList<aristas> conexiones = new ArrayList<aristas>();
    boolean vst; //visitado
    ArrayList<vertices> ady = new ArrayList<vertices>(); //adyaciente
    private int id;
    int d = 40;
    int x, y;

    public vertices(String name, int id, int x, int y) {
        this.name = name;
        this.id = id;
        setX(x);
        setY(y);
    }

    public String getName() {
        return name;
    }

    public void pintar(Graphics g) {
        //g.drawOval(getX(), getY(), d, d);
        g.setColor(Color.black);
        g.fillOval(getX(), getY(), d, d);
        g.setColor(Color.WHITE);
        g.setFont(new java.awt.Font("Segoe UI Black", 0, 12));
        g.drawString(name, getX()+5, getY()+20);
    }

    public int getId() {
        return id;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public int getX() {
        return this.x;
    }

}
