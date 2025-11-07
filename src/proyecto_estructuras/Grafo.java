/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructuras;

/**
 * Clase Grafo
 * 
 * Representa la estructura de datos principal del grafo dirigido.
 * Contiene una lista enlazada de vértices (NodoGrafo), donde cada vértice
 * representa un perfil de la red social.
 *
 * @author Anthony Goncalves, Miguel Sulbarán
 * @version 1.0
 */
public class Grafo{
    private NodoGrafo primero;
    private NodoGrafo ultimo;

    /**
     * Constructor de la clase Grafo.
     * Inicializa un nuevo grafo vacío, estableciendo los punteros
     * "primero" y "ultimo" en null.
     * 
     * @author Anthony Goncalves
     * 
     */
    public Grafo(){
        this.primero = null;
        this.ultimo = null;
    }
    
    
    /**
     * Función GrafoEsvacio
     * 
     * Verifica si el grafo está vacío (no tiene vértices).
     *
     * @return true si el puntero "primero" es nulo, false si ya 
     * contiene al menos un vértice.
     * 
     * @author Anthony Goncalves
     * 
     */
    public boolean GrafoEsvacio(){
        return primero == null;
    }
    
    
    
    /**
     * Función getPrimero
     * 
     * Obtiene el primer vértice (NodoGrafo) de la lista principal del grafo.
     *
     * @return El objeto NodoGrafo que se encuentra al inicio de la lista (primero),
     * o null si el grafo está vacío.
     * 
     * @author Rafael Alvarez
     */        
    public NodoGrafo getPrimero(){
            return this.primero;}  
    
    
    
