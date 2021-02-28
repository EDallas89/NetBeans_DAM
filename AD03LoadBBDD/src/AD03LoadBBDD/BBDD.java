/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AD03LoadBBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author edallas
 */
public class BBDD {
  public  Connection conexion; 
  private java.sql.Statement comandoSql; 
  private  String mensajeError; 
  private  boolean hayError;
    
    public BBDD(String servidor, String puerto ,String baseDatos, String usuario, String password){
        try{
                String bd = "//" + servidor + ":" + puerto + "/" + baseDatos + "?useSSL=false";
                Class.forName("com.mysql.cj.jdbc.Driver"); // carga el driver de conexión con la bbdd
                
                this.conexion = DriverManager.getConnection("jdbc:mysql:" + bd, "root", "root");
                this.comandoSql = this.conexion.createStatement();
                this.hayError = false;
        }catch (ClassNotFoundException | SQLException ex){
                this.hayError = true;
                this.mensajeError = ex.getMessage();
        }
    }
    
    public boolean HuboError() {return this.hayError;}
    public String getMensajeError() {return this.mensajeError;}
    
    public void close(){ // cerramos la conección con la bbdd
        try {
                this.conexion.close();
                this.hayError = false;
        } catch (SQLException ex) {
                this.hayError = true;
                this.mensajeError = ex.getMessage();
        }
    }
    
    @Override
    public void finalize() throws Throwable {
        this.clone(); 
        super.finalize();
    }
    
    public ResultSet executeQuery(String sentencia){
        try {
                this.hayError = false;
                return this.comandoSql.executeQuery(sentencia);
        } catch (SQLException ex) {
                this.hayError = true;
                this.mensajeError = ex.getMessage();
                return null;
        }
    }
    
    public int executeUpdate(String sentencia){
        try {
                this.hayError = false;
                return this.comandoSql.executeUpdate(sentencia);
        } catch (SQLException ex) {
                this.hayError = true;
                this.mensajeError = ex.getMessage();
                return 0;
        }
    }
}