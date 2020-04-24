<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Candidats Liste</title>
    <link rel="stylesheet" href="styles.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script>
        $(function(){
            $("#menuContainer").load("menu.html", function () {
                let logged = "<%=session.getAttribute("logged")%>";
                let loginMessage = "<%=session.getAttribute("message")%>";
                if(logged === "true") {
                    $("#boutonConnexion")[0].hidden = true;
                    $("#boutonDeconnexion")[0].hidden = false;
                    $("#boutonVote")[0].hidden = false;
                } else {
                    $("#boutonConnexion")[0].hidden = false;
                    $("#boutonDeconnexion")[0].hidden = true;
                    $("#boutonVote")[0].hidden = true;
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
        <h1>Liste des candidats</h1>
        <table>
            <thead>
                <tr>
                    <th>Nom</th>
                    <th>Prénom</th>
                    <th>Parti</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="votant" items="${candidat}">
                    <tr>
                        <td> <c:out value="${votant.nom}"> ${votant.nom} </c:out> </td>
                        <td> <c:out value="${votant.prenom}"> ${votant.prenom} </c:out> </td>
                        <td>
                            <c:forEach var="parti" items="${parti}">
                                <c:set var="idParti" value="${parti.id}"/>
                                <c:if test="${votant.idParti eq idParti}">
                                    <c:out value="${parti.nom}"> ${parti.nom} </c:out>
                                </c:if>
                            </c:forEach>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>

        </table>
        <br>

        <h1>Liste des partis</h1>
        <table>
            <thead>
                <tr>
                    <th>Nom</th>
                    <th>Siège</th>
                    <th>Nombre de candidats</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="parti" items="${parti}">
                <tr>
                    <td> <c:out value="${parti.nom}"> ${parti.nom} </c:out> </td>
                    <td> <c:out value="${parti.siege}"> ${parti.siege} </c:out> </td>
                    <td> <c:out value="${parti.nbInscrit}"> ${parti.nbInscrit} </c:out> </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <br>
    <div class="center">
        <button id="boutonVote" class="boutonFin" hidden>Voter</button>
        <div id="loginMsg" class="boutonFin"></div>
    </div>

    <div id="loginPopup"></div>
    <div id="logoutPopup"></div>
</body>
</html>
