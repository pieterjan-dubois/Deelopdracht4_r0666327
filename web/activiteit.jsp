<%--
  Created by IntelliJ IDEA.
  User: piete_8alqa94
  Date: 20/12/2020
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Activiteit</title>
    <link rel="stylesheet" href="css/css.css">
</head>
<body>

<div class="wrapper">

    <nav class="banner-main">
        <img class="imagee" src="images/foodbanner.png" alt="banner met food network logo">
    </nav>

    <jsp:include page="header.jsp">
        <jsp:param name="actual" value="Home"/>
    </jsp:include>
<section>
    <h1 class="explanation">${title}</h1>
    <table>
        <tr>
            <th>Aantal keren deze pagina bezocht: ${visitCount}</th>
            <th>Eerste moment van je sessie: ${createTime}</th>
            <th>Laatste moment van je sessie: ${lastAccessTime}</th>
        </tr>

    </table>

</section>
</div>
</body>
</html>
