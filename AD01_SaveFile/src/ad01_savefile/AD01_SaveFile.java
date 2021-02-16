/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad01_savefile;

/**
 *
 * @author edallas
 */
public class AD01_SaveFile {

    public static void main(String[] args) {
        Lista.agregar(001, "Inma", "Medina Sánchez");
        Lista.agregar(002, "Kelsier", "Nacido de la Bruma");
        
        Lista.saveFile("file.txt");
    }
}
