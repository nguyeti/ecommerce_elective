<%-- 
    Document   : catalogue
    Created on : 21 mars 2014, 23:46:38
    Author     : Anthony, Etienne, Timothée
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Produit</title>
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/jumbotron-narrow.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <jsp:include page="menu.jsp" />
            <h1>Les produits</h1>
            <jsp:include page="menu_lat.jsp" />
            <!--a modifié, ajouter boucle forEach pour afficher produit-->
            <div class="row">

                <c:forEach items="${dbcommerce.getProducts(requestScope.id)}" var="product">
                    <div class="col-md-3">
                        <div class="thumbnail">
                            <a href="ControllerServlet?action=detailProduit&id=${product.id}"><center><img src="image/${product.name}.jpg"></center></a>
                            <div class="caption">
                                <a href="ControllerServlet?action=detailProduit&id=${product.id}">${product.name}</a><br>
                                ${product.description} <br><br>
                                <center>
                                    <form action="ControllerServlet?action=ajout&id=${product.id}" method="POST">
                                        <input type="submit" name="ajout" value="ajouter" class="btn btn-success"/>
                                        <input type="number" name="quantite" value="1" />
                                        ${product.price} €

                                    </form>
                                </center>
                            </div>      
                        </div>
                    </div><br>
                </c:forEach>
            </div>
        </div>

    </body>
</html>