    /**
     * Función ExisteVertice
     * 
     * Verifica si un vértice (perfil) ya existe en el grafo.
     * Recorre la lista principal de vértices comparando el "dato" (Perfil)
     * de cada NodoGrafo con el String proporcionado.
     *
     * @param dato El String (ej: "@ana") del vértice que se desea buscar.
     * @return true si el vértice se encuentra en el grafo, false en caso contrario.
     * 
     * @author Anthony Goncalves
     */
    public boolean ExisteVertice(String dato){
        boolean existe = false;
        if(!GrafoEsvacio()){
            NodoGrafo pAux = this.primero;
            while(pAux != null && !existe){
                if(pAux.data.equals(dato)){
                    existe = true;
                }
                pAux = pAux.siguiente;
            }
                
        }
        return existe;
    }
    
    
    /**
     * Método NuevaArista
     * 
     * Crea una nueva arista (una relación de "seguir") entre dos vértices.
     * Primero, verifica que tanto el vértice de origen como el de destino existan.
     * Luego, busca el nodo de origen y llama a 'nuevaAdyacencia' en su
     * lista para agregar el destino.
     *
     * @param origen El String (ej: "@ana") del vértice que origina la arista (el seguidor).
     * @param destino El String (ej: "@pepe") del vértice que recibe la arista (el seguido).
     * 
     * @author Anthony Goncalves
     */
    public void NuevaArista(String origen, String destino){
        if(ExisteVertice(origen) && ExisteVertice(destino)){
            NodoGrafo pAux = this.primero;
            while(!pAux.data.equals(origen)){
                pAux = pAux.siguiente;
            }
            pAux.listaAdyacente.NuevaAdyacencia(destino);           
        }
    } 
    
   
    /**
     * Método NuevoNodo
     * 
     * Inserta un nuevo vértice (perfil) en el grafo.
     * Antes de insertar, verifica que no exista ya un vértice con el mismo
     * "dato" (nombre) y se añade el nuevo vértice al final de la lista
     * principal de vértices.
     *
     * @param dato El String (ej: "@pedro") del nuevo vértice a crear.
     * 
     * @author Anthony Goncalves
     */
    public void NuevoNodo(String dato){
        if(!ExisteVertice(dato)){
            NodoGrafo nodo = new NodoGrafo(dato);
            if(GrafoEsvacio()){
                this.primero = nodo;
                this.ultimo = nodo;          
            }else{
                ultimo.siguiente = nodo;
                ultimo = nodo;
            }
        }   
    }
    
    
    /**
     * Función Recorrer
     * 
     * Genera una representación en String del grafo completo.
     * Recorre cada vértice (NodoGrafo) en la lista principal y para cada uno,
     * invoca el método "recorrer" de su lista de adyacencia para mostrar
     * a quién "sigue".
     *
     * @return Un String que describe el grafo completo, mostrando cada
     * vértice y su lista de seguidos (ej: "@ana -> ha agregado a @beto, @carla, \n").
     * 
     * @author Anthony Goncalves
     */
    public String Recorrer(){
        NodoGrafo pAux = this.primero;
        String Cadena = "";
        while (pAux != null){
            Cadena = Cadena + pAux.data + " -> ha agregado a " + pAux.listaAdyacente.Recorrer() + "\n";
            pAux = pAux.siguiente;
        }
        return Cadena;
    }
    
    
    /**
     * Función BuscarNodo
     * 
     * Busca y retorna un vértice (NodoGrafo) dentro de la lista principal del grafo.
     * Recorre la lista de vértices hasta encontrar uno cuyo 'data'
     * coincida con el String proporcionado.
     *
     * @param dato El String (ej: "@ana") del vértice que se desea buscar.
     * @return El objeto NodoGrafo si se encuentra, o null si el grafo
     * está vacío o el vértice no existe.
     * 
     * @author Anthony Goncalves
     */
    public NodoGrafo BuscarNodo(String dato){
        if (this.GrafoEsvacio()){
            return null;
        }
        NodoGrafo pBuscador = this.primero;
        while (pBuscador != null){
            if (pBuscador.data.equals(dato)){
                return pBuscador;
            }
            pBuscador = pBuscador.siguiente;
        }
        return null;
    }
    

    
    /**
     * Método EliminarArista
     * 
     * Elimina una arista (una relación de "seguir") entre dos vértices.
     * Busca el vértice de origen y, si lo encuentra, llama al método
     * 'eliminarAdyacencia' de su lista para borrar la conexión con el destino.
     * Si el origen no existe, imprime un mensaje de error.
     *
     * @param origen El String (ej: "@ana") del vértice que origina la arista (el seguidor).
     * @param destino El String (ej: "@beto") del destino que se desea eliminar de la
     * lista de adyacencia del origen.
     * 
     * @author Anthony Goncalves
     */
    public void EliminarArista(String origen, String destino){
        NodoGrafo pAux = this.BuscarNodo(origen);

        if (pAux != null){
            pAux.listaAdyacente.EliminarAdyacencia(destino);
        } else {
            System.out.println("El perfil >" + origen + "< no existe. Por tanto no se puede eliminar su amistad con el perfil >"+ destino + "<.");
        }
    }
    
    
    /**
     * Método EliminarNodo
     * 
     * Elimina un vértice (perfil) del grafo, incluyendo todas sus conexiones y todas las conexiones que lo involucran como destino en el arco (seguido).
     * Primeramente elimina todas las aristas entrantes hacia  el "perfil"
     * seguidamente elimina el nodo "perfil" de la lista principal de vértices
     * 
     * @param perfil 
     * 
     * @author Anthony Goncalves
     */
    public void EliminarNodo(String perfil){
        if (this.GrafoEsvacio()){
            return;
        }

        NodoGrafo pBuscador = this.primero;
        while (pBuscador != null){
            pBuscador.listaAdyacente.EliminarAdyacencia(perfil);
            pBuscador = pBuscador.siguiente;
        }

        if (this.primero.data.equals(perfil)){
            this.primero = this.primero.siguiente;

            if (this.primero == null){
                this.ultimo = null;
            }
            return;
        }

        NodoGrafo pPrev = this.primero;
        pBuscador = this.primero.siguiente;

        while (pBuscador != null && !pBuscador.data.equals(perfil)){
            pPrev = pBuscador;
            pBuscador = pBuscador.siguiente;
        }
        if (pBuscador != null && pBuscador.data.equals(perfil)){
            pPrev.siguiente = pBuscador.siguiente;
            if (pBuscador == this.ultimo){
                this.ultimo = pPrev;
            }

        } else {
            System.out.println("El perfil >" + perfil + "< que se deseaba eliminar no existe.");
        }
    }
    
    
    
