<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Connexion</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <header>
        <h1>Connexion</h1>
    </header>
    <div class="container">
        <div class="form-container">
            <%-- Afficher les erreurs s'il y en a --%>
            <% if (request.getParameter("error") != null) { %>
                <div class="error"><%= request.getParameter("error") %></div>
            <% } %>
            
            <form action="login" method="post">
                <div class="form-group">
                    <label for="username">Nom d'utilisateur:</label>
                    <input type="text" id="username" name="username" value="admin" required>
                </div>
                <div class="form-group">
                    <label for="password">Mot de passe:</label>
                    <input type="password" id="password" name="password" value="1234" required>
                </div>
                <button type="submit">Se connecter</button>
            </form>
        </div>
    </div>
</body>
</html>
