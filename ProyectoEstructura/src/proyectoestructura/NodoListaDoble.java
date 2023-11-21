/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructura;

/**
 *
 * @author deivert.guiltrichs
 */
public class NodoListaDoble {

    private Pila dato;
    private NodoListaDoble anterior;
    private NodoListaDoble siguiente;

    public NodoListaDoble(Pila dato) {
        this.dato = dato;
    }

    public Pila getDato() {
        return dato;
    }

    public void setDato(Pila dato) {
        this.dato = dato;
    }

    public NodoListaDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoListaDoble anterior) {
        this.anterior = anterior;
    }

    public NodoListaDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoListaDoble siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return dato.toString();
    }
}
