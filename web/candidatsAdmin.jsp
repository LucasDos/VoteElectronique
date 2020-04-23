<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Candidats Administration</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="main_container">
        <!-- Affiche le tableau des candidats -->
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
                    <td class="radio"><input type="radio" name="selectCandidat" onclick="
                            document.getElementById('candidat_modifierBtn').disabled=false;
                            document.getElementById('candidat_supprimerBtn').disabled=false">
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <!-- Bouton ajouter, supprimer et modifier -->
        <div class="center">
            <button id="candidat_modifierBtn" disabled onclick="document.getElementById('modifCandidat').style.display='block'">Modifier</button>
            <button id="candidat_supprimerBtn" disabled>Supprimer</button>
            <button onclick="document.getElementById('ajoutCandidat').style.display='block'">Ajouter</button>
        </div>

        <!-- Popup ajouter candidats -->
        <div id="ajoutCandidat" class="modal">
            <form class="modal-content">
                <div class="form_container">
                    <label for="ajoutCandidat_nom">Nom</label><br>
                    <input type="text" id="ajoutCandidat_nom"><br>
                    <label for="ajoutCandidat_prenom">Prénom</label><br>
                    <input type="text" id="ajoutCandidat_prenom"><br>
                    <label for="ajoutCandidat_parti">Parti</label><br>
                    <select id="ajoutCandidat_parti">
                        <c:forEach var="parti" items="${parti}">
                            <option value="${parti.id}"> <c:out value="${parti.nom}"> ${parti.nom} </c:out> </option>
                        </c:forEach>
                    </select><br>
                    <br>
                    <div class="center">
                        <button type="submit">Ajouter</button>
                        <button type="button" onclick="document.getElementById('ajoutCandidat').style.display='none'">Annuler</button>
                    </div>
                </div>
            </form>
        </div>

        <!-- Popup Modifier candidat -->
        <div id="modifCandidat" class="modal">
            <form class="modal-content">
                <div class="form_container">
                    <label for="modifCandidat_nom">Nom</label><br>
                    <input type="text" id="modifCandidat_nom" name="inpModif"><br>

                    <label for="modifCandidat_prenom">Prénom</label><br>
                    <input type="text" id="modifCandidat_prenom" name="inpModif"><br>

                    <label for="modifCandidat_parti">Parti</label><br>
                    <select id="modifCandidat_parti">
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

        <br>

        <!-- Affiche le tableau des Partis -->
        <h1>Liste des partis</h1>
        <table>
            <thead>
            <tr>
                <th>Nom</th>
                <th>Siège</th>
                <th>Nombre de candidats</th>
                <th>Sélectionner</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="parti" items="${parti}">
                <tr>
                    <td> <c:out value="${parti.nom}"> ${parti.nom} </c:out> </td>
                    <td> <c:out value="${parti.siege}"> ${parti.siege} </c:out> </td>
                    <td> <c:out value="${parti.nbInscrit}"> ${parti.nbInscrit} </c:out> </td>
                    <td class="radio"><input type="radio" name="selectCandidat" onclick="
                            document.getElementById('parti_modifierBtn').disabled=false;
                            document.getElementById('parti_supprimerBtn').disabled=false">
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <br>

        <!-- Bouton ajouter/modifier/supprimer -->
        <div class="center">
            <button id="parti_modifierBtn" disabled onclick="document.getElementById('modifParti').style.display='block'">Modifier</button>
            <button id="parti_supprimerBtn" disabled>Supprimer</button>
            <button onclick="document.getElementById('ajoutParti').style.display='block'">Ajouter</button>
        </div>

        <!-- Popup ajouter parti -->
        <div id="ajoutParti" class="modal">
            <form class="modal-content">
                <div class="form_container">
                    <label for="ajoutParti_nom">Nom</label><br>
                    <input type="text" id="ajoutParti_nom"><br>
                    <label for="ajoutParti_siege">Nom</label><br>
                    <input type="text" id="ajoutParti_siege"><br>
                    <div class="center">
                        <button type="submit">Ajouter</button>
                        <button type="button" onclick="document.getElementById('ajoutParti').style.display='none'">Annuler</button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <!-- Modifier Parti -->
    <div id="modifParti" class="modal">
        <form class="modal-content">
            <div class="form_container">
                <label for="modifParti_nom">Nom</label><br>
                <input type="text" id="modifParti_nom"><br>
                <br>
                <div class="center">
                    <button type="submit">Enregistrer</button>
                    <button type="button" onclick="document.getElementById('modifParti').style.display='none'">Annuler</button>
                </div>
            </div>
        </form>
    </div>
    </div>

</body>
</html>