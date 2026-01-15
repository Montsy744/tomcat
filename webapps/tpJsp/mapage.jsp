<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <!-- sert à définir l'encodage des caractères utilisés dans la page JSP-->
    <%@ page pageEncoding="UTF-8" %>

    <title>TP - Java Server Pages</title>
</head>
<body>
    <h1>Hello World</h1>
    <%
        for (int i = 1; i <= 9; i++)
        out.println(i);
    %>
    avec quelques accents à é è ù
</body>
</html>