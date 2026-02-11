package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class ProduitDao {
    private DS ds;

    public ProduitDao(DS ds) {this.ds = ds;}

    public ArrayList<Produit> findAll() {
        Connection conn = ds.getConnection();
        ArrayList<Produit> allP = new ArrayList<Produit>();

        try (PreparedStatement pstmt = conn.prepareStatement("select * from produits")) {

            ResultSet rs = pstmt.executeQuery();
                while(rs.next()) {
                    allP.add(new Produit(
                        rs.getInt("id"),
                        rs.getString("libelle"), 
                        rs.getInt("prix")
                    ));
                }
        } catch (Exception e) {
            System.out.println(e);
        }
        return allP;
    }

    public Produit findById(int id) {
        Connection conn = ds.getConnection();

        try (PreparedStatement pstmt = conn.prepareStatement("select * from produits where id = ?")) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
                if(rs.next()) {
                    return new Produit(
                        rs.getInt("id"),
                        rs.getString("libelle"), 
                        rs.getInt("prix")
                    );
                }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    

}
