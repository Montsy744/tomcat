import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/REST")
public class RESTCallByJavaServlet extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            HttpRequest request = HttpRequest.newBuilder()
                                             .uri(URI.create("https://atom.iut-info.univ-lille.fr/planetary/apod?api_key=DEMO_KEY"))
                                             .method("GET", HttpRequest.BodyPublishers.noBody())
                                             .build();
            HttpResponse<InputStream> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofInputStream());

            ObjectMapper mapper = new ObjectMapper();
            Nasa nasa = mapper.readValue(response.body(), Nasa.class);
            
            PrintWriter out = resp.getWriter();
            out.println("<h2>" + nasa.getTitle() + "</h2>");
            out.println("<p>" + nasa.getExplanation() + "</p>");

            out.println("<img src="+nasa.getUrl()+" />");
        
        } catch(Exception e) {
            System.out.print(e);
        }

        
    }
}