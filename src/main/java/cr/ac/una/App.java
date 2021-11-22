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

    private static void imprimirRuta(List<String> ruta, boolean esCiclo) {
        System.out.println("Ruta Hamiltoniana:");
        if (ruta.isEmpty()) {
            System.out.println("No hay ruta Hamiltoniana");
            return;
        }
        for (int i = 0; i < ruta.size(); i++) {
            String nodo = ruta.get(i);
            System.out.print(nodo);
            if (i < ruta.size() - 1) {
                System.out.print("->");
            }
        }
        if (esCiclo) {
            System.out.print("->");
            System.out.println(ruta.get(0));
        }
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
        List<String> ciclo = grafo.cicloHamiltoniano();
        List<String> camino = grafo.caminoHamiltoniano();
        imprimirRuta(ciclo, true);
        imprimirRuta(camino, false);

    }
}
