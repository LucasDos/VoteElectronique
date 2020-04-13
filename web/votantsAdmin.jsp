<%--
  Created by IntelliJ IDEA.
  User: clapo
  Date: 13/04/2020
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class = "main_container">
        <h1>Liste des votants</h1>

        <table>
            <tr>
                <th>Nom</th>
                <th>Prénom</th>
                <th>Ville</th>
                <th colspan="2">Date de naissance</th>
            </tr>
            <!-- VALEURS TEST -->
            <tr>
                <td>John</td>
                <td>Wayne</td>
                <td>Winterset</td>
                <td>26/05/1907</td>
                <td class="radio"><input type="radio" name="selectVotant" onclick="
                    document.getElementById('votant_modifierBtn').disabled=false;
                    document.getElementById('votant_supprimerBtn').disabled=false"></td>
            </tr>
            <tr>
                <td>John</td>
                <td>Lennon</td>
                <td>Liverpool</td>
                <td>09/10/1940</td>
                <td class="radio"><input type="radio" name="selectVotant" onclick="
                    document.getElementById('votant_modifierBtn').disabled=false;
                    document.getElementById('votant_supprimerBtn').disabled=false"></td>
            </tr>
            <tr>
                <td>John</td>
                <td>Travolta</td>
                <td>Englewood</td>
                <td>18/02/1954</td>
                <td class="radio"><input type="radio" name="selectVotant" onclick="
                    document.getElementById('votant_modifierBtn').disabled=false;
                    document.getElementById('votant_supprimerBtn').disabled=false"></td>
            </tr>
            <tr>
                <td>John</td>
                <td>Cena</td>
                <td>West Newbury</td>
                <td>23/04/1977</td>
                <td class="radio"><input type="radio" name="selectVotant" onclick="
                    document.getElementById('votant_modifierBtn').disabled=false;
                    document.getElementById('votant_supprimerBtn').disabled=false"></td>
            </tr>
        </table>
        <br>

        <div class="center">
            <button id="votant_modifierBtn" disabled onclick="document.getElementById('modifVotant').style.display='block'">Modifier</button>
            <button id="votant_supprimerBtn" disabled>Supprimer</button>
            <button onclick="document.getElementById('ajoutVotant').style.display='block'">Ajouter</button>
        </div>

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
