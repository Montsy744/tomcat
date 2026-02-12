package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Ingredient;

public class IngredientDAODatabase implements DAOIngredient {
    private DS ds;

    public IngredientDAODatabase(DS ds) { this.ds = ds; }

    public ArrayList<Ingredient> findAll() {
        Connection conn = ds.getConnection();
        ArrayList<Ingredient> allP = new ArrayList<Ingredient>();

        try (PreparedStatement pstmt = conn.prepareStatement("select * from ingredients")) {

            ResultSet rs = pstmt.executeQuery();
                while(rs.next()) {
                    allP.add(new Ingredient(
                        rs.getInt("id"),
                        rs.getString("nom"), 
                        rs.getInt("prix")
                    ));
                }
        } catch (Exception e) {
            System.out.println(e);
        }
        return allP;
    }

    public Ingredient findById(int id) throws SQLException{
        Connection conn = ds.getConnection();

        PreparedStatement pstmt = conn.prepareStatement("select * from ingredients where id = ?");
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                return new Ingredient(
                        rs.getInt("id"),
                        rs.getString("nom"), 
                        rs.getInt("prix")
                    );
                }
        
        return null;
    }

    public boolean save(Ingredient i) throws SQLException {
        Connection conn = ds.getConnection();

        if(this.findById(i.getId()) != null) {
            return false;
        }

        try (PreparedStatement pstmt = conn.prepareStatement("INSERT INTO ingredients VALUES (?,?,?)")) {
            pstmt.setInt(1, i.getId());
            pstmt.setString(2, i.getNom());
            pstmt.setInt(3, i.getPrix());

            return pstmt.executeUpdate() == 1;
        } catch (Exception e) {
            System.out.println(e);
        }

        return false;
    }
}
