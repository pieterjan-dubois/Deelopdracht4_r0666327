<%--
  Created by IntelliJ IDEA.
  User: piete_8alqa94
  Date: 19/11/2020
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Laatste nieuws</title>
    <link rel="stylesheet" href="css/css.css">
</head>
<body>
<div class="wrapper">
    <nav class="banner-main">
        <img class="imagee" src="images/foodbanner.png" alt="banner met food network logo">
    </nav>

    <jsp:include page="header.jsp">
        <jsp:param name="actual" value="Laatste nieuws"/>
    </jsp:include>
    <main>

        <p>Deze week is aangeraden:</p>
        <li>Rund</li>
        <li>Bananen</li>
        <li>Wortelen</li>
    </main>

</div>
</body>
</html>
