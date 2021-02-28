/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clase_23_Feb;

import generated.Cliente;
import generated.Clientes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author edallas
 */
public class GrabadorBBDD {
    private BBDD bd;
    private PreparedStatement insertParametros;
    
    public GrabadorBBDD() throws Exception {
        this.bd = new BBDD("localhost", "6603", "MISCLIENTES", "root", "root");
        if (this.bd.HuboError())
            throw new Exception("\n ERROR CONECTANDO A LA BBDD: " + bd.getMensajeError());
    }
    
    void creaTabla() {
        String sentencia = "create table if not exists cliente " + 
                "(" + 
                    "id int primary key, " +
                    "nombre varchar(100), " +
                    "saldo double" +
                ");";
        this.bd.executeUpdate(sentencia);
        if (this.bd.HuboError())
            System.out.println("\nERROR AL CREAR LA TABLA: " + this.bd.getMensajeError() + "\n\n");
    }
    
    private void grabaCliente(Cliente c) throws SQLException{
        String sentencia = "insert into cliente (id,nombre,saldo) values "
                + "(" + c.getId() + ",'" + c.getNombre() + "'," + c.getSaldo() + ");";
        this.bd.executeUpdate(sentencia);
        if(this.bd.HuboError())
            System.out.println("ERROR AL INSERTAR EL CLIENTE: " + this.bd.getMensajeError());
    }
   
    void grabaEnBBDD(Clientes lista) throws SQLException{
        for (int i=0; i < lista.getListaClientes().size(); i++)
            grabaCliente(lista.getListaClientes().get(i));
    }
    
    double calculaSuma() throws SQLException{
        String sentencia = "select sum(saldo) Suma from cliente";
        ResultSet filas = this.bd.executeQuery(sentencia);
        
        filas.next();
        Double suma = filas.getDouble("Suma");
        filas.close();
        
        return suma;
    }
}
