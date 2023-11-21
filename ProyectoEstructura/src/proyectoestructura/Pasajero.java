
package proyectoestructura;

import java.io.BufferedReader;
import java.io.FileReader;


public class Pasajero {

    private String nombre;
    private int id;
    private String destino;
    private boolean discapacidad;

    public Pasajero(String nombre, int id, String destino, boolean discapacidad) {
        this.nombre = nombre;
        this.id = id;
        this.destino = destino;
        this.discapacidad = discapacidad;
    }
    

    public Pasajero() {
        this.id = 0;
        this.nombre = "";
        this.destino = "";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isDiscapacidad() {
        return discapacidad;
    }

    public void setDiscapacidad(boolean discapacidad) {
        this.discapacidad = discapacidad;
    }



    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }
    
        public static Pasajero[] leerArchivoYCrearObjetos() {
        try (BufferedReader br = new BufferedReader(new FileReader("Pasajeros.txt"))) {
            String linea;
            Pasajero[] pasajeros = new Pasajero[100]; // Establecemos un tamaño arbitrario, puedes ajustarlo según tus necesidades

            int indice = 0; // Utilizaremos un índice para almacenar en el arreglo

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                int id = Integer.parseInt(partes[0]);
                String nombre = partes[1];
                String destino = partes[2];
                boolean discapacidad = Boolean.parseBoolean(partes[3]);

                Pasajero pasajero = new Pasajero(id, nombre, destino, discapacidad);
                pasajeros[indice++] = pasajero; // Almacenamos el pasajero en el arreglo

                // Haz lo que necesites con el objeto creado
                System.out.println("Objeto creado: " + pasajero);
            }
            return pasajeros[];
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
