<!DOCTYPE html>
<html lang="fr">
<head>
    <!-- sert à définir l'encodage des caractères utilisés dans la page JSP-->
    <%@ page pageEncoding="UTF-8" %>
    <%@ page import = "metier.*" %>

    <title>TP - Java Server Pages</title>
</head>
<body>
    <h1>Mon Objet</h1>
    <%

        Personne p = (Personne)application.getAttribute("global");
        if (p == null) {
            p = new Personne();
            application.setAttribute("global", p);
        }
    %>

    <p><%= p%></p>
    
</body>
</html>