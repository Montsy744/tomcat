import java.io.PrintWriter;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DS;
import model.UserDao;

@WebServlet("/etudiants1/*")
public class ControleurEtudiant1 extends HttpServlet {

    UserDao dao = new UserDao(new DS());

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String token = req.getParameter("token");
        if (token == null) {
            res.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        } else if (dao.verifToken(token)) {
            res.setContentType("application/json;charset=UTF-8");
            PrintWriter out = res.getWriter();
            out.println(" { \"retour d'un GET\" : \"\" }");
            out.close();
        } else {
            res.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

    
}