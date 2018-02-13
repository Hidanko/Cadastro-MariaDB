package backend;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class JsonHandler {

    public JsonHandler() {
    }


    public String buscarCEP(int CEP) throws Exception {
         String json;

        try {
            URL url = new URL("http://viacep.com.br/ws/"+ CEP +"/json");
            URLConnection urlConnection = url.openConnection();
            InputStream is = urlConnection.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            StringBuilder jsonSb = new StringBuilder();

            br.lines().forEach(l -> jsonSb.append(l.trim()));

            json = jsonSb.toString();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        System.out.println(json);
       return json;
        
    }
}
