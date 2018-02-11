package json;

import java.net.URL;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonHandler {

    public JsonHandler() {
    }

    public void buscarCEP(int CEP) throws Exception {

        JSONParser receptor = new JSONParser();
        String link = "viacep.com.br/ws/" + CEP + "/json/";
        System.out.println("JSON: " +link);
        JSONObject objeto = (JSONObject) receptor.parse(link);
        System.out.println("LEU");
        String rua = (String) objeto.get("logradouro");
        System.out.println(rua);

    }

}
