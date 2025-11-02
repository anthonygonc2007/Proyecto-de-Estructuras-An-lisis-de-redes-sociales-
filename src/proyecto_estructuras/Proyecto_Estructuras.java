/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto_estructuras;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


/**
 *
 * @author Antho, Miguel Sulbarán
 * 
 */
public class Proyecto_Estructuras {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Interfaz Interfaz = new Interfaz();
        Interfaz.setVisible(false);        
        
        Grafo grafito = new Grafo();

        
        Leertexto(grafito);
        System.out.println("Contenido del grafo:");
        System.out.println(grafito.Recorrer());
        
    }

    public static void Leertexto(Grafo grafito) {
        JFileChooser Leertexto = new JFileChooser();
        Leertexto.setDialogTitle("Seleccione un archivo .txt por favor");

        int lectura = Leertexto.showOpenDialog(null);

        if (lectura == JFileChooser.APPROVE_OPTION) {
            File archivo = Leertexto.getSelectedFile();

            try (BufferedReader buffer = new BufferedReader(new FileReader(archivo))) {
                String aux;
                boolean leerUsuarios = false;
                boolean leerRelaciones = false;

                while ((aux = buffer.readLine()) != null) {
                    aux = aux.trim();
                    if (aux.isEmpty()) continue;

                    if (aux.equalsIgnoreCase("Usuarios")) {
                        leerUsuarios = true;
                        leerRelaciones = false;
                        continue;
                    }
                    if (aux.equalsIgnoreCase("Relaciones")) {
                        leerUsuarios = false;
                        leerRelaciones = true;
                        continue;
                    }

                    if (leerUsuarios) {
                        grafito.NuevoNodo(aux);
                        continue;
                    }

                    if (leerRelaciones) {
                        String[] partes = aux.split(",");
                        if (partes.length == 2) {
                            String origen = partes[0].trim();
                            String destino = partes[1].trim();
                            grafito.NuevaArista(origen, destino);
                        }
                    }
                }

                JOptionPane.showMessageDialog(null,
                        "Archivo cargado correctamente.",
                        "Éxito", JOptionPane.INFORMATION_MESSAGE);
                         

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Error al leer el archivo: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
                              
            }
 
        }       
    }
        
}
       
   
