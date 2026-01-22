package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JoueurDAO {
    private DS ds;
    public JoueurDAO(DS ds) { this.ds = ds; }

    public Joueur findById(int id) {
        Connection conn = ds.getConnection();

        try (PreparedStatement pstmt = conn.prepareStatement("select * from Joueur where jno = ?")) {
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
                if(rs.next()) {
                    return new Joueur(
                        rs.getInt("jno"), 
                        rs.getString("pseudo"), 
                        rs.getString("email"), 
                        rs.getString("pwd"), 
                        rs.getInt("elo")
                    );
                }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
