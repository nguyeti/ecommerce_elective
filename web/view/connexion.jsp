<%-- 
    Document   : connexion
    Created on : 22 mars 2014, 10:13:23
    Author     : Anthony, Etienne, Timothée
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Connexion</title>
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/jumbotron-narrow.css" rel="stylesheet">
    </head>
    <body>
        <div class='container'>
            <jsp:include page="menu.jsp" />

            <h2>${message}</h2>
            <form action="ControllerServlet" method="POST">
                <input type="email" name="email"  placeholder="Email" required/><br>
                <input type="password" name="password" placeholder="Password" required/><br>
                <input type="submit" name="action" class="btn btn-primary" value="Connexion" />
            </form>
            <form action="ControllerServlet" method="POST">
                <input type="submit" name="action" value="Inscription" class="btn btn-primary" />
            </form>
            <h4>${erreur}</h4>

        </div>
    </body>
</html>
