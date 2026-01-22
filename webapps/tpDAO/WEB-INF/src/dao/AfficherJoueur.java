package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AfficherJoueur {
    public static void main(String[] args) {
        DS ds = new DS();
        Connection conn = ds.getConnection();
        Joueur j;


        try (PreparedStatement pstmt = conn.prepareStatement("select * from Joueur where id = ?")) {
            pstmt.setInt(1, Integer.parseInt(args[0]));

            try(ResultSet rs = pstmt.executeQuery()) {
                if(rs.next()) {
                    j = new Joueur(
                        rs.getInt("jno"), 
                        rs.getString("pseudo"), 
                        rs.getString("email"), 
                        rs.getString("pwd"), 
                        rs.getInt("elo")
                    );

                    System.out.println(j);
                } else  {
                    j = null;
                }
            }

        } catch (Exception e) {
            e.getMessage();
        }
    }
}
