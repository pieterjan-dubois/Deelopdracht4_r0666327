<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bevestig</title>
    <link rel="stylesheet" href="css/css.css">
</head>
<body>
<div class="wrapper">

    <nav class="banner-main">
        <img class="imagee" src="images/foodbanner.png" alt="banner met food network logo">
    </nav>

    <nav class="container teal borderYtoX">

        <ul>
            <li class="sectie">
                <a href="Servlet?command=home" >Home</a>
            </li>
            <li class="sectie">
                <a href="Servlet?command=winkel">Winkel</a>
            </li>
            <li class="sectie">
                <a href="Servlet?command=bestelling">Mijn Bestelling</a>
            </li>
            <li class="sectie">
                <a href="Servlet?command=vindproduct">Vind Product</a>
            </li>
        </ul>
    </nav>
    <main>
        <h2>Bevestiging</h2>
        <p>Ben je zeker dat je je product ${param.naam} wil verwijderen?</p>
        <form action="Servlet?command=delete&naam=${param.naam}" method="POST">
            <input type="submit" value="Ja"/>
        </form>
        <p><a href="Servlet?command=bestelling">Cancel</a> indien je ${param.naam} niet wil verwijderen</p>
    </main>


</div>
</body>
</html>