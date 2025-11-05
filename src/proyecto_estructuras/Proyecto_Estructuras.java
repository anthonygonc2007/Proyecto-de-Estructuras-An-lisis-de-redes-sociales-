/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_estructuras;


/**
 *
 * @author Antho, Miguel Sulbarán
 * 
 */
public class Proyecto_Estructuras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Interfaz Interfaz = new Interfaz();
        Interfaz.setVisible(true);    
        
        Grafo grafito = new Grafo();
        
        grafito.NuevoNodo("A");
        grafito.NuevoNodo("B");
        grafito.NuevoNodo("C");
        grafito.NuevoNodo("D");
        grafito.NuevoNodo("E");

        grafito.NuevaArista("A", "B");
        grafito.NuevaArista("B", "C");
        grafito.NuevaArista("C", "A");
        grafito.NuevaArista("B", "D");
        grafito.NuevaArista("D", "E");
        grafito.NuevaArista("E", "D");
        grafito.NuevaArista("E", "A");

        grafito.Kosaraju();
}
        
}
       
       
   
