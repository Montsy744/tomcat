import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/servlet-Palette")
public class Palette extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Palette de couleurs</title></head>");
        out.println("<body>");
        out.println("<h1 align='center'>Test de ma Palette</h1>");
        out.println("<table border='1' cellspacing='1' cellpadding='10' align='center'>");
        
        String rouge;
        int nbRouge = Integer.parseInt(req.getParameter("r"));
        try {
            if (nbRouge < 0 || nbRouge > 15) {
                throw new IndexOutOfBoundsException();
            } else  {
                rouge = Integer.toHexString(nbRouge);
            }
        } catch (Exception e){
            rouge = Integer.toHexString(0);
        }

        for (int v = 0; v < 16; v++) {
            out.println("<tr>");
            for (int b = 0; b < 16; b++) {
                // composantes hexadécimales verte et bleue
                String vert = Integer.toHexString(v);
                String bleu = Integer.toHexString(b);

                // couleur sous forme #0vb
                String couleur = "#"+ rouge + vert + bleu;

                out.println("<td bgcolor='" + couleur + "'>");
                out.println("</td>");
            }
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("<h1 align='center'>C'est beau !</h1>");

        out.println("<ul>");
        for(int i = 0; i < 16; i++){
            out.println("<li> "+ i +" :<a href=http://localhost:8080/vide/servlet-Palette?r="+ i +">http://localhost:8080/vide/servlet-Palette?r="+ i +"</a> ");
        }
        out.println("<li> "+ 100 +" :<a href=http://localhost:8080/vide/servlet-Palette?r=100>http://localhost:8080/vide/servlet-Palette?r=100</a> ");

        out.println("</ul>");


        out.println("</body></html>");
    }
}
