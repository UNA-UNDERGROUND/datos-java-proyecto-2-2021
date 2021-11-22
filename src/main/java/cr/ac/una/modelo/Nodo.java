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

/**
 * clase que representa un nodo de un grafo, la cual se utiliza para el camino y
 * circuito hamiltoniano
 */
public class Nodo {

    public Nodo(String id) {
        this.id = id;
        this.adyacentes = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Nodo> getAdyacentes() {
        return adyacentes;
    }

    public void setAdyacentes(ArrayList<Nodo> adyacentes) {
        this.adyacentes = adyacentes;
    }

    public void addAdyacente(Nodo adyacente) {
        this.adyacentes.add(adyacente);
    }

    private String id;
    private ArrayList<Nodo> adyacentes = new ArrayList<>();
}
