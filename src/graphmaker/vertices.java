/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphmaker;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 *
 * @author ASUS TUF GAMING F15
 */
public class vertices {

    private String name;
    ArrayList<aristas> conexiones = new ArrayList<aristas>();
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
        g.drawOval(getX(), getY(), d, d);
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
