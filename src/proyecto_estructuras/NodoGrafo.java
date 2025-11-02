/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructuras;

/**
 *
 * @author Antho, Miguel Sulbarán
 * 
 */
public class NodoGrafo {
    protected String data;
    protected ListaAdyacencia listaAdyacente;
    protected NodoGrafo siguiente;
    boolean Visitado;
    

    public NodoGrafo(String x) {
        this.data = x;
        listaAdyacente = new ListaAdyacencia();
        this.siguiente = null;
        Visitado = false;
    }
    
        
    
    
    
    
}
