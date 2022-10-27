/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphmaker;

import static graphmaker.Maker.graf;
import static graphmaker.Maker.obl;
import static graphmaker.crear.name;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
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
    public static Point p1, p2, P1, P2, P3, P4;
    int n = 0;
    ArrayList<aristas> temp= new ArrayList<>();
    Image imagen;

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

    public static vertices BuscarVertice(int x, int y) {
        for (vertices vertice : getNodos()) {
            if (vertice.x == x && vertice.y == y) {
                return vertice;
            }
        }
        return null;
    }
    
    public void resetFloyd(){
        for(vertices v: graf.caminoMinimo){
            v.paso=false;
        }
        for(aristas a:obl.temp){
            a.color = Color.BLACK;
        }
        
        graf.caminoMinimo.clear();
        obl.temp.clear();
    }

    private boolean encima(Point p) {

        Rectangle figura = new Rectangle(p.x - 20, p.y - 20, 40, 40);
        for (vertices v : getNodos()) {
            if (new Rectangle(v.getX() - v.d / 2, v.getY() - v.d / 2, v.d, v.d).intersects(figura)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void paint(Graphics g) {
        imagen = new ImageIcon(getClass().getResource("mapa.png")).getImage();
        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
        setOpaque(false);
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
        System.out.println("cp: " + (n));
        if (e.getButton() == 1) {
            if (Maker.vertice.isSelected()) {
                Maker.estado.setText("Clickea el espacio de trabajo para agregar un vértice.");
                if (!encima(e.getPoint())) {
                    x = e.getX() - 20;
                    y = e.getY() - 20;

                    switch (Maker.enumeracion.getSelectedIndex()) {
                        case 0:
                            Maker.graf.aumentar();
                            int n=1;
                            String name=String.valueOf((char) (Maker.graf.nvertices + 64));
                            if(graf.existe(name)){
                               do{
                                   name = String.valueOf((char) (Maker.graf.nvertices + (64+n)));
                                   n++;
                               }while(graf.existe(name));
                               Maker.graf.vertices.add(new vertices(name, Maker.graf.nvertices, x, y));
                               
                            }else{
                                Maker.graf.vertices.add(new vertices(String.valueOf((char) (Maker.graf.nvertices + 64)), Maker.graf.nvertices, x, y));
                            }
                            
                            obl.repaint();
                            break;
                        case 1:
                            Maker.graf.aumentar();
                            String name1 = Integer.toString(Maker.graf.nvertices);
                            int n1=1;
                            if(graf.existe(name1)){
                               do{
                                   name1 = Integer.toString(Maker.graf.nvertices+n1);
                                   n1++;
                               }while(graf.existe(name1));
                               Maker.graf.vertices.add(new vertices(name1, Maker.graf.nvertices, x, y));
                               
                            }else{
                                Maker.graf.vertices.add(new vertices(Integer.toString(Maker.graf.nvertices), Maker.graf.nvertices, x, y));
                            }
                            
                            obl.repaint();
                            break;
                        case 2:
                            crear v1 = new crear(x, y);
                            v1.setVisible(true);
                            Maker.obl.setEnabled(false);
                            break;
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Espacio ocupado por un nodo", "OJITO", JOptionPane.WARNING_MESSAGE);
                }

            } else if (Maker.arista.isSelected()) {
                Maker.estado.setText("Selecciona el vertice inicial y final de la arista.");
                for (vertices n : getNodos()) {
                    if (new Rectangle(n.getX(), n.getY(), n.d + 10, n.d + 10).contains(e.getPoint())) {
                        System.out.println("SI ESTÁ CONTENIDO");
                        //System.out.println(p1.x);
                        if (p1 == null) {
                            p1 = new Point(n.getX(), n.getY());
                            System.out.println("P1 " + p1.x);
                            Maker.estado.setText("Vertice inicial seleccionado");
                            return;
                        } else {
                            System.out.println("PESO P1 " + p1.x);
                            p2 = new Point(n.getX(), n.getY());
                            Maker.estado.setText("Vertice final seleccionado");
                            vertices v1 = BuscarVertice(p1.x, p1.y);
                            vertices v2 = BuscarVertice(p2.x, p2.y);
                            boolean permitir = true;
                            for (aristas a : v1.conexiones) {
                                if (a.inicio == v2 || a.fin == v2) {
                                    permitir = false;
                                }
                            }
                            if (permitir) {
                                Conectar addAris = new Conectar(p1, p2, v1, v2);
                                addAris.setVisible(true);
                            }else{
                                JOptionPane.showMessageDialog(null, "Ya hay una conexión entre los nodos elegidos", "YA EXISTE", JOptionPane.WARNING_MESSAGE);
                            }

                            System.out.println(Maker.graf.conexiones.size());
                            p1 = null;
                            p2 = null;
                            return;
                        }
                    }
                }
            } else if (Maker.floyd.isSelected()) {
                
                Maker.estado.setText("Clickea el vertice inicial y final.");
                for (vertices n : getNodos()) {
                    if (new Rectangle(n.getX(), n.getY(), n.d + 10, n.d + 10).contains(e.getPoint())) {
                        if (P1 == null) {
                            P1 = new Point(n.getX(), n.getY());
                            Maker.estado.setText("Vertice inicial seleccionado");
                            return;
                        } else {
                            P2 = new Point(n.getX(), n.getY());
                            Maker.estado.setText("Vertice final seleccionado");
                            //Maker.graf.MatrizDistancias();
                            vertices v1 = BuscarVertice(P1.x, P1.y);
                            vertices v2 = BuscarVertice(P2.x, P2.y);
                            
                            System.out.println("Vertice inicial: " + v1.getName());
                            System.out.println("Vertice final: " + v2.getName());
                            Maker.graf.MatrizDeCostos();
                            //System.out.println(Maker.graf.FloydWarshall(v1, v2));
                            v1.paso=true;
                            Maker.estado.setText(Maker.graf.FloydWarshall(v1, v2));
                            Maker.graf.printMatrix(Maker.graf.Distancia);

                            for (vertices act : Maker.graf.caminoMinimo) {
                                
                                System.out.println("LIST NODOS CAMINO: "+act.getName());
                                for (aristas a : act.conexiones) {
                                    System.out.println(a.inicio.paso + " : " + a.fin.paso);
                                    if (a.inicio.paso == true && a.fin.paso == true) {
                                        a.color = Color.yellow;
                                        temp.add(a);
                                        System.out.println("AMARILLO");
                                    }
                                }
                            }
                            obl.repaint();

                            graf.caminoMinimo=new ArrayList<>();
                            P1 = null;
                            P2 = null;
                            return;
                        }
                    }
                }
            } else if (Maker.editarV.isSelected()) {
                if (encima(e.getPoint())) {
                    vertices actual = Maker.graf.buscar(e.getX() - 20, e.getY() - 20);
                    editVertice edit = new editVertice(actual);
                    edit.setVisible(true);
                }
                repaint();
            }else if(Maker.eliminarA.isSelected()){
                Maker.estado.setText("Clickea el vertice inicial y final.");
                for (vertices n : getNodos()) {
                    if (new Rectangle(n.getX(), n.getY(), n.d + 10, n.d + 10).contains(e.getPoint())) {
                        if (P3 == null) {
                            P3 = new Point(n.getX(), n.getY());
                            Maker.estado.setText("Vertice inicial seleccionado");
                            return;
                        } else {
                            P4 = new Point(n.getX(), n.getY());
                            Maker.estado.setText("Vertice final seleccionado");
                            //Maker.graf.MatrizDistancias();
                            vertices v1 = BuscarVertice(P3.x, P3.y);
                            vertices v2 = BuscarVertice(P4.x, P4.y);
                            
                            System.out.println("Vertice inicial: " + v1.getName());
                            System.out.println("Vertice final: " + v2.getName());
                            obl.getEnlaces().remove(graf.buscarArist(v1, v2));
                            Maker.estado.setText("Conexión entre "+v1.getName()+ " y "+v2.getName()+" eliminada");
                            obl.repaint();

                            P3 = null;
                            P4 = null;
                            return;
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
