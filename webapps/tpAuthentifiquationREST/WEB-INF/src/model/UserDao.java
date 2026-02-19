package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

public class UserDao {
    private DS ds;

    public UserDao(DS ds) {
        this.ds = ds;
    }

    public User getUser(String login, String psw) {
        Connection conn = ds.getConnection();

        User user = null;
        try (PreparedStatement pstmt = conn.prepareStatement("select * from users where login = ? and pwd = ?")) {
            pstmt.setString(1, login);
            pstmt.setString(2, psw);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next() == false) {
                return null;
            } else {
                user = new User(
                        rs.getString("login"),
                        rs.getString("pwd"),
                        rs.getString("ROLE"),
                        rs.getString("token"),
                        rs.getInt("nb"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }

    public boolean addTokenAtUser(String login, String psw, String token) {
        Connection conn = ds.getConnection();

        try (PreparedStatement pstmt = conn
                .prepareStatement("Update users set token = ? where login = ? and pwd = ?")) {
            pstmt.setString(1, token);
            pstmt.setString(2, login);
            pstmt.setString(3, psw);

            pstmt.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;

    }

    public boolean verifToken(String token) {
        Connection conn = ds.getConnection();
        try (PreparedStatement pstmt = conn
                .prepareStatement("select count(*) as c from users where token = ?")) {
            pstmt.setString(1, token);
            
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt("c");
                return (count >= 1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public boolean verifTokenBasic(String token) {
        Connection conn = ds.getConnection();

        String decode = new String(Base64.getDecoder().decode(token.getBytes()));
        String[] decodSplit = decode.split(":");
        if(decodSplit.length != 2) {
            return false;
        }
        try (PreparedStatement pstmt = conn
                .prepareStatement("select login from users where login = ? and pwd = ?")) {
            pstmt.setString(1, decodSplit[0]);
            pstmt.setString(2, decodSplit[1]);
            
            ResultSet rs = pstmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
            return false;
        }
        
    }

}
