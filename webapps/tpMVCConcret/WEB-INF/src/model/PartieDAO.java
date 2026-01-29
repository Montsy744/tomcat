package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PartieDAO {
    private DS ds;
    public PartieDAO(DS ds) {
        this.ds = ds;
    }

    public Partie findById(int id) {
        Connection conn = ds.getConnection();

        try (PreparedStatement pstmt = conn.prepareStatement("select * from Partie where no = ?")) {
            pstmt.setInt(1, id);

            ResultSet rs = pstmt.executeQuery();
                if(rs.next()) {
                    return new Partie(
                        rs.getInt("no"),
                        rs.getInt("jno1"),
                        rs.getInt("jno2"), 
                        rs.getDate("date"), 
                        rs.getString("statut"), 
                        rs.getInt("temps"), 
                        rs.getInt("gagnant")
                    );
                }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
