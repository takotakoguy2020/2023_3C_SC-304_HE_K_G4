
package proyectoestructura;


public class NodoCola {
    private Pasajero dato;
    private NodoCola atras;

    public NodoCola(Pasajero dato) {
        this.dato = dato;
    }
    
    public Pasajero getDato() {
        return dato;
    }

    public void setDato(Pasajero dato) {
        this.dato = dato;
    }

    public NodoCola getAtras() {
        return atras;
    }

    public void setAtras(NodoCola atras) {
        this.atras = atras;
    }



    
    
}
