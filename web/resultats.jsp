<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Resultats</title>
    <link rel="stylesheet" href="styles.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script>
        $(function(){
            $("#menuContainer").load("menu.html", function () {
                let logged = "<%=session.getAttribute("logged")%>";
                if(logged === "true") {
                    $("#boutonConnexion")[0].hidden = true;
                    $("#boutonDeconnexion")[0].hidden = false;
                } else {
                    $("#boutonConnexion")[0].hidden = false;
                    $("#boutonDeconnexion")[0].hidden = true;
                }
            });
            $("#loginPopup").load("login.html");
            $("#logoutPopup").load("logout.html");
        });
    </script>
</head>
<body>
    <div id="menuContainer"></div>

    <div class="main_container">
        <h1>Résultats du vote</h1>

        <table>
            <thead>
                <th>Candidat</th>
                <th>Parti</th>
                <th>Nombre de votes</th>
            </thead>
            <tbody>
                <c:forEach var="candidat" items="${candidat}">
                    <tr>
                        <td>
                            <c:out value="${candidat.prenom}"> ${candidat.prenom} </c:out>
                            <c:out value="${candidat.nom}"> ${candidat.nom} </c:out>
                        </td>
                        <td>
                            <c:forEach var="parti" items="${parti}">
                                <c:set var="idParti" value="${parti.id}"/>
                                <c:if test="${candidat.idParti eq idParti}">
                                    <c:out value="${parti.nom}"> ${parti.nom} </c:out>
                                </c:if>
                            </c:forEach>
                        </td>
                        <td>
                            <c:forEach var="resultat" items="${resultat}">
                                <c:set var="idCandidat" value="${candidat.id}"/>
                                <c:if test="${resultat.idCandidat eq idCandidat}">
                                    <c:out value="${resultat.nbVote}"> ${resultat.nbVote} </c:out>
                                </c:if>
                            </c:forEach>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <div id="loginPopup"></div>
    <div id="logoutPopup"></div>
</body>
</html>
