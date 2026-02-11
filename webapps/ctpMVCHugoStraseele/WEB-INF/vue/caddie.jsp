<!DOCTYPE html>
<html lang="en">
<head>
    <%@ page pageEncoding="UTF-8" %>
    <%@ page import = "dao.*" %>
    <%@ page import="java.util.ArrayList" %>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <a href="Gestion?action=caddieVide">Videz le panier</a>
    <h2>Votre panier :</h2>
    <table>
        <td>
            <tr>
                Libelle
            </tr>
            <tr>
                Qte
            </tr>
        </td>
        <% 
        ArrayList<Produit> panier = (ArrayList<Produit>) session.getAttribute("panier");
        for(int i=0; i< panier.size(); i++) {
            %>  
        </br>
            <td>
                <tr>
                    <%=panier.get(i).getLibelle()%>
                </tr>
                <tr>
                    <%=panier.get(i).getPrix()%>
                </tr>
            </td>
        <%
        }%>
    </table>

    <h2>Les articles proposer sont : </h2>
    <table>
        <td>
            <tr>
                Libelle
            </tr>
            <tr>
                Prix
            </tr>
        </td>
        <% 
        String url;
        ArrayList<Produit> elements = (ArrayList<Produit>) session.getAttribute("element");
        for(int i=0; i< elements.size(); i++) {

            url = "Gestion?action=caddieRempli&id="+ (i+1);
            %>  
        </br>
            <td>
                <tr>
                    <a href=<%=url%>><%=elements.get(i).getLibelle()%></a>
                </tr>
                <tr>
                    <%=elements.get(i).getPrix()%>
                </tr>
            </td>
        <%
        }%>
    </table>
</body>
</html>