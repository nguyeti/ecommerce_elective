<%-- 
    Document   : menu
    Created on : 21 mars 2014, 23:10:33
    Author     : Anthony, Etienne, Timothée
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<div class="header">
    <ul class="nav nav-pills pull-right">
        <c:choose>
            <c:when test="${client != null}">
                <li><a href="ControllerServlet?action=profil">${client.firstname} ${client.lastname}</a></li>
                <li><a href="ControllerServlet?action=deconnexion">Deconnexion</a><br/></li>
                </c:when>
                <c:otherwise>
                <li><a href="ControllerServlet?action=Connexion">Connexion</a></li>
                <li><a href="ControllerServlet?action=Inscription">Inscription</a><br/></li>
                </c:otherwise>
            </c:choose>
        <li><a href="ControllerServlet?action=accueil">Accueil</a></li>
        <li><a href="ControllerServlet?action=produits">Produits</a></li>
        <li><a href="ControllerServlet?action=caddie">Accès au caddie</a></li>
        <li>
            <form action="ControllerServlet?action=recherche" method="POST">
                <input type="text" name="recherche" />
                <input type="submit" value="rechercher" />
            </form>
        </li>
    </ul>
</div>