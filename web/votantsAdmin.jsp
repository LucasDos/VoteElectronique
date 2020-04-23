<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste Votants</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="main_container">
        <h1>Liste des candidats</h1>
        <table>
            <thead>
            <tr>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Ville</th>
                <th>Date de naissance</th>
                <th>Sélectionner</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="votant" items="${votant}">
                <tr>
                    <td> <c:out value="${votant.nom}"> ${votant.nom} </c:out> </td>
                    <td> <c:out value="${votant.prenom}"> ${votant.prenom} </c:out> </td>
                    <td> <c:out value="${votant.ville}"> ${votant.ville} </c:out> </td>
                    <td> <c:out value="${votant.dateNaissance}"> ${votant.dateNaissance} </c:out></td>
                    <td class="radio"><input type="radio" id="${vitant.id}" name="selectVotant" onclick="
                        document.getElementById('votant_modifierBtn').disabled=false;
                        document.getElementById('votant_supprimerBtn').disabled=false"></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <br>

        <!-- Bouton modifier/supprimer/ajouter -->
        <div class="center">
            <button id="votant_modifierBtn" disabled onclick="document.getElementById('modifVotant').style.display='block'">Modifier</button>
            <button id="votant_supprimerBtn" disabled>Supprimer</button>
            <button onclick="document.getElementById('ajoutVotant').style.display='block'">Ajouter</button>
        </div>

        <!-- Popup ajouter -->
        <div id="ajoutVotant" class="modal">
            <form class="modal-content">
                <div class="form_container">
                    <label for="ajoutVotant_nom">Nom</label><br>
                    <input type="text" id="ajoutVotant_nom"><br>
                    <label for="ajoutVotant_prenom">Prénom</label><br>
                    <input type="text" id="ajoutVotant_prenom"><br>
                    <label for="ajoutVotant_ville">Ville</label><br>
                    <input type="text" id="ajoutVotant_ville"><br>
                    <label for="ajoutVotant_naissance">Date de naissance</label><br>
                    <input type="date" id="ajoutVotant_naissance"><br>
                    <br>
                    <div class="center">
                        <button type="submit">Ajouter</button>
                        <button type="button" onclick="document.getElementById('ajoutVotant').style.display='none'">Annuler</button>
                    </div>
                </div>
            </form>
        </div>

        <!-- Popup modifier -->
        <div id="modifVotant" class="modal">
            <form class="modal-content">
                <div class="form_container">
                    <label for="modifVotant_nom">Nom</label><br>
                    <input type="text" id="modifVotant_nom"><br>
                    <label for="modifVotant_prenom">Prénom</label><br>
                    <input type="text" id="modifVotant_prenom"><br>
                    <label for="modifVotant_ville">Ville</label><br>
                    <input type="text" id="modifVotant_ville"><br>
                    <label for="modifVotant_naissance">Date de naissance</label><br>
                    <input type="date" id="modifVotant_naissance"><br>
                    <br>
                    <div class="center">
                        <button type="submit">Enregistrer</button>
                        <button type="button" onclick="document.getElementById('modifVotant').style.display='none'">Annuler</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
