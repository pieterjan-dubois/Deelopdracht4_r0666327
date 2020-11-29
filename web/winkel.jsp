<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: piete_8alqa94
  Date: 06/10/2020
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Winkel</title>
    <link rel="stylesheet" href="css/css.css">
</head>
<body>
<div class="wrapper">

    <nav class="banner-main">
        <img class="imagee" src="images/foodbanner.png" alt="banner met food network logo">
    </nav>

    <jsp:include page="header.jsp">
        <jsp:param name="actual" value="VoegProductToe"/>
    </jsp:include>


    <div class="formulier">
        <form action="Servlet?command=add" method="post" novalidate>
            <label for="productnaam">Product:</label>
            <input type="text" id="productnaam" name="productnaam" placeholder="*verplicht" value=${productnaamPreviousValue} >

            <label for="hoeveelheid">Hoeveelheid (in kilo)</label>
            <input type="number" id="hoeveelheid" name="hoeveelheid" placeholder="*verplicht" value=${hoeveelheidPreviousValue}  >

            <label for="prijsaanbod">Prijsaanbod</label>
            <input type="number" id="prijsaanbod" name="prijsaanbod" placeholder="*verplicht" value=${prijsAanbodPreviousValue}  >
            <c:if test="${not empty error}">
                <div class="alert alert-danger">
                    <ul>
                        <c:forEach items="${error}" var="error">
                            <li>${error}</li>
                        </c:forEach>
                    </ul>
                </div>
            </c:if>


            <input type="submit" id="plaatsBestelling" value="plaatsBestelling">
        </form>

    </div>
</div>
</body>
</html>
