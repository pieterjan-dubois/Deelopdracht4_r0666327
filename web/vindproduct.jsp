<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vind Product</title>
    <link rel="stylesheet" href="css/css.css">
</head>
<body>
<div class="wrapper">

    <nav class="banner-main">
        <img class="imagee" src="images/foodbanner.png" alt="banner met food network logo">
    </nav>
        <jsp:include page="header.jsp">
            <jsp:param name="actual" value="VindProduct"/>
        </jsp:include>

    <article class="formulier">
    <h1>Zoek een Product</h1>
    <form method="post" action="Servlet?command=find" novalidate>
        <p>Welk product zoek je?</p>
        <p class="form-group">
            <label class="control-label" for="naam">Naam: </label> <input
                id="naam" name="naam" type="text" value="" required>
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
            <label for="zoek">&nbsp;</label> <input id="zoek" type="submit"
                                                    value="Vind Product">
        </p>
    </form>
    </article>
</div>
</body>
</html>