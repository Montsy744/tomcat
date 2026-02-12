package controleur;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;

import org.apache.catalina.connector.Response;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import dao.DS;
import dao.IngredientDAODatabase;
import dto.Ingredient;


@WebServlet("/ingredient/*")
public class IngredientRestApi extends HttpServlet {

    IngredientDAODatabase ingredientDao = new IngredientDAODatabase(new DS());
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        ObjectMapper objectMapper = new ObjectMapper();

        String info = request.getPathInfo();
        //code pour un get général
        if(info == null || info.equals("/")){
            String jsonString = objectMapper.writeValueAsString(ingredientDao.findAll());
            out.println(jsonString);
            return;
        }

        //code pour un get avec id
        String[] splits = info.split("/");
        if (splits.length != 2) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        int id = Integer.parseInt(splits[1]);
        try {
            Ingredient ingredient = ingredientDao.findById(id);
            if (ingredient==null) {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
                return;
            }
            out.print(objectMapper.writeValueAsString(ingredient));
        } catch (SQLException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        return;

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        InputStream inputStream = req.getInputStream();
        String jsonstring = new String(inputStream.readAllBytes());
        
        Ingredient ingredient = objectMapper.readValue(jsonstring, Ingredient.class);
        try {
            if(ingredientDao.save(ingredient) == false) {
                resp.sendError(HttpServletResponse.SC_CONFLICT);
                return;
            }
        } catch (SQLException e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
        resp.sendError(HttpServletResponse.SC_CREATED);
        return;
    }
}
