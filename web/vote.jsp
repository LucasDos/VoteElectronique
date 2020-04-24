<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vote</title>
    <link rel="stylesheet" href="styles.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script>
        $(function(){
            $("#menuContainer").load("menu.html");
            $("#loginPopup").load("login.html");
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
                <th>Sélectionner</th>
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
                    <td class="radio"><input type="radio" name="voteCandidat" onclick=" document.getElementById('voteBtn').disabled=false"> </td>
                </tr>
            </c:forEach>
            </tbody>

        </table>
        <br>

        <!-- Bouton vote -->
        <div class="center">
            <button id="voteBtn" disabled onclick="document.getElementById('confirmVote').style.display='block'">Voter</button>
        </div>

        <!-- Popup Vote -->
        <div id="confirmVote" class="modal">
            <form class="modal-content">
                <div class="form_container">
                    <div class="center">
                        Vous êtes sur le point de voter pour :<br>
                        <br>
                        <b>Nom du cadidat <!-- a faire --></b><br>
                        <br>
                        <button type="submit">Confirmer</button>
                        <button onclick="document.getElementById('confirmVote').style.display='none'">Annuler</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div id="loginPopup"></div>
</body>
</html>
