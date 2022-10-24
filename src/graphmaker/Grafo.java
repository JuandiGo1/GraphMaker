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
    int nvertices = 0;
    String Recorrido[][];
    int Distancia[][];
    ArrayList<aristas> ruta = null;

    public Grafo() {
        this.conexiones = new ArrayList<aristas>();
        this.vertices = new ArrayList<vertices>();
    }

    public void aumentar() {
        this.nvertices++;
    }

    public void MatrizDistancias() {
        Distancia = new int[vertices.size()][vertices.size()];
        boolean ady = false;
        int pos = -1;
        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < vertices.size(); j++) {
                ady = false;
                for (int k = 0; k < vertices.get(i).ady.size(); k++) {
                    if (vertices.get(i).ady.get(k).equals(vertices.get(j))) {
                        ady = true;
                        pos = k;
                    }
                }
                if (ady == true) {
                    for (int z = 0; z < conexiones.size(); z++) {
                        if ((conexiones.get(z).inicio.equals(vertices.get(i)) && conexiones.get(z).fin.equals(vertices.get(j))) 
                                || (conexiones.get(z).fin.equals(vertices.get(i)) && conexiones.get(z).inicio.equals(vertices.get(j)))) {
                            Distancia[i][j] = conexiones.get(z).costo;
                            System.out.println(Distancia[i][j]);
                        }
                    }
                } else {
                    Distancia[i][j] = Integer.MAX_VALUE; //infinito, que no es adyaciente. Si llega a dar problema, cambiar por: 9999999
                }
                if (i == j) {
                    Distancia[i][j] = 0; //La diagonal
                }
            }
        }

        Recorrido = new String[vertices.size()][vertices.size()];
        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < vertices.size(); j++) {
                Recorrido[i][j] = vertices.get(j).getName();
            }
        }
    }

    public String FloydWarshall(vertices inicio, vertices fin) {
        int inicioPos = -1; //posición en la matriz 
        int finPos = -1; //posición en la matriz
        for (int k = 0; k < vertices.size(); k++) {
            if (vertices.get(k).equals(inicio)) {
                inicioPos = k;
            }
            if (vertices.get(k).equals(fin)) {
                finPos = k;
            }
            for (int i = 0; i < vertices.size(); i++) {
                for (int j = 0; j < vertices.size(); j++) {
                    int temp = Distancia[i][k] + Distancia[k][j];
                    if (Distancia[i][j] > temp) {
                        Distancia[i][j] = temp;
                        Recorrido[i][j] = Recorrido[i][k];
                    }
                }
            }
        }
        int CostoAsociado = Distancia[inicioPos][finPos]; //Costo asociado a la ruta minima dependiendo de los vertices
        String Ruta = vertices.get(inicioPos).getName();
        boolean finalizado = false;
        while (finalizado == false) {
            if (Recorrido[inicioPos][finPos].equals(inicio.getName()) || Recorrido[inicioPos][finPos].equals(fin.getName())) {
                Ruta = Ruta + "-->" + fin.getName();
                finalizado = true;
            } else {
                Ruta = Ruta + "-->" + Recorrido[inicioPos][finPos];
                String tmp = Recorrido[inicioPos][finPos];
                for (int i = 0; i < vertices.size(); i++) {
                    if (vertices.get(i).getName().equalsIgnoreCase(tmp)) {
                        inicioPos = i;
                    }
                }
            }
        }
        Ruta = Ruta + "----- Costo de la ruta: " + CostoAsociado;
        if (CostoAsociado >= Integer.MAX_VALUE) {
            Ruta = "No existe ruta de " + inicio.getName() + " hasta " + fin.getName();
        }
        return Ruta;
    }

//   public void RutaLista() {
////       System.out.println("Lista de aristas");
////       boolean term = false;
////       while (term == false) {
////           if (Recorrido[inicioPos][finPos].equals(inicio.nb) || Recorrido[inicioPos][finPos].equals(fin.nb)){
////               
////           }
////       }
////       for (int i = 0; i < vertices.size(); i++) {   
////       }
//   }
    public void PrintMatFW() {  //Para ver en consola la matriz resultante
        System.out.println("Matriz de recorrido;");
        for (int i = 0; i < vertices.size(); i++) {
            for (int j = 0; j < vertices.size(); j++) {
                System.out.println(Recorrido[i][j] + " ");
            }
            System.out.println("");
        }
    }

}
