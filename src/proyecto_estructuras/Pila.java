/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructuras;

/**
 *
 * @author Miguel
 */
public class Pila {
    public NodoPila cima;

    public Pila() {
        this.cima = null;
    }

 
    public void Apilar(String data){
        NodoPila nodo = new NodoPila(data);
        nodo.siguiente = cima;
        cima = nodo;
    }

    public String Desapilar() {
        if (EsVacio()) {
            return null;
        }
        String data = cima.data;
        cima = cima.siguiente;
        return data;
    }

    public String Cima() {
        if (EsVacio()) {
            return null;
        }
        return cima.data;
    }

    public boolean EsVacio() {
        return cima == null;
    }
}
