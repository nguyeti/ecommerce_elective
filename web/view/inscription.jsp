<%-- 
    Document   : inscription
    Created on : 22 mars 2014, 10:35:40
    Author     : Anthony, Etienne, Timothée
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Page d'inscription</title>
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/jumbotron-narrow.css" rel="stylesheet">
    </head>
    <body>
        <div class="container">
            <jsp:include page="menu.jsp" />
            <h1>Veuillez entrer vos informations</h1>
            <h3>${erreur}</h3>
            <form action="ControllerServlet?action=validerInscription" method="POST" class="form-actions centre"/>
            <input type="text" name="firstname"  placeholder="Prénom" required/><br>
            <input type="text" name="lastname"  placeholder="Nom" required/><br>
            <input type="text" name="address" placeholder="Adresse" required/><br>
            <input type="number" name="phone"  placeholder="Téléphone" /><br>
            <input type="number" name="cc" required placeholder="Carte de crédit"/><br>
            <input type="email" name="email" required placeholder="Email"/> <br>
            <input type="password" name="password" required placeholder="Mot de passe"/><br>
            <input type="submit" value="S'inscrire" class="btn btn-primary"/>
        </form>
    </div>
</body>
</html>
