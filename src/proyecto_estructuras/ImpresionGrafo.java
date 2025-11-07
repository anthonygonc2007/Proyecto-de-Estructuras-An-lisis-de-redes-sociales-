/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructuras;
import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.view.Viewer;
import javax.swing.JOptionPane;

/**
 *
 * @author Rafael Álvarez,
 */

public class ImpresionGrafo {

    public static void MostrarGrafoVisualizado(Grafo grafoOriginal) {
        if (grafoOriginal == null) {
            JOptionPane.showMessageDialog(null, "El grafo no ha sido inicializado.", "Error de Visualización", JOptionPane.ERROR_MESSAGE);
            return;
        }
       
        System.setProperty("org.graphstream.ui", "swing");         
        Graph graph = new SingleGraph("RedSocial");        
        String Estilo_del_Nodo = "node {size: 15px; text-mode: normal; text-size: 10px;}";

        
        NodoGrafo nodoActual = grafoOriginal.getPrimero();
        while (nodoActual != null) {
            graph.addNode(nodoActual.data).setAttribute("ui.label", nodoActual.data);
            
            if (nodoActual.IDS_CFC != -1) {
                
                graph.getNode(nodoActual.data).setAttribute("ui.class", "cfc_" + nodoActual.IDS_CFC);
                
                int R = (nodoActual.IDS_CFC * 50 + 100) % 256; 
                int G = (nodoActual.IDS_CFC * 80 + 150) % 256; 
                int B = (nodoActual.IDS_CFC * 110 + 200) % 256;
                
                Estilo_del_Nodo += String.format("node.cfc_%d {fill-color: rgb(%d, %d, %d);}", 
                                            nodoActual.IDS_CFC, R, G, B);
            }
            nodoActual = nodoActual.siguiente;
        }
        
        nodoActual = grafoOriginal.getPrimero();
        int Contador_de_aristas = 0;
        
        while (nodoActual != null) {
            Arco arcoActual = nodoActual.listaAdyacente.getpPrimero();
            
            while (arcoActual != null) {
                
                String edgeId = "E" + Contador_de_aristas++; 
                
                graph.addEdge(edgeId, nodoActual.data, arcoActual.Destino, true); 
                arcoActual = arcoActual.pSiguiente;
            }
            nodoActual = nodoActual.siguiente;
        }
        
        graph.setAttribute("ui.stylesheet", Estilo_del_Nodo);
        graph.setAttribute("ui.antialias");
        
        
        Viewer viewer = graph.display();
        viewer.setCloseFramePolicy(Viewer.CloseFramePolicy.HIDE_ONLY); 
    }
}