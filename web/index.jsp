<%--
  Created by IntelliJ IDEA.
  User: clapo
  Date: 10/04/2020
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Index</title>
  <link rel="stylesheet" href="styles.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script>
    $(function(){
      $("#includedContent").load("login.html");
    });
  </script>
</head>
<body>
<a href="candidats.jsp">Candidats</a><br>
<a href="vote.jsp">Vote</a><br>
<a href="candidatsAdmin.jsp">Candidats (admin)</a><br>
<a href="votantsAdmin.jsp">Votants (admin)</a><br>
<button onclick="document.getElementById('login').style.display='block'">Se connecter</button>
<div id="includedContent"></div>
</body>
</html>
