/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AD03LoadBBDD;

import com.google.gson.Gson;
import generated.Clientes;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

/**
 *
 * @author edallas
 */
public class CreateFromURL {
    private final String URL="http://www.ferminvelez.es/E3/clientes.json";

    private String getStringFromURL(String urlSolicitada) throws MalformedURLException, IOException {
        URL url = new URL(urlSolicitada); // debe llevar el protocolo http
        
        InputStream is = url.openStream(); // leemos lo que nos devuelve el servidor
        InputStreamReader isrUTF = new InputStreamReader(is, Charset.forName("UTF-8"));
        
        String string = "";
        int ch;
        BufferedReader br = new BufferedReader(isrUTF); // leemos desde la URL en formato UTF8
        while ((ch = br.read()) != -1) 
            string += (char) ch;
        
        br.close();
        return string;
    }
    
    public Clientes carga() throws IOException {
        Gson g = new Gson();
        
        String string = getStringFromURL(this.URL); // cargamos el json desde la WEB
        
        return g.fromJson(string, Clientes.class); // crea el objeto tipo Cliente con los datos que llegan de la web
    }
            
}
