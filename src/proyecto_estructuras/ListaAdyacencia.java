/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructuras;



/**
 * Clase ListaAdyacencia
 * Representa la lista enlazada de adyacencias (arcos) para un vértice.
 * En el contexto del proyecto, esta clase almacena todos los perfiles
 * que un usuario específico "sigue".
 *
 * @author Anthony Goncalves 
 * @version 1.0
 */
public class ListaAdyacencia {

    Arco pPrimero;
    Arco pUltimo;

    
    /**
     * Constructor para la clase ListaAdyacencia.
     * Inicializa una nueva lista de adyacencia vacía, estableciendo
     * los punteros pPrimero y pUltimo en null.
     * @author Anthony Goncalves
     */
    public ListaAdyacencia(){
        this.pPrimero = null;
        this.pUltimo = null;
    }

    
    /**
     * Verifica si la estructura lista de adyacencia está vacía.
     * Comprueba si el puntero al primer elemento (pPrimero) es nulo.
     * 
     * @return true si la estructura está vacía, false en caso contrario.
     * @author Anthony Goncalves
     */
    public boolean Esvacia(){
        return this.pPrimero == null;
    }

    
    /**
     * Verifica si existe una adyacencia (un Arco) hacia un vértice específico.
     * Recorre la lista de Arcos buscando si alguno tiene como destino
     * el dato (String) proporcionado.
     *
     * @param dato String (ej: "@pedro") del vértice destino que se desea buscar en esta lista de adyacencia.
     * @return true si se encuentra un Arco que apunta a 'dato', false si no se encuentra.
     * @author Anthony Goncalves
     * 
     */
    public boolean Adyacente(String dato) {
        Arco pAux = this.pPrimero;
        boolean encontrado = false;
        while (pAux != null && !dato.equals(pAux.Destino)) {
            pAux = pAux.pSiguiente;
        }
        if (pAux != null) {
            encontrado = true;
        }
        return encontrado;
    }

    
    /**
     *  Inserta un nuevo arco al final de la lista de adyacencia.
     *  Es privado ya que solo puede ser llamado por otros métodos de la clase.
     * 
     * @param nodo que es el objeto Arco que se va a agregar al final de la lista de adyacencias.
     * 
     * @author Anthony Goncalves
     * 
     */
    private void Insertar(Arco nodo) {
        if (this.Esvacia()) {
            this.pPrimero = nodo;
            this.pUltimo = nodo;
        } else {
            pUltimo.pSiguiente = nodo;
            pUltimo = nodo;
        }
    }

    
    /**
     * Genera una representación o impresión en String de todos los destinos (campo data) en la lista de adyacencia.
     * Recorre cada Arco en la lista de adyacencia y concatena el 'Destino' 
     * (el nombre del perfil seguido) de cada uno.
     *
     * @return Un String con todos los destinos separados por coma (ej: "@pepe, @ana, "), o el texto "cero cuentas." si la lista está vacía.
     * 
     * @author Anthony Goncalves
     * 
     */    
    public String Recorrer() {
        Arco pAux;
        String cadena = "";

        if (this.Esvacia()) {
            return "cero cuentas.";
        } else {
            pAux = this.pPrimero;
            while (pAux != null) {
                cadena = cadena + pAux.Destino + ", ";

                pAux = pAux.pSiguiente;
            }
            return cadena;
        }
    }

    /**
     * Crea y agrega un nuevo Arco (adyacencia) a en la lista.
     * Antes de insertar, llama al método "adyacente" para verificar 
     * que la conexión en este caso el "seguido" no exista ya en la lista.
     *
     * @param Destino El String del perfil destino (ej: "@luis") al que 
     * se creará la nueva conexión (Arco).
     * 
     * @author Anthony Goncalves 
     * 
     */
    public void NuevaAdyacencia(String Destino) {
        if (!Adyacente(Destino)) {
            Arco nodo = new Arco(Destino);
            Insertar(nodo);
        }
    }
    
    
    
    /**
     * Elimina un Arco (adyacencia) de la lista de adyacencia basado en el String del destino.
     * Busca en la lista el Arco que contenga el destino (data) que coincide con el 'perfil' y lo desenlaza
     * desenlaza, manejando los casos de lista vacía, eliminación
     * en caso de sel el primer elemento o el último.
     *
     * @param perfil El String (ej: "@pepe") del destino que se desea eliminar.
     * @return Un String que indica el resultado de la operación 
     * (ej: "Perfil eliminado...", "No hay perfiles...").
     * 
     * @author Anthony Goncalves
     * 
     */    
    public String EliminarAdyacencia(String perfil) {
        if (this.Esvacia()) {
            return "No hay perfiles agregados por eliminar";
        }

        if (this.pPrimero.Destino.equals(perfil)) {
            this.pPrimero = this.pPrimero.pSiguiente;
            if (this.pPrimero == null) {
                this.pUltimo = null;
            }
            return "No hay elementos por eliminar";
        }
        
        Arco pPenul = this.pPrimero;
        Arco pBuscador = this.pPrimero.pSiguiente;

        while (pBuscador != null && !pBuscador.Destino.equals(perfil)) {
            pPenul = pBuscador;
            pBuscador = pBuscador.pSiguiente;
        }

        if (pBuscador != null) {
            pPenul.pSiguiente = pBuscador.pSiguiente;
            if (pBuscador == this.pUltimo) {
                this.pUltimo = pPenul;
            }
        }
        return "Perfil eliminado de amigos";
    }
        public Arco getpPrimero() { return this.pPrimero; }
}
