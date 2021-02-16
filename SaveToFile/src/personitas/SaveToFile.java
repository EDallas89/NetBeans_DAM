/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personitas;

/**
 *
 * @author edallas
 */
public class SaveToFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona p = new Persona();
        p.nombre = "Inma";
        p.apellidos = "Sánchez";
        p.id = 1;
        
        p.save("/home/edallas/NetBeansProjects/SaveToFile/personas.txt");
    }     
}
