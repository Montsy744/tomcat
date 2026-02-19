import java.io.PrintWriter;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DS;
import model.UserDao;

import java.util.Base64;

@WebServlet("/genereToken2")
public class GenereToken2 extends HttpServlet {

    UserDao dao = new UserDao(new DS());

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String login = req.getParameter("login");
        String psw = req.getParameter("psw");


        if(dao.getUser(login, psw) != null) {
            String uuid = Base64.getEncoder().encodeToString(String.format("%s:%s", login, psw).getBytes());
            if(dao.addTokenAtUser(login, psw, uuid)) {
                res.setStatus(HttpServletResponse.SC_OK);
                res.getWriter().println(String.format("""
                            {
                                "token" : "%s"
                            }
                        """, uuid));
                return;
            } else {
                    res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            }
            
        } 
        res.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
}
