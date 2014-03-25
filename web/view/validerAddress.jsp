<%-- 
    Document   : validerAddress
    Created on : 23 mars 2014, 19:15:30
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
            <h2>Confirmation Adresse</h2>
            <p>Veuillez vérifié si l'adresse de reception est correcte. Si ce n'est pas le cas
                aller dans votre profil et changer celle-ci par une autre.
            </p>
            <p>${client.lastname}  ${client.firstname}</p>
            <p>${client.address}</p>
            <form action="ControllerServlet" method="POST">
                <input type="submit" name="action" value="Accepter" class="btn btn-success"/>
            </form>
        </div>
    </body>
</html>
