package ProyectoFinal_G4;

public class Estacion {
    //Atributos
    public String precio;
    public int numEstacion;
    
    //Constructores
    public Estacion() {
    }

    public Estacion(String precio, int numEstacion) {
        this.precio = precio;
        this.numEstacion = numEstacion;
    }
    //Fin de los constructores
    
    //Encapsuladores
     public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public int getNumEstacion() {
        return numEstacion;
    }

    public void setNumEstacion(int numEstacion) {
        this.numEstacion = numEstacion;
    }
    //Fin de los encapsuladores
    
    //Método toString
    @Override
    public String toString() {
        return """
               Estacion: 
               - Precio = """ + precio + "\n - Número de estacion = " + numEstacion;
    }
    
    //Método thread()
    //Método iniciarEstacion()
    
}//Fin de la clase
