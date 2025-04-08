<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bienvenue</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <header>
        <h1>Bienvenue</h1>
    </header>
    <div class="container">
        <div class="welcome-message">
            <h2>Bonjour, <%= session.getAttribute("username") %>!</h2>
            <p>Vous êtes maintenant connecté à notre plateforme.</p>
            <a href="logout.jsp" class="logout-link">Déconnexion</a>
            <a href="index.jsp" class="logout-link">retour</a>
        </div>
    </div>
</body>
</html>
