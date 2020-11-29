<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: piete_8alqa94
  Date: 28/10/2020
  Time: 14:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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

    <c:if test="${nieuwsbrief == 'Yes'}">
        <li  ${param.actual eq 'Laatste nieuws'?"id = actual":""}>
            <a href="Servlet?command=getLaatsteNieuws">Laatste nieuws</a></li>
    </c:if>
    </ul>
</nav>
</body>
</html>
