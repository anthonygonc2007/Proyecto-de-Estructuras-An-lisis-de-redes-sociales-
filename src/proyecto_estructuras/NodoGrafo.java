/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructuras;



/**
 * Clase NodoGrafo
 * Representa un Vértice (Nodo) del Grafo.
 * Esta clase almacena el dato (el String del perfil, ej: "@ana"),
 * un puntero a su lista de adyacencia (los perfiles que "sigue"), 
 * y un puntero al siguiente NodoGrafo en la lista principal del Grafo.
 * También incluye atributos (Visitado, IDS_CFC) para ser utilizados por 
 * los algoritmos de recorrido y componentes fuertemente conectados.
 *
 * @author Antho, Rafael Álvarez
 * @version 1.0
 */
public class NodoGrafo {
    protected String data;
    protected ListaAdyacencia listaAdyacente;
    protected NodoGrafo siguiente;
    boolean Visitado;    
    protected int IDS_CFC;
    

    
    /**
     * Constructor para un nuevo NodoGrafo.
     * Inicializa el nodo con su dato (nombre), crea su lista de
     * adyacencia vacía y establece los valores por defecto para
     * los algoritmos (Visitado = false, IDS_CFC = -1).
     *
     * @param x que serís el String o perfil (ej: "@ana") que identifica a este vértice.
     * @author Anthony Goncalves, Rafael Álvarez
     */
    public NodoGrafo(String x) {
        this.data = x;
        listaAdyacente = new ListaAdyacencia();
        this.siguiente = null;
        Visitado = false;
        this.IDS_CFC = -1;
    }
    
    /**
     * Obtiene el ID del Componente Fuertemente Conexo (CFC) al que
     * pertenece este nodo.
     *
     * @return El ID numérico del CFC, o -1 si aún no ha sido asignado.
     * @author Rafael Álvarez
     */
    public int getIdCFC() {
        return IDS_CFC;
    }
    

    /**
     * Asigna el ID del Componente Fuertemente Conexo (CFC) a este nodo.
     * Este método es utilizado por el algoritmo (Kosaraju) después
     * de identificar a qué componente pertenece el nodo.
     *
     * @param idCFC  que sería El ID numérico del CFC que se va a asignar.
     * @author Rafael Álvarez
     */
    public void setIdCFC(int idCFC) {
        this.IDS_CFC = idCFC;
    }
    
    /**
     * Método getNombreUsuario
     * Obtiene el dato (nombre de usuario) de este nodo.
     *
     * @return El String que representa el nombre de usuario (ej: "@ana").
     * @author Rafael Álvarez
     */
    public String getNombreUsuario() {
        return data;
    }
    
}
        
    
    
    
    
