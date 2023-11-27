package ProyectoFinal_G4;

import javax.swing.JOptionPane;

public class MenuPrincipal {
    public static void menu(){
        //Clases instanciadas
        //Clase instancia = new Clase();
        
        while (true) {
            String opcion = JOptionPane.showInputDialog("""
                Seleccione una opción:
                //1. Módulo de configuración
                2. Módulo de administración de los pasajeros
                3. Módulo de visualización de estaciones y vagón
                4. Salir del menú principal""");

            switch (opcion) {
                case "1" -> { //Si selecciona la opción 1, llamará
                    //instancia.método(); //Llama al menú de esa clase
                    break;
                }
                case "2" -> { //Si selecciona la opción 2, llamará
                    //instancia.método(); //Llama al menú de esa clase
                    break;
                }
                case "3" -> { //Si selecciona la opción 3, llamará
                    //instancia.método(); //Llama al menú de esa clase
                    break;
                }
                case "4" -> { //Si selecciona la opción 4, sale del sistema y muestra un mensaje
                    JOptionPane.showMessageDialog(null, "Gracias por utilizar "
                            + "el sistema. ¡Hasta luego!");
                    System.exit(0);
                    }
                default -> { //Si no selecciona ninguna opción y agrega un número inválido, seguirá en el menú
                    JOptionPane.showMessageDialog(null, "Opción "
                            + "no válida");
                    menu();
                    break;
                }
            }//Fin del switch
        }//Fin del while
    }//Fin del menú
    
    //Main para llamar al menú 
    public static void main(String[] args) {
        menu();
    }//Fin del main
            
}//Fin de la clase
