package ProyectoFinal_G4;

public class Cola { 
    
    //Atributos
    private Nodo frente;
    private Nodo ultimo;

    //Constructor
    public Cola() {
        this.frente = null;
        this.ultimo = null;
    }//Fin del constructor
    
    //Encapsuladores
    public Nodo getFrente() {
        return frente;
    }

    public void setFrente(Nodo frente) {
        this.frente = frente;
    }

    public Nodo getUltimo() {
        return ultimo;
    }

    public void setUltimo(Nodo ultimo) {
        this.ultimo = ultimo;
    }
    //Fin de los encapsuladores
    

    //Método boolean para comprobar si la cola está vacía
    public boolean estaVacia() {
        return frente == null;
    }//Fin del método
    
    /*
    //Método para encolar una carta al final de la cola
    public void encolar(String carta) {
        Nodo nuevoNodo = new Nodo(carta); //Representa la carta que se va a encolar
        
        if (estaVacia()) { //Verificar si la cola está vacía
            frente = nuevoNodo; //Si la cola está vacía, el nuevo nodo se convierte en el frente de la cola
            ultimo = nuevoNodo; //Si la cola está vacía, el nuevo nodo se convierte en el fin de la cola
        } else { //Si la cola no está vacía
            ultimo.setSiguiente(nuevoNodo); //El nuevo nodo se coloca al final de la cola
            ultimo = nuevoNodo; //El nuevo nodo se convierte en el nuevo fin de la cola
        }//Fin del if/else
    }//Fin del método

    //Método para desencolar una carta del frente de la cola
    public String desencolar() {
        if (estaVacia()) { //Verificar si la cola está vacía
            return null; //Retorna vacío, si la cola está vacía al no haber cartas para desencolar
        }//Fin del if
        String carta = frente.getCarta(); //Si la cola no está vacía, se obtiene la carta en el frente de la cola
        frente = frente.getSiguiente(); //Se retira la carta en el frente de la cola, dejando la siguiente carta como nueva frente
        return carta; //Se retorna la carta que se ha retirado del frente de la cola
    }//Fin del método
    */
    
    public void atender(){
        
    }
    
    public void imprimir(){
        
    }
    
    
}//Fin de la clase