    /**
     * Método LlenaPila
     * 
     * El método realiza el primer recorrido del algoritmo de Kosaraju.
     * Este método visita recursivamente un nodo y todos sus adyacentes (nodos vecinos).
     * Después de que todos los nodos consecuentes fueron visitados, 
     * apila el dato del nodo actual en la Pila.
     *
     * @param nodo El vértice (NodoGrafo) actual desde el cual se empieza el recorrido.
     * @param Pilita es la Pila donde se almacenan los nodos en orden de tiempo de finalización (post-orden) para la segunda pasada.
     * 
     * @author Miguel Sulbaran
     */    
    public void LlenarPila(NodoGrafo nodo, Pila Pilita) {
    nodo.Visitado = true;
    Arco arco = nodo.listaAdyacente.pPrimero;

    while (arco != null) {
        NodoGrafo destino = BuscarNodo(arco.Destino);
        if (destino != null && !destino.Visitado) {
            LlenarPila(destino, Pilita);
        }
        arco = arco.pSiguiente;
    }

    Pilita.Apilar(nodo.data);
    
    }
    
    
    
    /**
     * Método LimpiarVisitados
     * 
     * Resetea la variable 'Visitado' de todos los nodos del grafo a false.
     * Este método se llama para realizar cada recorrido del grafo,
     * para asegurar que todos los nodos puedan ser visitados nuevamente.
     * 
     * @author Miguel Sulbaran
     */
    public void LimpiarVisitados() {
    NodoGrafo aux = this.primero;
    while (aux != null) {
        aux.Visitado = false;
        aux = aux.siguiente;
        }
    }
    
    
    
    
    /**
     * Función Invertido
     * 
     * Genera un nuevo grafo (Grafo Transpuesto) invirtiendo la dirección
     * de todas las aristas del grafo actual para recorrerlo.
     * Esta función es el segundo paso del algoritmo de Kosaraju.
     * Posteriormente, crea un nuevo grafo 'inv',
     * y copia todos los vértices del grafo original a 'inv'.
     * Luego, recorre todas las aristas del grafo original
     * y crea una arista invertida en 'inv'.
     * 
     * @return Un nuevo objeto Grafo que es el transpuesto del grafo actual.
     * 
     * @author Miguel Sulbaran
     */
    public Grafo Invertido() {
    Grafo inv = new Grafo();

    NodoGrafo aux = this.primero;
    while (aux != null) {
        inv.NuevoNodo(aux.data);
        aux = aux.siguiente;
    }
        aux = this.primero;
    while (aux != null) {
        Arco arco = aux.listaAdyacente.pPrimero;
        while (arco != null) {
            inv.NuevaArista(arco.Destino, aux.data);
            arco = arco.pSiguiente;
        }
        aux = aux.siguiente;
    }

    return inv;
    
    }
    
    
    
