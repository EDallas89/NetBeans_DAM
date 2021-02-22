/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_conexion;

import java.sql.Connection;

/**
 *
 * @author edallas
 */
public class Test_Conexion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conexion conexion = new Conexion();
        Connection conn = conexion.conn;
    }
    
}
