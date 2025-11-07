/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructuras;


/**
 * Clase Pila
 * 
 * Implementa una estructura de Pila.
 * Esta clase se emplea como auxiliar en el algoritmo de Kosaraju para 
 * almacenar los vértices en su orden de tiempo de finalización (post-orden)
 * durante la primera pasada del DFS.
 *
 * @author Miguel Sulbaran
 * @version 1.0
 */
public class Pila {
    public NodoPila cima;

    
    
    
    /**
    * Es el constructor de la clase Pila.
    * Inicializa una nueva pila vacía, estableciendo su cima como null.
    * 
    * @author Miguel Sulbaran
    */    
    public Pila() {
        this.cima = null;
    }
 
    
    
    /**
     * Método Apilar
     * 
     * Inserta (apila) un nuevo elemento en la cima de la pila.
     * Crea un nuevo NodoPila con su valor data y lo establece como la
     * nueva cima de la pila.
     *
     * @param data Es el String que se va a apilar.
     * 
     * @author Miguel Sulbaran
     */    
    public void Apilar(String data){
        NodoPila nodo = new NodoPila(data);
        nodo.siguiente = cima;
        cima = nodo;
    }

    
    
    /**
     * Función Desapilar
     * 
     * Elimina (desapila) y retorna el elemento en la cima de la pila.
     * Si la pila está vacía, retorna null.
     *
     * @return El String (dato) del nodo que estaba en la cima, o null
     * si la pila está vacía.
     * 
     * @author Miguel Sulbaran
     */
    public String Desapilar() {
        if (EsVacio()) {
            return null;
        }
        String data = cima.data;
        cima = cima.siguiente;
        return data;
    }

    
    
    /**
     * Función Cima
     * 
     * Retorna el elemento en la cima de la pila sin eliminarlo.
     *
     * @return El String (dato) del nodo que está en la cima, o null
     * si la pila está vacía.
     * 
     * @author Miguel Sulbaran
     */
    public String Cima() {
        if (EsVacio()) {
            return null;
        }
        return cima.data;
    }
    
    
   
    /**
     * Función EsVacio
     * 
     * Verifica si la pila está vacía.
     *
     * @return true si la 'cima' es nula (la pila está vacía), 
     * false en caso contrario.
     * 
     * @author Miguel Sulbaran
     */
    public boolean EsVacio() {
        return cima == null;
    }
}
