<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="css/css.css"/>
</head>
<body>
<nav class="container teal borderYtoX">
<ul>
        <li ${param.actual eq 'Home'?"id = actual":""}>
            <a href="Servlet?command=home">Home</a> </li
        <li ${param.actual eq 'VindProduct'?"id = actual":""}>
            <a href="Servlet?command=vindproduct">Zoek Product</a> </li>
        <li ${param.actual eq 'VoegProductToe'?"id = actual":""}>
            <a href="Servlet?command=winkel">Voeg product toe</a> </li>
        <li ${param.actual eq 'Bestelling'?"id = actual":""}>
            <a href="Servlet?command=bestelling">Bestelling</a> </li>
    <li ${param.actual eq 'Log'?"id = actual":""}>
        <a href="Servlet?command=logcount">Log count</a> </li>
    <c:if test="${nieuwsbrief == 'Yes'}">
        <li  ${param.actual eq 'Laatste nieuws'?"id = actual":""}>
            <a href="Servlet?command=getLaatsteNieuws">Laatste nieuws</a></li>
    </c:if>
    </ul>
</nav>
</body>
</html>
