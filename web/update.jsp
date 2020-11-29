<%--
  Created by IntelliJ IDEA.
  User: piete_8alqa94
  Date: 13/11/2020
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
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

    <h1>Update je product: ${param.naam}</h1>
    <form method="post" action="Servlet?command=updateproduct" novalidate>
        <p class="form-group">
        <p>Update de hoeveelheid en prijsaanbod.</p>
        <label class="control-label" for="naam">naam: </label> <input
            id="naam" name="naam" type="text" value="${param.naam}" required>
        <label class="control-label" for="hoeveelheid">hoeveelheid (kilo): </label> <input
            id="hoeveelheid" name="hoeveelheid" type="text" value="${hoeveelheidPreviousValue}" required>

        <label class="control-label" for="prijsaanbod">Prijsaanbod: </label> <input
            id="prijsaanbod" name="prijsaanbod" type="text" value="${hoeveelheidPreviousValue}" required>
        </p>
        <c:if test="${not empty error}">
            <div class="alert alert-danger">
                <ul>
                    <c:forEach items="${error}" var="error">
                        <li>${error}</li>
                    </c:forEach>
                </ul>
            </div>
        </c:if>
        <p>
            <label for="update">&nbsp;</label> <input id="update" type="submit"
                                                      value="Update Product">
        </p>
    </form>
</body>
</html>
