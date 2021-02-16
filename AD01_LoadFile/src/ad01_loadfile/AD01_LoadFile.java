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
public class AD01_LoadFile {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Lista.loadFile("http://absolem.ml/file.txt");
        Lista.printLista();
    }
}