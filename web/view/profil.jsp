<%-- 
    Document   : profil
    Created on : 23 mars 2014, 19:05:21
    Author     : Anthony, Etienne, Timothée
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page de profil</title>
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/jumbotron-narrow.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <jsp:include page="menu.jsp" />
            <h1>Profil utilisateur</h1>
            <h2>Voici vos informations personnelles.</h2>
            <p>Prenom: ${client.firstname}</p>
            <p>Nom: ${client.lastname}</p>
            <p>Téléphone: ${client.phone}</p>
            <p>Adresse: ${client.address}</p>
            <p>n° CC: ${client.cc}</p>
            <p>Email: ${client.email}</p>
        </div>
    </body>
</html>
