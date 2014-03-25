<%-- 
    Document   : caddie
    Created on : 22 mars 2014, 00:57:34
    Author     : Anthony, Etienne, Timothée
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Caddie</title>
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/jumbotron-narrow.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <jsp:include page="menu.jsp" />
            <table class="table-striped">
                <tr>
                    <th>Modèle</th>
                    <th>Quantité</th>
                    <th>Somme</th>
                    <th>Modification</th>
                </tr>

                <c:forEach items="${cart.getProducts()}" var="product">
                    <tr>        
                    <form action="ControllerServlet?action=modife&id=${product.id}" method="POST">
                        <td> ${product.name}</td>
                        <td> <input type="number" name="quantite" value="${cart.getQuantity(product)}" /></td>
                        <td>${product.price * cart.getQuantity(product)}$</td>
                        <td><input type="submit" name="modifier" value="modifier" class="btn btn-success"/>
                            <input type="submit" name="modifier" value="supprimer" class="btn btn-danger" /></td>
                    </form>
                    </tr>
                </c:forEach>

            </table>
            <br>
            <c:if test="${cart!=null}" > 
                <form action="ControllerServlet" method="POST">
                    <input type="submit" name="action" value="valider achats" class="btn btn-success"/>
                    Total : ${cart.amount}€
                </form>
            </c:if>
        </div>

    </body>
</html>
