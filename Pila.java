package ProyectoFinal_G4;

public class Pila {
    
    //Atributo
    private Nodo cima;

    //Constructor
    public Pila() {
        this.cima = null;
    }//Fin del constructor
    
    //Encapsuladores
    public Nodo getCima() {
        return cima;
    }

    public void setCima(Nodo cima) {
        this.cima = cima;
    }
    //Fin de encapsuladores

    //Método boolean para comprobar si la pila está vacía
    public boolean estaVacia() {
        return cima == null;
    }//Fin del método
    
    /*
    //Método para apilar
    public void apilar(String carta) {
        Nodo nuevoNodo = new Nodo(carta); //Representa la carta que se va a apilar 
        
        if (estaVacia()) { //Verificar si la pila del jugador está vacía
            cima = nuevoNodo; //Si la pila está vacía, el nuevo nodo se convierte en la cima de la pila
        } else { //Si la pila no está vacía, entonces significa que ya hay cartas apiladas
            nuevoNodo.setSiguiente(cima); //El nuevo nodo se coloca encima del nodo que estaba en la cima
            cima = nuevoNodo; //El nuevo nodo se convierte en la nueva cima de la pila
        }//Fin del if/else
    }//Fin del método

    //Método para desapilar una carta de la cima de la pila
    public String desapilar() {
        if (estaVacia()) { //Verificar si la pila del jugador está vacía
            return null; //Retorna vacío, si la pila está vacía al no haber cartas para desapilar
        }//Fin del if
        String carta = cima.getCarta(); //Si la pila no está vacía, se obtiene la carta en la cima de la pila actual
        cima = cima.getSiguiente(); //Se retira la carta superior de la pila, dejando la siguiente carta como nueva cima
        return carta; //Se retorna la carta que se ha retirado de la cima
    }//Fin del método
    */
    
    public void imprimir(){
        
    }
    
}//Fin de la clase