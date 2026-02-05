import java.net.URL;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.HttpURLConnection;

public class RestCallByJava {
    public static void main(String[] args) {
        try{
            URL url = new URL("https://atom.iut-info.univ-lille.fr/planetary/apod?api_key=DEMO_KEY");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();

            String reponse = new String(con.getInputStream().readAllBytes());

            ObjectMapper mapper = new ObjectMapper();
            Nasa nasa = mapper.readValue(reponse, Nasa.class);
            System.out.println(nasa.toString());
        } catch(Exception e) {
            System.out.print(e);
        }
    }
}
