package cr.ac.una.modelo;

public class Arista {

    public Arista() {
    }

    public Arista(int peso, Nodo nodoDestino) {
        this.peso = peso;
        this.nodoDestino = nodoDestino;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public Nodo getNodoDestino() {
        return nodoDestino;
    }

    public void setNodoDestino(Nodo nodoDestino) {
        this.nodoDestino = nodoDestino;
    }

    private double peso = 0;
    private Nodo nodoDestino = null;
}
