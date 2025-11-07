/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructuras;


/**
 * Clase NodoPila
 * 
 * Representa un nodo individual dentro de la Pila.
 * Esta clase almacena el dato (el String del perfil) y un puntero
 * al siguiente nodo en la pila.
 *
 * @author Miguel Sulbaran
 * @version 1.0
 */
public class NodoPila {
    protected String data;
    protected NodoPila siguiente;

    
    
/**
* Función NodoPila
* 
* Es el constructor para el nuevo NodoPila.
* Inicializa el nodo con el dato y establece
* al puntero siguiente como nulo.
*
* @param data Es el String que se almacenará en este nodo.
* 
* @author Miguel Sulbaran
*/
    public NodoPila(String data) {
        this.data = data;
        this.siguiente = null;
    }
    
}
