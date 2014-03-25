<%-- 
    Document   : detailProduit
    Created on : 22 mars 2014, 09:48:38
    Author     : Anthony, Etienne, Timothée
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Détails</title>
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/jumbotron-narrow.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <jsp:include page="menu.jsp" />

            <jsp:include page="menu_lat.jsp" />
            <c:set var="product" value="${dbcommerce.getProduct(param.id)}" />
            <h1>${product.name}</h1>
            <p class="produit_maker">${product.maker} (${product.weight})</p>
            <img src="image/${product.name}.jpg"><br><br>
            <p class="description_produit">${product.description}</p><br><br>
            <div class="detail_produit">
                <center>
                    <form action="ControllerServlet?action=ajout&id=${product.id}" method="POST">
                        <input type="submit" name="ajout" value="ajouter" class="btn btn-success"/>
                        <input type="number" name="quantite" value="1" />

                    </form>
                </center>
            </div>
        </div>
    </body>
</html>
