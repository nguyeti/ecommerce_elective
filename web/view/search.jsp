<%-- 
    Document   : search
    Created on : 23 mars 2014, 23:11:13
    Author     : Anthony, Etienne, Timothée
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Résultat de la recherche</title>
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/jumbotron-narrow.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <jsp:include page="menu.jsp" />
            <h1>Résultat de la recherche</h1>
            <jsp:include page="menu_lat.jsp" />
            <c:forEach items="${products}" var="product">
                <div class="produit">

                    <form action="ControllerServlet?action=ajout&id=${product.id}" method="POST" class="centre">
                        <a href="ControllerServlet?action=detailProduit&id=${product.id}"><img class="centre" src="image/${product.name}.jpg"></a><br><br>
                        <input type="submit" name="ajout" value="ajouter" />
                        <input type="number" name="quantite" value="1" />
                        ${product.price}
                        <a href="ControllerServlet?action=detailProduit&id=${product.id}">${product.name}</a>

                    </form>
                </div>
            </c:forEach>
        </div>
    </body>
</html>
