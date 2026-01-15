<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <%@ page pageEncoding="UTF-8" %>
    <%@ page import = "java.sql.*" %>
    <title>TP - Java Server Pages</title>
</head>
<body>
    <h1>Ma table</h1>
    <TABLE Border=1 align=center>
    <% 
        String url = "jdbc:postgresql://psqlserv/but2";
        String user = "hugostraseeleetu";
        String password = "moi";

        try(Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conn.prepareStatement(
                "SELECT * FROM personn"
            )) {

                try(ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
    %>
                        <TR width=100% align=center>
                            <TD><%=rs.getInt(1)%> </TD>
                            <TD><%=rs.getString(2)%> </TD>
                            <TD><%=rs.getString(3)%> </TD>
                            <TD><%=rs.getInt(4)%> </TD>
                            <TD><%=rs.getString(5)%> </TD>
                            <TD><%=rs.getString(6)%> </TD>
                        </TR>
    <%
                    }
                }
    %>
            
    </TABLE>
    <%} catch (SQLException e) {
        out.println("Erreur de connexion à la base de données : " + e.getMessage());
    }
    %>
</body>
</html>