    /**
     * Función DfsInvertido
     * 
     * La función realiza la tercera fase del algoritmo de Kosaraju.
     * Esta función recursiva identifica todos los nodos fuertemente conectados.
     * Tiene dos funciones:
     * Retorna un String con todos los miembros (usuarios) fuertmente conectados encontrados.
     * Modifica el grafo original, le asigna un "ID"
     * 'currentCFCid' para marcar cada nodo fuertemente conectado.
     *
     * @param nodo Es el vértice (NodoGrafo) en el grafo invertido desde el cual 
     * se continúa el recorrido.
     * @param currentCFCid Es el ID numérico que se asignará a todos los nodos
     * encontrados en este componente.
     * @param original El grafo original (sin invertir), que se pasa como
     * referencia para poder actualizar los ID's fuertemente conectados.
     * @return Un String que concatena los 'data' de todos los nodos,
     * que esten fuertemente conectados, (CFC)=componentes fuertemente comentados.
     * 
     * @author Miguel Sulbaran, Rafael Alvarez
     */
    public String DfsInvertido(NodoGrafo nodo, int currentCFCid, Grafo original) {
    nodo.Visitado = true;
    String componente = nodo.data + " ";
    
    
    NodoGrafo nodoOriginal = original.BuscarNodo(nodo.data);
    if (nodoOriginal != null) {
        nodoOriginal.IDS_CFC = currentCFCid;
    }
    
    Arco pAux = nodo.listaAdyacente.getpPrimero();
    while (pAux != null) {
        NodoGrafo v_node = this.BuscarNodo(pAux.Destino);
        
        if (v_node != null && !v_node.Visitado) {
         
            componente += DfsInvertido(v_node, currentCFCid, original); 
        }
        pAux = pAux.pSiguiente;
    }
    return componente;
    
     }
    
    
    
   /**
    * Función Kosarju
    * 
     * Ejecuta el algoritmo de Kosaraju completo para encontrar todos los
     * Componentes Fuertemente Conectados (CFC) en el grafo.
     * Esta función orquesta las tres fases del algoritmo:
     * 
     * Primeramente, realiza un DFS (recorrido del grafo) sobre el grafo original para
     * llenar una Pila con los nodos en orden de tiempo de finalización
     * (llamando a 'llenarPila'). Consecuentemente, crea el grafo transpuesto (invertido)
     * (llamando a 'invertido'). Por último, realiza un DFS sobre el grafo invertido,
     * desapilando nodos de la Pila para encontrar y marcar cada CFC, llamando a 'dfsInvertido'.
     * 
     * Finalmente, retorna un String que clasifica los
     * componentes encontrados como Usuarios Fuertemente Conectados
     * o Débilmente Conectados.
     *
     * @return Un String formateado con el reporte de los componentes conexos.
     * 
     * @author Mguel Sulbaran
     */ 
    public String Kosaraju() {

        this.LimpiarVisitados();
        
        
    Pila Pilita = new Pila();    

    NodoGrafo pAux = primero;
    while (pAux != null) {
        while (pAux != null) {
            if (!pAux.Visitado) {
                LlenarPila(pAux, Pilita);
            }
            pAux = pAux.siguiente;
        }
    
    }

    NodoGrafo aux = primero;
    while (aux != null) {
        if (!aux.Visitado) {
            LlenarPila(aux, Pilita);
        }
        aux = aux.siguiente;
    }

    Grafo inv = this.Invertido();
    inv.LimpiarVisitados();
    
        int Contador_de_cfc = 0;

    String Fuertes = "";
    String Debiles = "";
    String Resultado = "";

    while (!Pilita.EsVacio()) {
        String nombre = Pilita.Desapilar();
        NodoGrafo nodo = inv.BuscarNodo(nombre);
        
        if (nodo != null && !nodo.Visitado) {
            Contador_de_cfc++;
            String Usuario = inv.DfsInvertido(nodo, Contador_de_cfc, this);
            int cantidad = Usuario.split(" ").length;

                if (cantidad > 1) {
                    Fuertes += Usuario;
                } else {
                    Debiles += Usuario;
                }
            }   
                 
    }
    
    Resultado += "Analisis del algoritmo de Kosaraju\n\n\n";
        if (Fuertes.isEmpty()) {
            Resultado += "No hubo ningun elemento fuertemente conectado\n\n";
        } else  {
            Resultado += " Los usuarios Fuertemente Enlazados son:\n";
        Resultado += Fuertes.trim().replaceAll(" ", ", ") + "\n\n";
        }
        
        if (Debiles.isEmpty()) {
            Resultado += " Nodos Aislados o Débilmente Conectados:\n";
        Resultado += Debiles.trim().replaceAll(" ", ", ") + "\n";
        } else {
        
        }
    return Resultado;
    }

}

