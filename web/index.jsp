<%-- 
    Document   : index
    Created on : 21 mars 2014, 23:07:22
    Author     : Anthony, Etienne, Timothée
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Accueil</title>
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/jumbotron-narrow.css" rel="stylesheet">
    </head>
    <body>

        <div class="container">
            <jsp:include page="view/menu.jsp" />


            <div class="jumbotron">
                <h1>Bienvenue</h1>
                <p class="lead">Nous vendons des téléphones sur ce site internet. N'attendez plus et faites vous avoir!</p>
                <p><a class="btn btn-lg btn-success" href="ControllerServlet?action=Inscription" role="button">Sign up today</a></p>
            </div>



            <div class="footer">
                <p>&copy; AET Company 2013</p>
            </div>

        </div> <!-- /container -->
    </body>
</html>
