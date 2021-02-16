/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad01_loadfile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author edallas
 */
public class Lista {

    static ArrayList ListaPersonas = new ArrayList<Persona>();

    public static void loadFile(String fichero) {
        BufferedReader br = null;
        try {
            URL server = new URL(fichero);
            br = new BufferedReader(new InputStreamReader(server.openStream()));
            String linea = br.readLine();
            while (linea != null) {
                String[] partes = linea.split(", ");
                Persona p = new Persona();
                p.id = Integer.parseInt(partes[0]);
                p.nombre = partes[1];
                p.apellidos = partes[2];
                ListaPersonas.add(p);
                linea = br.readLine();
            }
            System.out.println("Lista cargada con exito!");
        } catch (FileNotFoundException e) {
            System.out.println("Error: Fichero no encontrado");
            System.out.println(e.getMessage());
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error de lectura del fichero");
            System.out.println(e.getMessage());
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el fichero");
                System.out.println(e.getMessage());
            }
        }
    }

    public static void printLista() {
        for (int i = 0; i < ListaPersonas.size(); i++) {
            System.out.println(ListaPersonas.get(i));
        }
    }
}
