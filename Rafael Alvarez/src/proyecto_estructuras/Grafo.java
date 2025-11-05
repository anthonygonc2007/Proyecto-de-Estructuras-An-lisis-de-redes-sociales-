/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructuras;

/**
 *
 * @author Antho, Miguel Sulbarán, Rafael Álvarez
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

      
}