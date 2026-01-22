<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Tp découverte DAO</title>

    <%@ page pageEncoding="UTF-8" %> 
    <%@ page import = "dao.*" %>
  </head>
  <body>

    <h1>Afficher un joueur de votre choix :</h1>

    <% 
        int id = Integer.parseInt(request.getParameter("id"));
        JoueurDAO jDao = new JoueurDAO(new DS()); 
        Joueur j = jDao.findById(id);

        out.println(j);

    %>
  </body>
</html>
