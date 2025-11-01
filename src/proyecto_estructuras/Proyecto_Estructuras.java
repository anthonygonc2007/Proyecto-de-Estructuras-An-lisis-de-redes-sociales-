/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_estructuras;

/**
 *
 * @author Antho
 */
public class Proyecto_Estructuras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Grafo grafito = new Grafo();
        for (int i = 0; i < 10; i++) {
            grafito.NuevoNodo(Integer.toString(i));    
        }
        for (int i = 0; i < 10; i++) {
            grafito.NuevaArista(Integer.toString(i), Integer.toString(i +1));
        }
        
        System.out.println(grafito.Recorrer());
        
    }
    
}
