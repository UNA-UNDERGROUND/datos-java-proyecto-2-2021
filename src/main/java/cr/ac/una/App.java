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

public final class App {

    private static void imprimirCiclo(List<String> camino) {
        System.out.println("Ciclo Hamiltoniano:");
        if (camino.isEmpty()) {
            System.out.println("No hay ciclo hamiltoniano");
            return;
        }
        for (String nodo : camino) {
            System.out.print(nodo + "->");
        }
        System.out.println(camino.get(0));
    }

    public static void main(String[] args) {
        // creamos el siguiente grafo
        //   (0)--(1)--(2) 
        //    |   / \   |
        //    |  /   \  |
        //    | /     \ |
        //   (3)-------(4) 
        int[][] matrizAdyacencia = { //
            { 0, 1, 0, 1, 0 }, //
            { 1, 0, 1, 1, 1 }, //
            { 0, 1, 0, 0, 1 }, //
            { 1, 1, 0, 0, 1 }, //
            { 0, 1, 1, 1, 0 }, //
        };

        // creamos el grafo
        Grafo grafo = new Grafo(matrizAdyacencia);
        // imprimimos el ciclo hamiltoniano
        List<String> camino = grafo.cicloHamiltoniano();
        imprimirCiclo(camino);

    }
}
