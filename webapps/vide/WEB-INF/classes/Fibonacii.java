import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

@WebServlet("/servlet-Fibonacii")
public class Fibonacii extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        PrintWriter out = res.getWriter();
        out.println("<head><title>servlet fibonacii</title>");
        out.println("<META content=\"charset=UTF-8\"></head><body><center>");
        out.println("<h1>Fibonacii</h1>");
        out.println("</center>");

        int nb1 = 0;
        int nb2 = 1;
        int temp = 0;
        
        out.println(nb1 + "<br>");
        
        for (int i = 1; i < 30; i++) {
            out.println(nb2 + "<br>");
            temp = nb1 + nb2;
            nb1 = nb2;
            nb2 = temp;
        }

        out.println("</body></html>");
    }
}
