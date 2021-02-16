/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ad02_loadxml;

import generated.Grupo;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author edallas
 */
public class AD02_LoadXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        loadXML();
    }

    public static void loadXML() {
        Grupo group;
        try {
            // Creamos una nueva instancia de JAXBContext
            JAXBContext context = JAXBContext.newInstance(Grupo.class);
            // Creamos un nuevo convertidor de XML a Objeto
            Unmarshaller convertidor = context.createUnmarshaller();

            //Creamos y abrimos la conexión con la url del fichero xml
            URL url = new URL("http://www.ferminvelez.es/E2/grupo.xml");
            URLConnection conexion = url.openConnection();

            // Leemos el fichero y lo convertimos en una arraylist
            group = (Grupo) convertidor.unmarshal(conexion.getInputStream());
            group.printListaAlumnos();
        } catch (IOException | JAXBException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
