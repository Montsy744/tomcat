import java.io.*;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/S2a")
public class S2a extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String age40 = request.getParameter("40");
        String age55 = request.getParameter("55");

        if(age40 != null) {
            out.println("<form action=S2b >");
            out.println("<p>A <input name=emploi type=radio value=lyceen>");
            out.println("<p>B <input name=emploi type=radio value=enrechercheEmploi>");
            out.println("<p>C <input name=emploi type=radio value=tempsPartiel>");
            out.println("<p>D <input name=emploi type=radio value=tempsPlein>");
            out.println("<input type=submit>");
            out.println("</form>");
        } else if(age55 != null){
            out.println("<form action=S2b >");
            out.println("<p>B <input name=emploi type=radio value=enrechercheEmploi>");
            out.println("<p>C <input name=emploi type=radio value=tempsPartiel>");
            out.println("<p>D <input name=emploi type=radio value=tempsPlein>");
            out.println("<p>E <input name=emploi type=radio value=retrait>");
            out.println("<input type=submit>");
            out.println("</form>");
        }else {
            out.println("<form action=S2b >");
            out.println("<p>B <input name=emploi type=radio value=enrechercheEmploi>");
            out.println("<p>C <input name=emploi type=radio value=tempsPartiel>");
            out.println("<p>D <input name=emploi type=radio value=tempsPlein>");
            out.println("<input type=submit>");
            out.println("</form>");
        }
        

    }
}
