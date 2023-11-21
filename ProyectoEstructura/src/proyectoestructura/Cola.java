
package proyectoestructura;


public class Cola {
//Atributos
    private NodoCola frente;
    private NodoCola ultimo;

    public Cola() {
    }
    
    
  
//Gets y Sets
    public NodoCola getFrente() {
        return frente;
    }

    public void setFrente(NodoCola frente) {
        this.frente = frente;
    }

    public NodoCola getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodoCola ultimo) {
        this.ultimo = ultimo;
    }

//Metodos de clase    
    public void hacerFila(NodoCola elemento) {
        if (frente == null) // La fila está vacía
        {
            frente = elemento;
            ultimo = elemento;
        } else {
            //12        ->          13
            ultimo.setAtras(elemento);
            ultimo = elemento;

        }
    }

    public NodoCola atender() {
        NodoCola actual = frente;

        if (frente != null) {
            frente = frente.getAtras();
            actual.setAtras(null);
        }

        return actual;
    }

    public String imprimirCola() {
        String respuesta = ""; // En esta respuesta vamos a ir concatenando los nodos, para poder imprimirlos juntos
        NodoCola actual = frente;

        while (actual != null) {
            //Podemos hacer el recorrido
            respuesta += actual.getDato() + " - ";
            actual = actual.getAtras();
        }

        return respuesta;
    }
}
