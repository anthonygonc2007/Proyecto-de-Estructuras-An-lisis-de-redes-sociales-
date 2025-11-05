/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructuras;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;


/**
 *
 * @author Rafael Álvarez
 */
public class ImpresionGrafo {


    static class Entradas_de_color_NFC {
        int NFC_ID;    
        String Color; 

        public Entradas_de_color_NFC(int ID, String C) {
            this.NFC_ID = ID;
            this.Color = C;
        }
    }
    
   
    private static final String Diseño_del_Nodo = 
        "node {" +
            "text-mode: normal;" + 
            "size: 25px;" +       
            "text-size: 12;" +    
            "fill-mode: plain;" +
        "}" + 
        "edge {" +
            "arrow-shape: arrow;" + 
            "arrow-size: 10px, 5px;" + 
        "}";

    private static final String[] Colores = {"#FF0000", "#0000FF", "#008000", "#FFA500", "FCF400", "A000FC"}; // Los valores que pongo aca son los valores respectivos a los colores: Rojo, Azul, Verde, Naranja, Amarillo, Morado
}