<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste Votants</title>
    <link rel="stylesheet" href="styles.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script>
        $(function(){
            $("#menuContainer").load("menu.html", function () {
                $("#menuVotants")[0].hidden = false;
            });
            $("#loginPopup").load("login.html");
        });
    </script>
</head>
<body>
    <div id="menuContainer"></div>

    <div class="main_container">
        <h1>Liste des votants</h1>
        <table>
            <thead>
            <tr>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Ville</th>
                <th>Date de naissance</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="votant" items="${votant}">
                <tr>
                    <td> <c:out value="${votant.nom}"> ${votant.nom} </c:out> </td>
                    <td> <c:out value="${votant.prenom}"> ${votant.prenom} </c:out> </td>
                    <td> <c:out value="${votant.ville}"> ${votant.ville} </c:out> </td>
                    <td> <c:out value="${votant.dateNaissance}"> ${votant.dateNaissance} </c:out></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <br>

        <!-- Bouton modifier/supprimer/ajouter -->
        <div class="center">
            <button id="votant_supprimerBtn" onclick="document.getElementById('supprVotant').style.display='block'">Supprimer</button>
            <button id="votant_ajourBtnonclick" onclick="document.getElementById('ajoutVotant').style.display='block'">Ajouter</button>
        </div>

        <!-- Popup ajouter -->
        <div id="ajoutVotant" class="modal">
            <form class="modal-content" action="/VoteElectronique_war_exploded/votants" method="post">
                <input class="hidden" type="text" name="action" value="ajouterVotant"/>
                <div class="form_container">
                    <label for="ajoutVotant_nom">Nom</label><br>
                    <input type="text" id="ajoutVotant_nom" name="nomVotant"><br>
                    <label for="ajoutVotant_prenom">Prénom</label><br>
                    <input type="text" id="ajoutVotant_prenom" name="prenomVotant"><br>
                    <label for="ajoutVotant_ville">Ville</label><br>
                    <input type="text" id="ajoutVotant_ville" name="villeVotant"><br>
                    <label for="ajoutVotant_naissance" >Date de naissance</label><br>
                    <input type="date" id="ajoutVotant_naissance" name="dateNaissVotant"><br>
                    <label for="ajoutVotant_mdp" name="mdpVotant">Mot de passe</label><br>
                    <input type="password" id="ajoutVotant_mdp"><br>
                    <br>
                    <div class="center">
                        <button type="submit">Ajouter</button>
                        <button type="button" onclick="document.getElementById('ajoutVotant').style.display='none'">Annuler</button>
                    </div>
                </div>
            </form>
        </div><br>

        <div id="supprVotant" class="modal">
            <form class="modal-content" action="/VoteElectronique_war_exploded/votants" method="post">
                <input class="hidden" type="text" name="action" value="supprimerVotant"/>
                <div class="form_container center">
                    <div>Sélectionner le votant à supprimer :</div><br>
                    <select name="selectVotantSuppr">
                        <c:forEach var="votant" items="${votant}" >
                            <option value="${votant.id}"><c:out value="${votant.nom}">${votant.nom}</c:out>
                                <c:out value="${votant.prenom}"> ${votant.prenom}</c:out> </option>
                        </c:forEach>
                    </select>

                    <input type="submit" value="Confirmer">
                    <button type="button" onclick="document.getElementById('supprVotant').style.display='none'">Annuler</button>
                </div>
            </form>
        </div><br>



    <div id="loginPopup"></div>
</body>
</html>
