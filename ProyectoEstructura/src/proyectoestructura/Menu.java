package proyectoestructura;

import javax.swing.JOptionPane;

public class Menu {

    private int opcion = 0;

    public void mostrarMenu() {
        while (opcion != 4) {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, "Menú Principal:\n"
                    + "1 - Cargar\n"
                    + "2 - Agregar\n"
                    + "3 - Iniciar Tren\n"
                    + "4 - Salir\n"
                    + "Digite una opción para continuar: "
            ));
            switch (opcion) {
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}//fin de clase menu

