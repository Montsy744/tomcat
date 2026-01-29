package model;

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

    public boolean creat (Joueur joueur) {
        Connection conn = ds.getConnection();

        try (PreparedStatement pstmt = conn.prepareStatement("insert into Joueur (jno,pseudo,email,pwd,elo) values (?,?,?,?,?);")) {
            pstmt.setInt(1, joueur.getId());
            pstmt.setString(2, joueur.getNom());
            pstmt.setString(3, joueur.getEmail());
            pstmt.setString(4, joueur.getPsw());
            pstmt.setInt(5, joueur.getElo());

            pstmt.executeUpdate();

            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}
