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
              
        
        
        grafito.NuevaArista("4", "9");
        grafito.NuevaArista("4", "1");
        grafito.NuevaArista("4", "6");
        grafito.NuevaArista("4", "7");
        grafito.NuevaArista("4", "7");

        

        
        System.out.println(grafito.Recorrer());
        
        grafito.EliminarArista("4", "5");
        // Probando que funcione eliminar una arista de un perfil que no existe.
        grafito.EliminarArista("12", "5");

        
        System.out.println(grafito.Recorrer());

        //grafito.EliminarNodo("9");
        grafito.EliminarNodo("1");
        
        //Probando que funcione eliminar un perfil que no existe.
        grafito.EliminarNodo("11");

        System.out.println(grafito.Recorrer());
        
    }
    
}
