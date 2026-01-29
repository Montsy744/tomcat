<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>vignette</title>
</head>
<body>
    <h1>Elements choisi : <%= request.getParameter("id")%> </h1>
    <p><%= request.getAttribute("element")%></p>
</body>
</html>