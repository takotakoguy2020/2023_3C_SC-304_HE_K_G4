package proyectoestructura;

public class ListaDoble {

    private NodoListaDoble cabeza;
    private NodoListaDoble ultimo;

    public void insertaD(Pasajero p) {
        //Paso 1, de la presentación
        if (cabeza == null) {
            cabeza = new NodoListaDoble(p);
            ultimo = cabeza;
            cabeza.setAnterior(ultimo);
            cabeza.setSiguiente(ultimo);
            ultimo.setSiguiente(cabeza);
            ultimo.setAnterior(cabeza);
        } else {
            //Paso 2, de la presentación
            if (cabeza.getDato().getId() > p.getId()) {
                NodoListaDoble aux = new NodoListaDoble(p);
                aux.setSiguiente(cabeza);
                cabeza.setAnterior(aux);
                cabeza = aux;
                cabeza.setAnterior(ultimo);
                ultimo.setSiguiente(cabeza);
            } else {
                //Paso 3, de la presentación
                if (p.getId() > ultimo.getDato().getId()) {
                    NodoListaDoble aux = new NodoListaDoble(p);
                    aux.setAnterior(ultimo);
                    ultimo.setSiguiente(aux);
                    ultimo = aux;
                    ultimo.setSiguiente(cabeza);
                    cabeza.setAnterior(ultimo);
                } else {
                    //Paso 4, de la presentación
                    NodoListaDoble aux = cabeza.getSiguiente();
                    while (aux.getDato().getId() < p.getId()) {
                        aux = aux.getSiguiente();
                    }

                    NodoListaDoble temp = new NodoListaDoble(p);
                    temp.setAnterior(aux.getAnterior());
                    temp.setSiguiente(aux); //Acá aux.getAnterior está apuntando (en su siguiente) a aux
                    aux.setAnterior(temp);
                    temp.getAnterior().setSiguiente(temp);
                }
            }
        }
    }

    public boolean existeD(int id) {
        boolean esta = false;
        if (cabeza != null) {
            if (id >= cabeza.getDato().getId() && id <= ultimo.getDato().getId()) {
                NodoListaDoble aux = cabeza;
                while (aux != ultimo && aux.getDato().getId() < id) {
                    aux = aux.getSiguiente();
                    esta = (aux.getDato().getId() == id);
                }
            }
        }
        return esta; // Retorno la variable al final del método
    }

    public void modificaD(Pasajero p) {
        if (cabeza != null) {
            if (p.getId() >= cabeza.getDato().getId() && p.getId() <= ultimo.getDato().getId()) {
                NodoListaDoble aux = cabeza; // Utilizo aux como índice
                while (aux != ultimo && aux.getDato().getId() < p.getId()) {
                    aux = aux.getSiguiente();
                    if (aux.getDato().getId() == p.getId()) {
                        aux.getDato().setNombre(p.getNombre());
                    }
                }
            }
        }
    }

    public void eliminaD(int id) {
        // Si una persona tiene el id, lo elimina
        if (cabeza != null) { // Si hay algo en la lista, buscaré
            // Si está dentro del rango ...
            if (cabeza.getDato().getId() <= id && id <= ultimo.getDato().getId()) {
                if (cabeza.getDato().getId() == id) {
                    cabeza = cabeza.getSiguiente(); // Actualizo cabeza
                    ultimo.setSiguiente(cabeza); // Actualizo el ultimo.next
                } else {
                    NodoListaDoble aux = cabeza; // Utilizo aux como índice
                    // Mientras no se acabe la lista y el elemento
                    // de la lista sea menor que el buscado
                    while (aux.getSiguiente() != cabeza && aux.getSiguiente().getDato().getId() < id) {
                        aux = aux.getSiguiente(); // Avanzo en la lista
                        // Si es el de adelante ... lo borro
                        if (aux.getSiguiente().getDato().getId() == id) {
                            if (aux.getSiguiente() == ultimo) { // Si hay que eliminar el último
                                ultimo = aux; // Actualizo el último
                            }
                            aux.setSiguiente(aux.getSiguiente().getSiguiente()); // Cambio las referencias
                        }
                    }
                }
            }
        }
    }

    public Pasajero extraeD(int id) {
        Pasajero p = null;
        // Si una persona tiene el id, la extrae
        if (cabeza != null) { // Si hay algo en la lista, buscaré
            // Si está dentro del rango ...
            if (cabeza.getDato().getId() <= id && id <= ultimo.getDato().getId()) {
                if (cabeza.getDato().getId() == id) {
                    p = cabeza.getDato();
                    cabeza = cabeza.getSiguiente(); // Actualizo cabeza
                    ultimo.setSiguiente(cabeza); // Actualizo el ultimo.next
                } else {
                    NodoListaDoble aux = cabeza; // Utilizo aux como índice
                    // Mientras no se acabe la lista y el elemento
                    // de la lista sea menor que el buscado
                    while (aux.getSiguiente() != cabeza && aux.getSiguiente().getDato().getId() < id) {
                        aux = aux.getSiguiente(); // Avanzo en la lista
                        // Si es el de adelante ... lo borro
                        if (aux.getSiguiente().getDato().getId() == id) {
                            p = aux.getSiguiente().getDato();
                            if (aux.getSiguiente() == ultimo) { // Si hay que eliminar el último
                                ultimo = aux; // Actualizo el último
                            }
                            aux.setSiguiente(aux.getSiguiente().getSiguiente()); // Cambio las referencias
                        }
                    }
                }
            }
        }
        return p;
    }

    @Override
    public String toString() {
        String respuesta = "Lista doble circular: \n";

        if (cabeza != null) {
            NodoListaDoble aux = cabeza;

            respuesta += aux.toString() + "\n";

            aux = aux.getSiguiente();

            while (aux != cabeza) {
                respuesta += aux.toString() + "\n";
                aux = aux.getSiguiente();
            }
        } else {
            respuesta += "Vacía";
        }

        return respuesta;
    }

    public void agregarPilaALista(Pila pila) {
        if (cabeza == null) {
            // La lista está vacía, crea el primer nodo con la pila
            cabeza = new NodoListaDoble(new Pila());
            ultimo = cabeza;
            cabeza.setAnterior(ultimo);
            cabeza.setSiguiente(ultimo);
            ultimo.setSiguiente(cabeza);
            ultimo.setAnterior(cabeza);
        } else {
            // Verifica si la lista ya tiene 3 pilas
            if (contarPilasEnLista() < 3) {
                NodoListaDoble nuevoNodo = new NodoListaDoble(pila);
                nuevoNodo.setSiguiente(cabeza);
                cabeza.setAnterior(nuevoNodo);
                cabeza = nuevoNodo;
                cabeza.setAnterior(ultimo);
                ultimo.setSiguiente(cabeza);
            } else {
                System.out.println("La lista ya tiene 3 pilas, no se puede agregar más.");
            }
        }

    }

    private int contarPilasEnLista() {
        int contador = 0;
        NodoListaDoble aux = cabeza;
        do {
            if (aux.getDato() instanceof Pila) {
                contador++;
            }
            aux = aux.getSiguiente();
        } while (aux != cabeza);

        return contador;
    }

    public void IniciarTren() {

    }

}
