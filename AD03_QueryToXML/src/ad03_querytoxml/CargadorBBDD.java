/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad03_querytoxml;

//import generated.Cliente;
//import generated.Clientes;
import generated.Cliente;
import generated.Clientes;
import java.io.FileOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

/**
 *
 * @author edallas
 */
public class CargadorBBDD {
    private BBDD bd;
    
    Clientes clientes = new Clientes();
    
    public CargadorBBDD() throws Exception {
        this.bd = new BBDD("localhost", "6603", "MISCLIENTES", "root", "root");
        if (this.bd.HuboError())
            throw new Exception("\n ERROR CONECTANDO A LA BBDD: " + bd.getMensajeError());
    }
    
    public void cargaSaldoNegativo() throws SQLException {
        String sentencia = "select * from cliente where saldo < 0;";
        ResultSet rs = this.bd.executeQuery(sentencia); // Ejecutamos la sentencia sql
        
        ArrayList<Cliente> listaClientes = (ArrayList<Cliente>) clientes.getListaClientes(); // Creamos una ArrayList para la lista de clientes
        while (rs.next()){
            int id = rs.getInt("id");
            String nombre = rs.getString("nombre");
            double saldo = rs.getDouble("saldo");
            
            Cliente cliente = new Cliente(id, nombre, saldo); // Con los datos obtenidos de cada registro creamos un cliente
            listaClientes.add(cliente); // Añadimos los nuevos clientes al Array List
            System.out.println(cliente.toString());
        }
       
        if(this.bd.HuboError())
            System.out.println("ERROR AL CARGAR LA LISTA DE CLIENTES: " + this.bd.getMensajeError());
    }
    
    public void saveXML(){
        try {
            JAXBContext context = JAXBContext.newInstance(Clientes.class);
            Marshaller convertidor = context.createMarshaller();
            
            convertidor.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            convertidor.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
            convertidor.marshal(clientes, System.out);
            
            FileOutputStream fos =  new FileOutputStream( "./fichero.xml");
            convertidor.marshal(clientes, fos);
        } catch (Exception ex) {
            System.out.println("ERROR AL GUARDAR EL FICHERO: " + ex);
        }
    }
}
