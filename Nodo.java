package ProyectoFinal_G4;

public class Nodo {
    
    //Atributos
    private Dato elemento;
    private Nodo atrás;
    private Nodo siguiente;

    //Constructor
    public Nodo(Dato elemento, Nodo atrás, Nodo siguiente) {
        this.elemento = elemento;
        this.atrás = atrás;
        this.siguiente = siguiente;
    }//Fin del constructor
    
    //Encapsuladores
    public Dato getElemento() {
        return elemento;
    }

    public void setElemento(Dato elemento) {
        this.elemento = elemento;
    }

    public Nodo getAtrás() {
        return atrás;
    }

    public void setAtrás(Nodo atrás) {
        this.atrás = atrás;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
    //Fin de los encapsuladores
    
    //Método toString
    @Override
    public String toString() {
        return "Nodo{" + "elemento=" + elemento + ", atr\u00e1s=" + atrás + ", siguiente=" + siguiente + '}';
    }//Fin del método toString
    
}//Fin de la clase