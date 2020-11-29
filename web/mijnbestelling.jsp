<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="domain.db.ProductDB" %>
<%@ page import="domain.model.Product" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: piete_8alqa94
  Date: 06/10/2020
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mijn Bestelling</title>
    <link rel="stylesheet" href="css/css.css">
</head>
</head>

<body>
<div class="wrapper">

    <nav class="banner-main">
        <img class="imagee" src="images/foodbanner.png" alt="banner met food network logo">
    </nav>

    <jsp:include page="header.jsp">
        <jsp:param name="actual" value="Bestelling"/>
    </jsp:include>

    <table>

        <thead>
        <tr>
            <th>Product</th>
            <th>Hoeveelheid (kilo)</th>
            <th>Prijsaanbieding (euro)</th>
            <th>Verwijder</th>
            <th>Update</th>
        </tr>
        </thead>


<c:forEach var="product" items="${producten}">
        <tr>
            <th>${product.getNaam()}</th>
            <th>${product.getHoeveelheidKilo()}</th>
            <th>${product.getPrijsAanbieding()}</th>
            <td><a href="Servlet?command=deleteconfirm&naam=${product.getNaam()}">Verwijder</a></td>
            <td><a href="Servlet?command=update&naam=${product.getNaam()}">Update</a></td>

        </tr>

</c:forEach>

    </table>

    <table class="RESULT">
        <thead>
        <tr>
            <th>totaal producten: </th>
            <th>${totaalProducten} </th>

        </tr>

        <tr>
            <th>totaal gewicht:</th>
            <th>${totaalGewicht}</th>
        </tr>

        <tr>
            <th>totaal prijs:</th>
            <th>${totaalPrijs}</th>
        </tr>

        </thead>
    </table>
</div>
</body>
</html>
