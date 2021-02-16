/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad01_savefile;

import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author edallas
 */
public class Lista {

    static ArrayList ListaPersonas = new ArrayList<Persona>();

    public static void agregar(int id, String nombre, String apellidos) {
        Persona p = new Persona();
        p.id = id;
        p.nombre = nombre;
        p.apellidos = apellidos;
        ListaPersonas.add(p);
    }

    public static void saveFile(String file) {
        try {
            PrintWriter pw = new PrintWriter(file);
            for (int i=0; i<ListaPersonas.size(); i++){
                pw.println(ListaPersonas.get(i).toString());
            }
            pw.close();
            System.out.println("Lista guardada con exito!");
        } catch (Exception e) {
            System.out.println("Error al guardar fichero");
            System.out.println(e.getMessage());
        }
    }
}
