/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AD03LoadBBDD;

import generated.Clientes;
import java.io.IOException;

/**
 *
 * @author edallas
 */
public class AD03LoadBBDD {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     * @throws java.io.FileNotFoundException
     */

    
    public static void main(String[] args) throws IOException,  Exception {
        System.out.println("\n\n********** COMENZAMOS  **********\n\n");
        
        /**
        // cargamos el json desde la web
        CreateFromURL lector = new CreateFromURL();
        Clientes lista = lector.carga(); 
        */
        GrabadorBBDD grabador = new GrabadorBBDD();
        /**
         * grabador.creaTabla(); // creamos la tabla cliente
        grabador.grabaEnBBDD(lista); // insertamos los registros del json
        */
        
        double suma = grabador.calculaSuma();
        
        System.out.println("\t La suma de los saldos es: " + suma + "\n\n");
    }    
}
