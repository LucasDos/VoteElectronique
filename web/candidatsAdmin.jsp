<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Candidats Admin</title>
        <link rel="stylesheet" href="styles.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
        <script>
            $(function(){
                $("#menuContainer").load("menu.html", function () {
                    let admin = "<%=session.getAttribute("admin")%>";
                    $("#menuVotants")[0].hidden = false;
                    if(admin === "true") {
                        $("#boutonConnexion")[0].hidden = true;
                        $("#boutonDeconnexion")[0].hidden = false;
                    } else {
                        window.location = "http://localhost:8081/VoteElectronique_war_exploded/candidats";
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
            <!-- Affiche le tableau des candidats -->
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
                <c:forEach var="candidat" items="${candidat}">
                    <tr>
                        <td> <c:out value="${candidat.nom}"> ${candidat.nom} </c:out> </td>
                        <td> <c:out value="${candidat.prenom}"> ${candidat.prenom} </c:out> </td>
                        <td>
                            <c:forEach var="parti" items="${parti}">
                                <c:set var="idParti" value="${parti.id}"/>
                                <c:if test="${candidat.idParti eq idParti}">
                                    <c:out value="${parti.nom}"> ${parti.nom} </c:out>
                                </c:if>
                            </c:forEach>
                        </td>
                </c:forEach>
                </tbody>
            </table>
            <br>

            <!-- Bouton ajouter, supprimer et modifier -->
            <div class="center">
                <button id="candidat_modifierBtn" onclick="document.getElementById('modifCandidat').style.display='block'">Modifier</button>
                <button id="candidat_supprimerBtn" onclick="document.getElementById('supprCandidat').style.display='block'">Supprimer</button>
                <button onclick="document.getElementById('ajoutCandidat').style.display='block'">Ajouter</button>
            </div>

            <!-- Popup ajouter candidats -->
            <div id="ajoutCandidat" class="modal">
                <form class="modal-content" action="/VoteElectronique_war_exploded/candidatsAdmin" method="post">
                    <input class="hidden" type="text" name="action" value="ajouterCandidat"/>
                    <div class="form_container">
                            <label for="ajoutCandidat_nom">Nom</label><br>
                            <input type="text" id="ajoutCandidat_nom" name="nomCandidat" onkeyup="
                                if(document.getElementById('ajoutCandidat_nom').value === ''
                                || document.getElementById('ajoutCandidat_prenom').value === ''
                                || document.getElementById('ajoutCandidat_parti').selectedIndex === -1 ){
                                    document.getElementById('ajoutCandidat_submit').disabled = true;
                                } else {
                                    document.getElementById('ajoutCandidat_submit').disabled = false;
                                }
                            "><br>
                            <label for="ajoutCandidat_prenom">Prénom</label><br>
                            <input type="text" id="ajoutCandidat_prenom" name="prenomCandidat" onkeyup="
                                if(document.getElementById('ajoutCandidat_nom').value === ''
                                || document.getElementById('ajoutCandidat_prenom').value === ''
                                || document.getElementById('ajoutCandidat_parti').selectedIndex === -1 ){
                                    document.getElementById('ajoutCandidat_submit').disabled = true;
                                } else {
                                    document.getElementById('ajoutCandidat_submit').disabled = false;
                                }
                            "><br>
                            <label for="ajoutCandidat_parti">Parti</label><br>
                            <select id="ajoutCandidat_parti" name="partiCandidat">
                                <c:forEach var="parti" items="${parti}">
                                    <option value="${parti.id}"> <c:out value="${parti.nom}"> ${parti.nom} </c:out> </option>
                                </c:forEach>
                            </select><br>
                            <br>
                            <div class="center">
                                <input type="submit" id="ajoutCandidat_submit" disabled value="Ajouter">
                                <button type="button" onclick="document.getElementById('ajoutCandidat').style.display='none'">Annuler</button>
                            </div>
                    </div>
                </form>
            </div>

            <!-- Popup Modifier candidat -->
            <div id="modifCandidat" class="modal">
                <form class="modal-content" action="/VoteElectronique_war_exploded/candidatsAdmin" method="post">
                    <input class="hidden" type="text" name="action" value="modifierCandidat"/>
                    <div class="form_container">
                        <div>Sélectionner le candidat à modifier :</div><br>
                        <select name="selectCandidatsModify">
                            <c:forEach var="candidat" items="${candidat}" >
                                <option value="${candidat.id}"><c:out value="${candidat.nom}">${candidat.nom}</c:out>
                                    <c:out value="${candidat.prenom}"> ${candidat.prenom}</c:out> </option>
                            </c:forEach>
                        </select>

                        <label for="modifCandidat_nom">Nom</label><br>
                        <input type="text" id="modifCandidat_nom" name="modifCandidat_nom"><br>

                        <label for="modifCandidat_prenom">Prénom</label><br>
                        <input type="text" id="modifCandidat_prenom" name="modifCandidat_prenom"><br>

                        <label for="modifCandidat_parti">Parti</label><br>
                        <select name="selectPartiModif" id="modifCandidat_parti">
                            <c:forEach var="parti" items="${parti}">
                                <option value="${parti.id}"> <c:out value="${parti.nom}"> ${parti.nom} </c:out> </option>
                            </c:forEach>
                        </select><br>
                        <br>
                        <div class="center">
                            <button type="submit">Enregistrer</button>
                            <button type="button" onclick="document.getElementById('modifCandidat').style.display='none'">Annuler</button>
                        </div>
                    </div>
                </form>
            </div>

            <!-- Suppression Candidat -->
            <div id="supprCandidat" class="modal">k
                <form class="modal-content" action="/VoteElectronique_war_exploded/candidatsAdmin" method="post">
                    <input class="hidden" type="text" name="action" value="supprimerCandidat"/>
                    <div class="form_container center">
                        <div>Sélectionner le candidat à supprimer :</div><br>
                        <select name="selectCandidatsSuppr">
                            <c:forEach var="candidat" items="${candidat}" >
                                <option value="${candidat.id}"><c:out value="${candidat.nom}">${candidat.nom}</c:out>
                                    <c:out value="${candidat.prenom}"> ${candidat.prenom}</c:out> </option>
                            </c:forEach>
                        </select>

                        <input type="submit" value="Confirmer">
                        <button type="button" onclick="document.getElementById('supprCandidat').style.display='none'">Annuler</button>
                    </div>
                </form>
            </div>

            <br>

            <!-- Affiche le tableau des Partis -->
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
            <br>

            <!-- Bouton ajouter/modifier/supprimer -->
            <div class="center">
                <button id="parti_modifierBtn" onclick="document.getElementById('modifParti').style.display='block'">Modifier</button>
                <button id="parti_supprimerBtn" onclick="document.getElementById('supprParti').style.display='block'">Supprimer</button>
                <button onclick="document.getElementById('ajoutParti').style.display='block'">Ajouter</button>
            </div>

            <!-- Popup ajouter parti -->
            <div id="ajoutParti" class="modal">
                <form class="modal-content" action="/VoteElectronique_war_exploded/candidatsAdmin" method="post">
                    <input class="hidden" type="text" name="action" value="ajouterParti"/>
                    <div class="form_container">
                        <label for="ajoutParti_nom">Nom</label><br>
                        <input type="text" id="ajoutParti_nom" name="nomParti"><br>
                        <label for="ajoutParti_siege">Siège</label><br>
                        <input type="text" id="ajoutParti_siege" name="siegeParti"><br>
                        <div class="center">
                            <button type="submit">Ajouter</button>
                            <button type="button" onclick="document.getElementById('ajoutParti').style.display='none'">Annuler</button>
                        </div>
                    </div>
                </form>
            </div>

            <!-- Modifier Parti -->
            <div id="modifParti" class="modal">
                <form class="modal-content" action="/VoteElectronique_war_exploded/candidatsAdmin" method="post">
                    <input class="hidden" type="text" name="action" value="modifierParti"/>
                    <div class="form_container">
                        <div>Selectionner le parti a modifier :</div><br>
                        <select name="selectPartiModify">
                            <c:forEach var="parti" items="${parti}" >
                                <option value="${parti.id}"><c:out value="${parti.nom}">${parti.nom}</c:out></option>
                            </c:forEach>
                        </select>
                        <label for="modifParti_nom">Nom</label><br>
                        <input type="text" id="modifParti_nom" name="modifParti_nom"><br>
                        <label for="modifParti_siege">Siege</label><br>
                        <input type="text" id="modifParti_siege" name="modifParti_siege"><br>
                        <br>
                        <div class="center">
                            <button type="submit">Enregistrer</button>
                            <button type="button" onclick="document.getElementById('modifParti').style.display='none'">Annuler</button>
                        </div>
                    </div>
                </form>
            </div>

            <br>
            <div class="center">
                <button class="boutonFin">Cloturer les votes</button>
            </div>
        </div>

        <!-- Suppression Parti -->
        <div id="supprParti" class="modal">
            <form class="modal-content" action="/VoteElectronique_war_exploded/candidatsAdmin" method="post">
                <input class="hidden" type="text" name="action" value="supprimerParti"/>
                <div class="form_container center">
                    <div>Sélectionner le candidat à supprimer :</div><br>
                    <select name="selectPartiSuppr">
                        <c:forEach var="parti" items="${parti}" >
                            <option value="${parti.id}"><c:out value="${parti.nom}">${parti.nom}</c:out> </option>
                        </c:forEach>
                    </select>

                    <input type="submit" value="Confirmer">
                    <button type="button" onclick="document.getElementById('supprParti').style.display='none'">Annuler</button>
                </div>
            </form>
        </div>

        <div id="loginPopup"></div>
        <div id="logoutPopup"></div>
    </body>
</html>