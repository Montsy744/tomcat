<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Formulaire ajout</title>
  </head>
  <body>
    <form action="Creat-Joueur" method="post" >
      <input name="id" placeholder="id" type="number" required/>
      <input name="nom" placeholder="nom" type="text" required/>
      <input name="email" placeholder="email" type="email" required/>
      <input name="psw" placeholder="Password" type="password" required/>
      <input name="elo" placeholder="Elo" type="number" required/>
      <button type="submit">Let`s go!</button>
    </form>
  </body>
</html>
