/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fichero_lee0;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author edallas
 */
public class Fichero_lee0 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        File fichero = new File("/home/edallas/NetBeansProjects/AccesoDatos/Fichero_lee0/entero.json");

        if (!fichero.exists()) {
            System.out.println("El fichero no existe");
            return;
        }
        try {
            FileReader ficheroEntrada = new FileReader(fichero);
            int c;
            //BufferedReader ficheroEntrada = new BufferedReader(fichero);
            //String linea;
            while ((c = ficheroEntrada.read()) != -1) {
                System.out.println((char) c);
            }
            ficheroEntrada.close();
        } catch (Exception e) {
            System.out.println("No puedo leer del fichero: " + e);
        }
    }

}
