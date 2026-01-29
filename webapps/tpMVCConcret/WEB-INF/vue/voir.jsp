<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Voir</title>

    <%@ page pageEncoding="UTF-8" %>
    <%@ page import="model.Joueur" %>
</head>
<body>
    <%
    String joueur1 = ((Joueur)request.getAttribute("joueur1")).getNom();
    String Joueur2 = ((Joueur)request.getAttribute("joueur2")).getNom();
    %>

    <h1>Joueur 1 : <%= joueur1 %></h1>
    <h1>Joueur 2 : <%= joueur2 %></h1>
</body>
</html>