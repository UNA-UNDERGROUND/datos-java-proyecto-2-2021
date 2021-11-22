/***
 * (c) 2021
 * @author Paula Arias Mora
 * @version 1.0.0 2021-11-20
 * 
 * -----------------------------------------------
 * EIF207 Estructuras de Datos
 * 2do ciclo 2021, grupo 6pm
 * Proyecto 2
 * 
 * 117160835 Arias Mora, Paula
 * 
 * -----------------------------------------------*
 * 
 *
 */
package cr.ac.una.modelo;

import java.util.ArrayList;
import java.util.List;

/**
 * clase que representa un grafo, la cual se utiliza para el camino y circuito
 * hamiltoniano
 */
public class Grafo {
    int v = 0;

    public Grafo(int[][] matrizAdyacencia) {
        this.matrizAdyacencia = matrizAdyacencia;
        this.v = matrizAdyacencia.length;
    }

    // verifica si el grafo
    private boolean puedeSaltar(int nodo, int[][] matrizAdyacencia, int[] visitados, int posicion) {

        // verifica si el nodo es adyacente al nodo previo
        // en otras palabras solo podemos ir a los nodos adyacentes
        if (matrizAdyacencia[visitados[posicion - 1]][nodo] == 0) {
            return false;
        }

        // verifica si el nodo ya fue visitado
        for (int i = 0; i < posicion; i++) {
            if (visitados[i] == nodo) {
                return false;
            }
        }
        return true;
    }

    /**
     * funcion recursiva que resuelve el ciclo hamiltoniano
     * 
     * @param matrizAdj matriz de adyacencia
     * @param visitados lista de nodos visitados
     * @param posicion  nodo actual
     * @return true si se encuentra un ciclo hamiltoniano
     */
    private Boolean cicloHamiltonianoR(int[][] matrizAdj, int[] visitados, int posicion) {
        // caso base, estan todos los nodos visitados
        if (posicion == v) {
            // verifica si hay una arista entre el ultimo nodo visitado y el primero
            return matrizAdj[visitados[v - 1]][visitados[0]] == 1;
        }

        // intentamos visitar cada nodo
        for (int i = 0; i < visitados.length; i++) {
            // verifica si el vertice puede ser agregado al ciclo hamiltoniano
            if (puedeSaltar(i, matrizAdj, visitados, posicion)) {
                // agrega el vertice al ciclo hamiltoniano
                visitados[posicion] = i;
                // verifica si se encuentra un ciclo hamiltoniano
                if (cicloHamiltonianoR(matrizAdj, visitados, posicion + 1)) {
                    return true;
                }
                // si no se encuentra un ciclo hamiltoniano, se elimina el vertice
                visitados[posicion] = -1;
            }
        }

        // si no se puede realizar mas operaciones, se retorna false
        return false;
    }

    public List<String> cicloHamiltoniano() {
        int[] ruta = new int[v];
        for (int i = 0; i < matrizAdyacencia.length; i++) {
            ruta[i] = -1;
        }
        // tenemos que establecer un vertice inicial
        // como es un ciclo, el vertice inicial puede ser cualquiera
        // en este caso, el vertice 0
        ruta[0] = 0;
        if (!cicloHamiltonianoR(matrizAdyacencia, ruta, 1)) {
            return new ArrayList<String>();
        }
        List<String> resultado = new ArrayList<String>();
        for (int i = 0; i < ruta.length; i++) {
            resultado.add(String.valueOf(ruta[i]));
        }
        return resultado;
    }

    private int[][] matrizAdyacencia;
}
