/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructura;

/**
 *
 * @author deivert.guiltrichs
 */
public class NodoPila {
    private Pasajero elemento;
    private NodoPila siguiente;

    public NodoPila() 
    {
        this.siguiente = null;
    }
    
    public NodoPila getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPila siguiente) {
        this.siguiente = siguiente;
    }

    public Pasajero getElemento() {
        return elemento;
    }

    public void setElemento(Pasajero elemento) {
        this.elemento = elemento;
    }
}
