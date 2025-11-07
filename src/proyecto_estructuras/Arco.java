/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructuras;

/**
 * Clase Arco
 * Representa un Arco (o arista) del grafo.
 * Esta clase funciona como un nodo para la ListaAdyacencia, almacenando
 * el String del 'Destino' (el perfil al que se sigue) y un puntero al siguiente Arco en la lista.
 *
 * @author Anthony Goncalves
 * @version 1.0
 */
public class Arco {
    String Destino;
    Arco pSiguiente;
    
    
    /**
     * Constructor para un nuevo Arco.
     * Inicializa el Arco con el nombre del vértice destino y
     * establece su puntero 'pSiguiente' como nulo.
     *
     * @param Destino El String (ej: "@pepe") del vértice al que
     * este Arco apunta.
     * 
     * @author Anthony Goncalves
     */
    public Arco(String Destino) {
        this.Destino = Destino;
        this.pSiguiente = null;
    }

}

