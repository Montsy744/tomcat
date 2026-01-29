<!DOCTYPE html>
<%@ page import="java.util.List" %>
<%@ page pageEncoding="UTF-8" %>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <title>liste</title>
</head>
<body>
    <h1>Liste des éléments</h1>
    <% 
        List<String> elements = ((List<String>)request.getAttribute("elements"));
        for(int i = 0; i < elements.size(); i++) {
    %>
        <p> <%=elements.get(i) %> </p>
    <%
        }
    %>

</body>
</html>