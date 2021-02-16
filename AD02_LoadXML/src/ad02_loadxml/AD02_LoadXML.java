/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad02_loadxml;

import generated.Grupo;

/**
 *
 * @author edallas
 */
public class AD02_LoadXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Grupo group = new Grupo();
        group.printListaAlumnos(group.loadXML());
    }
}