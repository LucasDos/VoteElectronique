<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vote</title>
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
                    window.location = "http://localhost:8081/VoteElectronique_war_exploded/candidats";
                }
            });
            $("#logoutPopup").load("logout.html");
        });
    </script>
</head>
<body>
    <div id="menuContainer"></div>

    <div class="main_container">
        <!-- Tableau des candidats -->
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

        <!-- Bouton vote -->
        <div class="center">
            <button id="voteBtn" onclick="document.getElementById('confirmVote').style.display='block'">Voter</button>
        </div>

        <!-- Popup Vote -->
        <div id="confirmVote" class="modal">
            <form class="modal-content" action="/VoteElectronique_war_exploded/vote" method="post">
                <input class="hidden" type="text" name="action" value="voter"/>
                <div class="form_container">
                    <div class="center">
                        Sélectionner le candidat pour soummettre un vote :<br>
                        <select name="selectCandidat">
                            <c:forEach var="candidat" items="${candidat}" >
                                <option value="${candidat.id}"><c:out value="${candidat.nom}">${candidat.nom}</c:out>
                                    <c:out value="${candidat.prenom}">${candidat.prenom}</c:out> </option>
                            </c:forEach>
                        </select>
                        <input type="submit" value="Confirmer"/>
                        <button type="button" onclick="document.getElementById('confirmVote').style.display='none'">Annuler</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div id="logoutPopup"></div>
</body>
</html>
