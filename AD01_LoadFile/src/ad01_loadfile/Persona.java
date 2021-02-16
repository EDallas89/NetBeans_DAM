/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad01_loadfile;

/**
 *
 * @author edallas
 */
public class Persona {
    public int id;
    public String nombre;
    public String apellidos;
    
    @Override
    public String toString() {
        return id + ", " + nombre + ", " + apellidos;
    }
}
