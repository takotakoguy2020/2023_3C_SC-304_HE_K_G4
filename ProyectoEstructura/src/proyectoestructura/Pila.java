/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoestructura;

import javax.swing.JOptionPane;

/**
 *
 * @author deivert.guiltrichs
 */
public class Pila {

    public Pila p1 = new Pila();
    private NodoPila cima;

    public NodoPila getCima() {
        return cima;
    }

    public void setCima(NodoPila cima) {
        this.cima = cima;
    }

    public Pila() {
        this.cima = null;
    }

    public boolean esVacia() {
        if (cima == null) {
            return true;
        } else {
            return false;
        }
    }

    public void apilar() {
        Pasajero d = new Pasajero();

        d.setNombre(JOptionPane.showInputDialog(null, "Digite el nombre:"));
        NodoPila nuevo = new NodoPila();

        nuevo.setElemento(d);

        if (esVacia()) {
            cima = nuevo;
        } else {
            nuevo.setSiguiente(cima);
            cima = nuevo;
        }
    }

    public void desapilar() {
        if (!esVacia()) {
            cima = cima.getSiguiente();
            JOptionPane.showMessageDialog(null, "El elemento fue extraído");
        } else {
            JOptionPane.showMessageDialog(null, "No se pueden extraer elementos de una pila vacía");
        }
    }

    public String imprimirPila() {
        String respuesta = "";
        if (!esVacia()) {
            //Imprimimos los nodos
            NodoPila temp = cima; // Maria
            while (temp != null) // La segunda vez que entra, va a a encontrar a Javier
            //La tercera vez, temp = null, y se va a salir de while
            {
                respuesta += temp.getElemento().getNombre() + "\n"; // Aquí vamos a imprimir María la primera
                // Aquí vamos a imprimir a Javier la segunda
                temp = temp.getSiguiente(); // Cuando nos movemos a este, vamos a ir a Javier
                //Cuando nos movemos a este, ya no encontramos nada
            }
        } else {
            respuesta = "La pila está vacía";
        }

        return respuesta;
    }

    public boolean encuentra(int x) {
        boolean respuesta = false;

        if (!p1.esVacia()) {
            //Recorremos la pila

            NodoPila aux = p1.getCima();

            //Una vez que tenemos la cima, comenzamos a recorrer la pila, para buscar el elemento
            while (aux != null) // mientras tanto, no se cumpla una condición, entonces vamos a aplicar un proceso
            {
                if (x == Integer.parseInt(aux.getElemento().getNombre())) {
                    respuesta = true;
                    break;
                } else {
                    aux = aux.getSiguiente(); //Si aux es nuestro pivote, tenemos que sobreescribir esta variable
                    // cada vez que nos movemos.
                }
            }
        } else {
            respuesta = false; // si la pila está vacía, se sale, porque no vamos a encontrar el valor
        }

        return respuesta;
    }

    public void extrae(int x) {
        if (!p1.esVacia()) {
            NodoPila actual = p1.getCima(); // Este nodo auxiliar nos va a servir para recorrer la pila
            NodoPila anterior = null;

            //Empezamos a recorrer la pila 
            while (actual != null) {
                if (x == Integer.parseInt(actual.getElemento().getNombre())) {
                    if (anterior != null) {
                        //Actualizamos las conexiones entre los nodos
                        anterior.setSiguiente(actual.getSiguiente());
                        actual.setSiguiente(null);
                        actual = null;
                    } else {
                        //El elemento está en la cima, porque el anterior es null
                        p1.setCima(actual.getSiguiente());
                        actual.setSiguiente(null);
                        actual = null;
                    }
                    System.out.println("El elemento fue extraído");
                    break;
                } else {
                    anterior = actual;
                    actual = actual.getSiguiente();
                }
            }
        } else {
            //La pila está vacía
            System.out.println("No se puede extraer el elemento, porque la Pila está vacía");
        }
    }

}
