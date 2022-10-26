/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package graphmaker;

import static graphmaker.Maker.obl;
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
    ArrayList<vertices> caminoMinimo = new ArrayList<vertices>();

    public Grafo() {
        this.conexiones = new ArrayList<aristas>();
        this.vertices = new ArrayList<vertices>();
    }

    //Contar cuantos vertices hay
    public void aumentar() {
        this.nvertices++;
    }
    
    // ***** Eliminar vertice *****
    public void delVertice(vertices v) {
       for(vertices act: this.vertices){
           if(act==v){
               for(aristas a: act.conexiones){
                   act.conexiones.remove(a);
               }
               this.vertices.remove(act);
           }
       }
       Maker.estado.setText("Nodo "+v.getName()+" eliminado");
       obl.repaint();
    }
    
        // ***** Eliminar vertice *****
    public void delArista(aristas a) {
       for(aristas act: this.conexiones){
           if(act==a){
               a.inicio.conexiones.remove(act);
               a.fin.conexiones.remove(act);
               this.conexiones.remove(act);
           }
       }
       Maker.estado.setText("Arista "+a.inicio.getName()+", "+a.fin.getName()+" eliminada");
       obl.repaint();
       
    }
    
    
    public void MatrizDeCostos(){
        Distancia =  new int[vertices.size()][vertices.size()];
        boolean ady = false;
        int pos = -1;
        int INF = 999 ;
        for (int i = 0; i < vertices.size(); i++) {
            System.out.println(vertices.size());
            for (int j = 0; j < vertices.size(); j++) {
                ady = false;

                for (int k = 0; k < vertices.get(i).ady.size(); k++) {
                    if (vertices.get(i).ady.get(k).equals(vertices.get(j))){
                        ady = true;
                        pos = k;
                    }
                    
                }
                if (ady == true) {
                    for (int z = 0; z < conexiones.size();z++) {
                        if ((conexiones.get(z).inicio.equals(vertices.get(i)) && conexiones.get(z).fin.equals(vertices.get(j))) 
                                || (conexiones.get(z).fin.equals(vertices.get(i)) && conexiones.get(z).inicio.equals(vertices.get(j)))){
                            Distancia[i][j] = conexiones.get(z).costo;
                        } 
                    }
                } else {
                    Distancia[i][j] = INF;
                }
                if (i==j){
                    Distancia[i][j] = 0;
                }
            }
            
        }
        Recorrido = new String[vertices.size()][vertices.size()];
        for (int i = 0; i < vertices.size(); i++) {
            for(int j = 0; j < vertices.size(); j++){
                Recorrido[i][j] = vertices.get(j).getName();
            }
        }
          //Ayuda para ver que todo ande bien
        System.out.println("----------");
        System.out.println("Tamaño de vertices.size(): "+ vertices.size());
        System.out.println("# de conexiones: " + conexiones.size());
        System.out.println("Distancia entre 1 y 1 vertice: "+ Distancia[1][1]);
        System.out.println("Distancia entre 0 y 1 vertice: "+ Distancia[0][1]);
        System.out.println("Distancia entre 0 y 2 vertice: "+ Distancia[0][2]);
        
    }
    
    public String FloydWarshall(vertices inicio, vertices fin){
        int inPos = -1;
        int finPos = -1;
        int INF = 999 ;
        for (int k = 0; k < vertices.size(); k++) {
            if (vertices.get(k).equals(inicio)){
                inPos = k;
            }
            if (vertices.get(k).equals(fin)){
                finPos = k;
            }
            for (int i = 0; i < vertices.size(); i++) {
                for (int j = 0; j < vertices.size(); j++) {
                    if (Distancia[i][j] > Distancia[i][k] + Distancia[k][j]) {
                        Distancia[i][j] = Distancia[i][k] + Distancia[k][j];
                        Recorrido[i][j] = Recorrido[i][k];
                    }
                    
                }
                
            }
        }
        int CostoAsociado = Distancia[inPos][finPos];
        String Ruta = vertices.get(inPos).getName();
        boolean finalizado = false;
        while (finalizado == false) {
            if (Recorrido[inPos][finPos].equals(inicio.getName()) || 
                    Recorrido[inPos][finPos].equals(fin.getName()) ) {
                Ruta = Ruta + "-->"+ fin.getName();
                fin.paso=true;
                caminoMinimo.add(fin);
                finalizado = true;
            } else {
                Ruta = Ruta + "-->" + Recorrido[inPos][finPos];
                String tmp = Recorrido[inPos][finPos];
                for (int i = 0; i < vertices.size(); i++) {
                    if (vertices.get(i).getName().equalsIgnoreCase(tmp)) {
                        inPos = i;
                    }
                    
                }
            }
        }
        Ruta = Ruta + " ------ Costo de la ruta: " + CostoAsociado;
        if (CostoAsociado >= INF){
            Ruta = "No existe ruta de " + inicio.getName() + " hasta " + fin.getName();
        }
        return Ruta;
    }
    
    
    
    public void printMatrix(int[][] Matrix) {
		System.out.print("\n\t");
		for (int j = 0; j < vertices.size(); j++) {
			System.out.print(vertices.get(j).getName() + "\t");
		}
		System.out.println();
		for (int j = 0; j < (nvertices*9-4); j++) {
			System.out.print("-");
		}
		System.out.println();
		for (int i = 0; i < vertices.size(); i++) {
			System.out.print(vertices.get(i).getName() + " |\t");
			for (int j = 0; j < vertices.size(); j++) {
				System.out.print(Matrix[i][j]);
				System.out.print("\t");
			}
			System.out.println("\n");
		}
		System.out.println("\n");
	}

 
}
