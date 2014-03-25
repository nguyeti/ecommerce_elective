<%-- 
    Document   : menu_lat
    Created on : 22 mars 2014, 09:45:39
    Author     : Anthony, Etienne, Timothée
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="menu_lat">
    <!--a modifié par une boucle forEach -->
    <center>
        <c:forEach items="${dbcommerce.getCategories()}" var="category" >
            <a href="ControllerServlet?action=catalogue&id=${category.id}" class="btn btn-warning">${category.name}</a>
        </c:forEach>
    </center>
    <br>
</div>
