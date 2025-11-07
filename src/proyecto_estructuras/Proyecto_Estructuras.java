/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_estructuras;
/**
 * Clase principal (Main) del proyecto de Análisis de Redes Sociales.
 * Esta clase contiene el método que sirve como punto de
 * entrada para la aplicación, inicializando y mostrando la 
 * interfaz gráfica principal (Interfaz).
 *
 * @author Anthony, Miguel Sulbarán, Rafael Álvarez
 * @version 1.0
 */
public class Proyecto_Estructuras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Interfaz Interfaz = new Interfaz();
        Interfaz.setVisible(true);   
        Interfaz.setLocationRelativeTo(null);
        Interfaz.setResizable(false);
    }
        
}
       
   
