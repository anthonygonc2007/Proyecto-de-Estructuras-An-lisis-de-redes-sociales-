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
public class Grafo{
    private NodoGrafo primero;
    private NodoGrafo ultimo;

    public Grafo(){
        this.primero = null;
        this.ultimo = null;
    }
    
    public boolean GrafoEsvacio(){
        return primero == null;
    }
    
    
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
    
    
    public void NuevaArista(String origen, String destino){
        if(ExisteVertice(origen) && ExisteVertice(destino)){
            NodoGrafo pAux = this.primero;
            while(!pAux.data.equals(origen)){
                pAux = pAux.siguiente;
            }
            pAux.listaAdyacente.NuevaAdyacencia(destino);           
        }
    } 
    
   
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
    
    
    public String Recorrer(){
        NodoGrafo pAux = this.primero;
        String Cadena = "";
        while (pAux != null){
            Cadena = Cadena + pAux.data + " -> ha agregado a " + pAux.listaAdyacente.Recorrer() + "\n";
            pAux = pAux.siguiente;
        }
        return Cadena;
    }
    
    
    
    private NodoGrafo BuscarNodo(String dato){
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
    

    public void EliminarArista(String origen, String destino){
        NodoGrafo pAux = this.BuscarNodo(origen);

        if (pAux != null){
            pAux.listaAdyacente.EliminarAdyacencia(destino);
        } else {
            System.out.println("El perfil >" + origen + "< no existe. Por tanto no se puede eliminar su amistad con el perfil >"+ destino + "<.");
        }
    }
    
    
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
    
    public void LlenarPila(NodoGrafo nodo, String[] pila, int[] tope) {
    nodo.Visitado = true;
    Arco arco = nodo.listaAdyacente.pPrimero;

    while (arco != null) {
        NodoGrafo destino = BuscarNodo(arco.Destino);
        if (destino != null && !destino.Visitado) {
            LlenarPila(destino, pila, tope);
        }
        arco = arco.pSiguiente;
    }

    pila[++tope[0]] = nodo.data;
    }
    
    public void LimpiarVisitados() {
    NodoGrafo aux = primero;
    while (aux != null) {
        aux.Visitado = false;
        aux = aux.siguiente;
        }
    }
    
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
    
    public void DfsInvertido(NodoGrafo nodo, String[] componente, int[] contador) {
    nodo.Visitado = true;
    componente[contador[0]++] = nodo.data;

    Arco arco = nodo.listaAdyacente.pPrimero;
    while (arco != null) {
        NodoGrafo destino = BuscarNodo(arco.Destino);
        if (destino != null && !destino.Visitado) {
            DfsInvertido(destino, componente, contador);
        }
        arco = arco.pSiguiente;
        }
    }
    
    public void Kosaraju() {
    int n = 0;
    NodoGrafo auxContador = primero;
    while (auxContador != null) {
        n++;
        auxContador = auxContador.siguiente;
    }

    String[] pila = new String[n];
    int[] tope = new int[]{-1};

    NodoGrafo aux = primero;
    while (aux != null) {
        if (!aux.Visitado) {
            LlenarPila(aux, pila, tope);
        }
        aux = aux.siguiente;
    }

    Grafo inv = this.Invertido();
    inv.LimpiarVisitados();

    String Fuertes = "";
    String Debiles = "";
    
    int contador2 = 1;

    while (tope[0] >= 0) {
        String nombre = pila[tope[0]--];
        NodoGrafo nodo = inv.BuscarNodo(nombre);
        if (nodo != null && !nodo.Visitado) {
            String[] Usuario = new String[n];
            int[] contador = new int[]{0};
            inv.DfsInvertido(nodo, Usuario, contador);
            
            boolean fuerte = fuerteono(Usuario, contador[0]);



            for (int i = 0; i < contador[0]; i++) {
                if (fuerte) {
                    Fuertes += Usuario[i] + " ";
                } else {
                    Debiles += Usuario[i] + " ";
                }
            }
            contador2++;
            }   
        
                  
        }
    
        if (Fuertes.isEmpty()) {
            System.out.println("No hay Usuarios Fuertemente Conectados");
        } else  {
            System.out.println("Usuarios Fuertemente Conectados: " + (Fuertes));
        }
        
        if (Debiles.isEmpty()) {
            System.out.println("No hay Usuarios Debilmente Conectados");
        } else {
            System.out.println("Usuarios Debilmente Conectados: " + (Debiles));
        }
    
    }
    
    private boolean fuerteono(String[] componente, int tamaño) {
        if (tamaño < 2) return false;

        for (int i = 0; i < tamaño; i++) {
            String origen = componente[i];
            int alcanzados = ContarAlcanzables(origen, componente, tamaño);
            if (alcanzados < tamaño) {
                return false;
            }
        }
        return true;
        }

        private int ContarAlcanzables(String origen, String[] componente, int tamaño) {
            LimpiarVisitados();
            NodoGrafo nodoOrigen = BuscarNodo(origen);
            if (nodoOrigen == null) return 0;

            int[] contador = new int[]{0};
            Contar(nodoOrigen, componente, tamaño, contador);
            return contador[0];
    }

    public void Contar(NodoGrafo nodo, String[] componente, int tamaño, int[] contador) {
        nodo.Visitado = true;
        contador[0]++;

        Arco arco = nodo.listaAdyacente.pPrimero;
        while (arco != null) {
            NodoGrafo destino = BuscarNodo(arco.Destino);
            if (destino != null && !destino.Visitado && Perteneceono(destino.data, componente, tamaño)) {
                Contar(destino, componente, tamaño, contador);
            }
            arco = arco.pSiguiente;
        }
    }

    public boolean Perteneceono(String nombre, String[] componente, int tamaño) {
            for (int i = 0; i < tamaño; i++) {
                if (componente[i].equals(nombre)) return true;
            }
            return false;
        }    


}