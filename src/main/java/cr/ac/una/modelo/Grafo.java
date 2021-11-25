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
    public Grafo() {

    }

    /**
     * nos indica si un nodo es valido como siguiente salto
     * <ul>
     * <li>no es el mismo nodo, esto se cumple ya que se marca como visitado antes
     * de llamarse esta funcion</li>
     * <li>no es un nodo de la lista de visitados</li>
     * <li>tiene una arista con el nodo actual</li>
     * </ul>
     * 
     * @param nodo             nodo actual
     * @param matrizAdyacencia matriz de adyacencia
     * @param visitados        lista de visitados
     * @param posicion         posicion de la lista de visitados
     * @return true si se puede visitar, false en caso contrario
     */
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
     * @param esCiclo   si es ciclo o no
     * @return true si se encuentra un ciclo hamiltoniano
     */
    private Boolean HamiltonianoR(int[][] matrizAdj, int[] visitados, int posicion, boolean esCiclo) {
        int v = matrizAdj.length;
        // caso base, estan todos los nodos visitados
        if (posicion == v) {
            // verifica si hay una arista entre el ultimo nodo visitado y el primero
            return matrizAdj[visitados[v - 1]][visitados[0]] == (esCiclo ? 1 : 0);
        }

        // intentamos visitar cada nodo
        for (int i = 0; i < visitados.length; i++) {
            // verifica si el vertice puede ser agregado al ciclo hamiltoniano
            if (puedeSaltar(i, matrizAdj, visitados, posicion)) {
                // agrega el vertice al ciclo hamiltoniano
                visitados[posicion] = i;
                // verifica si se encuentra un ciclo hamiltoniano
                if (HamiltonianoR(matrizAdj, visitados, posicion + 1, esCiclo)) {
                    return true;
                }
                // si no se encuentra un ciclo hamiltoniano, se elimina el vertice
                visitados[posicion] = -1;
            }
        }

        // si no se puede realizar mas operaciones, se retorna false
        return false;
    }

    /**
     * funcion que verifica si el grafo tiene un ciclo hamiltoniano
     * 
     * @return la lista de nodos que conforman el ciclo hamiltoniano
     */
    public List<Nodo> cicloHamiltoniano() {
        return resolverHamiltoniano(true);
    }

    /**
     * funcion que verifica si el grafo tiene un circuito hamiltoniano
     * 
     * @return la lista de nodos que conforman el camino hamiltoniano
     */
    public List<Nodo> caminoHamiltoniano() {
        return resolverHamiltoniano(false);
    }

    /**
     * funcion que resuelve el circuito/ciclo hamiltoniano
     * 
     * @param esCiclo si es ciclo o no
     * @return lista de nodos visitados
     */
    public List<Nodo> resolverHamiltoniano(boolean esCiclo) {
        int[][] matrizAdyacencia = generarMatrizAdyacencia();
        int v = matrizAdyacencia.length;
        int[] ruta = new int[v];
        for (int i = 0; i < matrizAdyacencia.length; i++) {
            ruta[i] = -1;
        }
        // tenemos que establecer un vertice inicial
        // como es un ciclo, el vertice inicial puede ser cualquiera
        // en este caso, el vertice 0
        ruta[0] = 0;
        if (!HamiltonianoR(matrizAdyacencia, ruta, 1, esCiclo)) {
            return new ArrayList<Nodo>();
        }
        List<Nodo> resultado = new ArrayList<>();
        for (int i = 0; i < ruta.length; i++) {
            resultado.add(nodos.get(ruta[i]));
        }
        return resultado;
    }

    private int[][] generarMatrizAdyacencia() {
        // este metodo se puede optimizar
        // sin embargo, para el ejemplo, se deja asi
        int v = nodos.size();
        int[][] matrizAdyacencia = new int[v][v];
        for (int i = 0; i < matrizAdyacencia.length; i++) {
            matrizAdyacencia[i][i] = 0;
            Nodo nodo = nodos.get(i);
            for (int j = 0; j < matrizAdyacencia.length; j++) {
                // revisamos si el nodo j es adyacente al nodo i
                if (nodo.esAdyacente(nodos.get(j))) {
                    matrizAdyacencia[i][j] = 1;
                }
            }
        }

        return matrizAdyacencia;
    }

    public void agregarNodo(String nombre) {
        // primero verificamos que el nodo no exista
        if (buscarNodo(nombre) != null) {
            return;
        }
        nodos.add(new Nodo(nombre));
    }

    public Nodo buscarNodo(String nombre) {
        for (Nodo nodo : nodos) {
            if (nodo.getId().equals(nombre)) {
                return nodo;
            }
        }
        return null;
    }

    public void agregarArista(String nodo1, String nodo2, int peso) {
        // primero verificamos que los nodos existan
        Nodo n1 = buscarNodo(nodo1);
        Nodo n2 = buscarNodo(nodo2);
        if (n1 == null || n2 == null) {
            return;
        }
        // verificamos que la arista no exista
        if (n1.esAdyacente(n2)) {
            return;
        }
        n1.agregarAdyacente(n2, peso);
        n2.agregarAdyacente(n1, peso);
    }

    List<Nodo> nodos = new ArrayList<>();

    // private int[][] matrizAdyacencia;
}
