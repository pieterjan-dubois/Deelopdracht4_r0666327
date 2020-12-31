<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Home</title>
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


  <section class="explanation">

    <header class="overons">Over ons</header>
    <p>Bestel je Etenswaren op maat.</p>
    <p>In deze moeilijke tijden willen we iedereen kunnen bereiken zonder je het gevoel te geven dat dit niet veilig kan.</p>
    <p>We bieden kip, gehakt, rund, een ruim groente assortiment en fruit aan.</p>
    <p>Kies je product, je hoeveelheid en een prijs die je bereid bent te betalen.</p>
    <p>Wij zorgen voor de rest. Veel bestel plezier!</p>

    <p>Indien je je wil aanmelden om de nieuwsbrief te ontvangen met onze wekelijkse aanraders kan dit onderaan.</p>

    <section>
      <h2>Nieuwsbrief</h2>

      <form method="post" action="Servlet?command=nieuwsbrief">
        <p>
          <label for="nieuwsbriefja">Ja, ik wil de nieuwsbrief ontvangen</label>
          <input type="radio" name="nieuwsbrief" id="nieuwsbriefja" value="Yes" ${nieuwsbrief == 'Yes'? "checked" : ""}>

        </p>
        <p>
          <label for="nieuwsbriefno">Nee, liever niet</label>
          <input type="radio" name="nieuwsbrief" id="nieuwsbriefno" value="No" ${nieuwsbrief == 'No'? "checked" : ""}>

        </p>
        <p>
          <input type="submit" value="Submit">
        </p>
      </form>
    </section>
  </section>
    <section>
    <img class="home_background" src="images/homeimg.jpg" alt="photo of fruits and vegetables and meat">
  </section>



</div>
</body>
</html>