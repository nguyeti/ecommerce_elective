<%-- 
    Document   : ajoutConfirmation
    Created on : 22 mars 2014, 21:12:01
    Author     : Anthony, Etienne, Timothée
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmation</title>
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/jumbotron-narrow.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <jsp:include page="menu.jsp" />
            <h1>Ajout du produit suivant au panier: ${product.name}</h1><br>
            <p>${product.name} a bien été ajouté au panier. Vous pouvez continuer vos achats.
                Pour retourner à la boutique, utilisez le menu ci-dessus</p>
        </div>
    </body>
</html>
