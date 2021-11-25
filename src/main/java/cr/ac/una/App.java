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
package cr.ac.una;

import java.util.List;

import cr.ac.una.modelo.Grafo;
import cr.ac.una.modelo.Nodo;

public final class App {

    private static void imprimirRuta(List<Nodo> ruta, boolean esCiclo) {
        System.out.println("Ruta Hamiltoniana:");
        if (ruta.isEmpty()) {
            System.out.println("No hay ruta Hamiltoniana");
            return;
        }
        for (int i = 0; i < ruta.size(); i++) {
            String nodo = ruta.get(i).getId();
            System.out.print(nodo);
            if (i < ruta.size() - 1) {
                System.out.print("->");
            }
        }
        if (esCiclo) {
            System.out.print("->");
            System.out.println(ruta.get(0).getId());
        }
    }

    public static void main(String[] args) {
        // creamos el siguiente grafo
        // "(A)--(B)--(C)"
        // "|   /   \  | "
        // "|  /     \ | "
        // "| /       \| "
        // "(D)-------(E)"
        System.out.println("Creando grafo");
        System.out.println("(A)--(B)--(C)");
        System.out.println("|   /   \\  | ");
        System.out.println("|  /     \\ | ");
        System.out.println("| /       \\| ");
        System.out.println("(D)-------(E)");
        int[][] matrizAdyacencia = { //
                { 0, 1, 0, 1, 0 }, //
                { 1, 0, 1, 1, 1 }, //
                { 0, 1, 0, 0, 1 }, //
                { 1, 1, 0, 0, 1 }, //
                { 0, 1, 1, 1, 0 }, //
        };

        // creamos el grafo
        Grafo grafo = new Grafo();
        // agregamos los nodos
        grafo.agregarNodo("A");
        grafo.agregarNodo("B");
        grafo.agregarNodo("C");
        grafo.agregarNodo("D");
        grafo.agregarNodo("E");
        // agregamos las aristas
        grafo.agregarArista("A", "B", 1);
        grafo.agregarArista("A", "D", 1);
        grafo.agregarArista("B", "C", 1);
        grafo.agregarArista("B", "D", 1);
        grafo.agregarArista("C", "E", 1);
        grafo.agregarArista("D", "E", 1);
        // imprimimos el ciclo hamiltoniano
        List<Nodo> ciclo = grafo.cicloHamiltoniano();
        List<Nodo> camino = grafo.caminoHamiltoniano();
        imprimirRuta(ciclo, true);
        imprimirRuta(camino, false);

    }
}
