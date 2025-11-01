/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto_estructuras;

/**
 *
 * @author Antho
 */
public class ListaAdyacencia {

    Arco pPrimero;
    Arco pUltimo;

    public ListaAdyacencia() {
        this.pPrimero = null;
        this.pUltimo = null;
    }

    public boolean Esvacia() {
        return this.pPrimero == null;
    }

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

    private void Insertar(Arco nodo) {
        if (this.Esvacia()) {
            this.pPrimero = nodo;
            this.pUltimo = nodo;
        } else {
            pUltimo.pSiguiente = nodo;
            pUltimo = nodo;
        }
    }

    public String Recorrer() {
        Arco pAux;
        String cadena = "";

        if (this.Esvacia()) {
            return "No ha agregado amigos";
        } else {
            pAux = this.pPrimero;
            while (pAux != null) {
                cadena = cadena + pAux.Destino + ", ";

                pAux = pAux.pSiguiente;
            }
            return cadena;
        }
    }

    public void NuevaAdyacencia(String Destino) {
        if (!Adyacente(Destino)) {
            Arco nodo = new Arco(Destino);
            Insertar(nodo);
        }
    }

}
