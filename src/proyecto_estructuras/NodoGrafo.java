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
public class NodoGrafo {
    protected String data;
    protected ListaAdyacencia listaAdyacente;
    protected NodoGrafo siguiente;
    boolean Visitado;
    
    protected int IDS_CFC;
    

    public NodoGrafo(String x) {
        this.data = x;
        listaAdyacente = new ListaAdyacencia();
        this.siguiente = null;
        Visitado = false;
        this.IDS_CFC = -1;
    }
    
    public int getIdCFC() {
        return IDS_CFC;
    }
    
    public void setIdCFC(int idCFC) {
        this.IDS_CFC = idCFC;
    }
    
    public String getNombreUsuario() {
        return data;
    }
    
}
        
    
    
    
    
