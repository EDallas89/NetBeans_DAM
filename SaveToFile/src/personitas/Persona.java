/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personitas;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 *
 * @author edallas
 */
public class Persona {

    public String nombre;
    public String apellidos;
    public int id;

    public boolean save(String fichero) {
        try {
            PrintWriter pw = new PrintWriter(fichero);
            pw.println(this.nombre);
            pw.println(this.apellidos);
            pw.println(this.id);
            
            pw.close();
        } catch (FileNotFoundException err) {
            return false;
        }
        return true;
    }
}
