/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_conexion;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author edallas
 */
public class Conexion {
    Connection conn;
    
    public Conexion(){
        conn=null;
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library?useSSL=false&useTimezone=true&serverTimezone=UTC","root","root");
            if (conn != null){
                System.out.println("Conectado a la BBDD");
            }
            
        }catch (Exception e){
            System.out.println("Error de conexión");
            System.err.println("Error:" + e);
        }
    }   
}