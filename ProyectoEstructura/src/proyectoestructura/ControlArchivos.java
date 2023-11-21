package proyectoestructura;

import java.io.*;
import javax.swing.JOptionPane;

public class ControlArchivos {

    private static String nombre, destino;
    private static int id;
    private static boolean discapacidad;

    public static boolean camposRequeridosIncompletos() {
        if (id == 0 || nombre.equals("") || destino.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    public static void agregar() {
        try {
            DataOutputStream archivo = new DataOutputStream(new FileOutputStream("Pasajeros.txt", true));
            id = Integer.parseInt(JOptionPane.showInputDialog("Digite su ID:"));
            nombre = JOptionPane.showInputDialog("Digite su nombre:");
            destino = JOptionPane.showInputDialog("Digite su destino:").toUpperCase();
            discapacidad = Boolean.parseBoolean(JOptionPane.showInputDialog("¿Tiene discapacidad? (true/false)"));
            if (camposRequeridosIncompletos()) {
                throw new Exception("Algunos de los campos requeridos no fueron completados");
            } else {
                archivo.writeInt(id);
                archivo.writeUTF(nombre);
                archivo.writeUTF(destino);
                archivo.writeBoolean(discapacidad);

                JOptionPane.showMessageDialog(null, "Datos guardados correctamente!", "Agregar Datos",
                        JOptionPane.INFORMATION_MESSAGE);
                archivo.close();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al agregar los datos: " + e.getMessage(), "Error!",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void modificar() {
        int idBusca;
        String nombre, destino;
        boolean discapacidad;
        idBusca = Integer.parseInt(JOptionPane.showInputDialog("Digite el ID de la persona a modificar: "));
        try {
            DataInputStream archivoLectura = new DataInputStream(new FileInputStream("Pasajeros.txt"));
            DataOutputStream archivoEscritura = new DataOutputStream(new FileOutputStream("temporal.txt"));

            try {
                while (true) {
                    id = archivoLectura.readInt();
                    nombre = archivoLectura.readUTF();
                    destino = archivoLectura.readUTF();
                    discapacidad = archivoLectura.readBoolean();

                    if (idBusca == id) {
                        nombre = JOptionPane.showInputDialog("Digite el nuevo nombre:");
                        destino = JOptionPane.showInputDialog("Digite el nuevo destino:");
                        discapacidad = Boolean
                                .parseBoolean(JOptionPane.showInputDialog("¿Tiene discapacidad? (true/false)"));
                    }
                    archivoEscritura.writeInt(id);
                    archivoEscritura.writeUTF(nombre);
                    archivoEscritura.writeUTF(destino);
                    archivoEscritura.writeBoolean(discapacidad);
                }
            } catch (EOFException e) {
                archivoEscritura.close();
                archivoLectura.close();
                intercambiar();
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al localizar el archivo: " + e.getMessage(), "Error!",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Los archivos tienen errores de lectura/escritura: " + e.getMessage(),
                    "Error!", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void intercambiar() {
        int id;
        String nombre, destino;
        boolean discapacidad;
        try {
            DataInputStream archivoLectura = new DataInputStream(new FileInputStream("temporal.txt"));
            DataOutputStream archivoEscritura = new DataOutputStream(new FileOutputStream("Pasajeros.txt"));

            try {
                while (true) {
                    id = archivoLectura.readInt();
                    nombre = archivoLectura.readUTF();
                    destino = archivoLectura.readUTF();
                    discapacidad = archivoLectura.readBoolean();

                    archivoEscritura.writeInt(id);
                    archivoEscritura.writeUTF(nombre);
                    archivoEscritura.writeUTF(destino);
                    archivoEscritura.writeBoolean(discapacidad);
                }
            } catch (EOFException e) {
                archivoEscritura.close();
                archivoLectura.close();
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al localizar el archivo: " + e.getMessage(), "Error!",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Los archivos tienen errores de lectura/escritura: " + e.getMessage(),
                    "Error!", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void buscar() {
        String nomBusca, nombre, destino;
        boolean discapacidad;
        boolean proximo = true;
        int idBusca = Integer.parseInt(JOptionPane.showInputDialog("Digite el ID a buscar:"));
        try {
            DataInputStream archivoLectura = new DataInputStream(new FileInputStream("Pasajeros.txt"));
            try {
                while (proximo) {
                    id = archivoLectura.readInt();
                    nombre = archivoLectura.readUTF();
                    destino = archivoLectura.readUTF();
                    discapacidad = archivoLectura.readBoolean();

                    if (idBusca == id) {
                        JOptionPane.showMessageDialog(null,
                                "Se encontró a la persona: " + nombre + ", cuyo ID es: " + id + ", su destino es: "
                                + destino + ", y tiene discapacidad: " + discapacidad + ".");
                        proximo = false;
                    }
                }
            } catch (EOFException e) {
                archivoLectura.close();
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al localizar el archivo: " + e.getMessage(), "Error!",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Los archivos tienen errores de lectura/escritura: " + e.getMessage(),
                    "Error!", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void eliminar() {
        int idBusca;
        int id;
        String nombre, destino;
        boolean discapacidad;
        idBusca = Integer.parseInt(JOptionPane.showInputDialog("Digite el ID de la persona a eliminar: "));
        try {
            DataInputStream archivoLectura = new DataInputStream(new FileInputStream("Pasajeros.txt"));
            DataOutputStream archivoEscritura = new DataOutputStream(new FileOutputStream("temporal.txt"));

            try {
                while (true) {
                    id = archivoLectura.readInt();
                    nombre = archivoLectura.readUTF();
                    destino = archivoLectura.readUTF();
                    discapacidad = archivoLectura.readBoolean();

                    if (idBusca != id) {
                        archivoEscritura.writeInt(id);
                        archivoEscritura.writeUTF(nombre);
                        archivoEscritura.writeUTF(destino);
                        archivoEscritura.writeBoolean(discapacidad);
                    }
                }
            } catch (EOFException e) {
                archivoEscritura.close();
                archivoLectura.close();
                intercambiar();
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Error al localizar el archivo: " + e.getMessage(), "Error!",
                    JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Los archivos tienen errores de lectura/escritura: " + e.getMessage(),
                    "Error!", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
       
    

}
