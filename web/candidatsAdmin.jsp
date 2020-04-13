<%--
  Created by IntelliJ IDEA.
  User: clapo
  Date: 10/04/2020
  Time: 17:08
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
        <h1>Liste des candidats</h1>

        <table>
            <tr>
                <th>Nom</th>
                <th>Prénom</th>
                <th colspan="2">Parti</th>
            </tr>
            <!-- VALEURS TEST -->
            <tr>
                <td>Jean</td>
                <td>Michel</td>
                <td>Parti des Michel</td>
                <td class="radio"><input type="radio" name="selectCandidat" onclick="
                document.getElementById('candidat_modifierBtn').disabled=false;
                document.getElementById('candidat_supprimerBtn').disabled=false"></td>
            </tr>
            <tr>
                <td>Jean</td>
                <td>Paul</td>
                <td>Parti des Paul</td>
                <td class="radio"><input type="radio" name="selectCandidat" onclick="
                document.getElementById('candidat_modifierBtn').disabled=false;
                document.getElementById('candidat_supprimerBtn').disabled=false"></td>
            </tr>
            <tr>
                <td>Jean</td>
                <td>Pierre</td>
                <td>Parti des Pierre</td>
                <td class="radio"><input type="radio" name="selectCandidat" onclick="
                document.getElementById('candidat_modifierBtn').disabled=false;
                document.getElementById('candidat_supprimerBtn').disabled=false"></td>
            </tr>
            <tr>
                <td>Jean</td>
                <td>Edouard</td>
                <td>Parti des Edouard</td>
                <td class="radio"><input type="radio" name="selectCandidat" onclick="
                document.getElementById('candidat_modifierBtn').disabled=false;
                document.getElementById('candidat_supprimerBtn').disabled=false"></td>
            </tr>
        </table>
        <br>

        <div class="center">
            <button id="candidat_modifierBtn" disabled onclick="document.getElementById('modifCandidat').style.display='block'">Modifier</button>
            <button id="candidat_supprimerBtn" disabled>Supprimer</button>
            <button onclick="document.getElementById('ajoutCandidat').style.display='block'">Ajouter</button>
        </div>

        <div id="ajoutCandidat" class="modal">
            <form class="modal-content">
                <div class="form_container">
                    <label for="ajoutCandidat_nom">Nom</label><br>
                    <input type="text" id="ajoutCandidat_nom"><br>
                    <label for="ajoutCandidat_prenom">Prénom</label><br>
                    <input type="text" id="ajoutCandidat_prenom"><br>
                    <label for="ajoutCandidat_parti">Parti</label><br>
                    <select id="ajoutCandidat_parti">
                        <!-- VALEURS TEST -->
                        <option value="michel">Parti des Michel</option>
                        <option value="paul">Parti des Paul</option>
                        <option value="pierre">Parti des Pierre</option>
                        <option value="edouard">Parti des Edouard</option>
                    </select><br>
                    <br>
                    <div class="center">
                        <button type="submit">Ajouter</button>
                        <button type="button" onclick="document.getElementById('ajoutCandidat').style.display='none'">Annuler</button>
                    </div>
                </div>
            </form>
        </div>

        <div id="modifCandidat" class="modal">
            <form class="modal-content">
                <div class="form_container">
                    <label for="modifCandidat_nom">Nom</label><br>
                    <input type="text" id="modifCandidat_nom"><br>
                    <label for="modifCandidat_prenom">Prénom</label><br>
                    <input type="text" id="modifCandidat_prenom"><br>
                    <label for="modifCandidat_parti">Parti</label><br>
                    <select id="modifCandidat_parti">
                        <!-- VALEURS TEST -->
                        <option value="michel">Parti des Michel</option>
                        <option value="paul">Parti des Paul</option>
                        <option value="pierre">Parti des Pierre</option>
                        <option value="edouard">Parti des Edouard</option>
                    </select><br>
                    <br>
                    <div class="center">
                        <button type="submit">Enregistrer</button>
                        <button type="button" onclick="document.getElementById('modifCandidat').style.display='none'">Annuler</button>
                    </div>
                </div>
            </form>
        </div>

        <h1>Liste des partis</h1>

        <table>
            <tr>
                <th>Nom</th>
                <th colspan="2">Nombre de candidats</th>
            </tr>
            <!-- VALEURS TEST -->
            <tr>
                <td>Parti des Michel</td>
                <td>1</td>
                <td class="radio"><input type="radio" name="selectParti" onclick="
                document.getElementById('parti_modifierBtn').disabled=false;
                document.getElementById('parti_supprimerBtn').disabled=false"></td>
            </tr>
            <tr>
                <td>Parti des Paul</td>
                <td>1</td>
                <td class="radio"><input type="radio" name="selectParti" onclick="
                document.getElementById('parti_modifierBtn').disabled=false;
                document.getElementById('parti_supprimerBtn').disabled=false"></td>
            </tr>
            <tr>
                <td>Parti des Pierre</td>
                <td>1</td>
                <td class="radio"><input type="radio" name="selectParti" onclick="
                document.getElementById('parti_modifierBtn').disabled=false;
                document.getElementById('parti_supprimerBtn').disabled=false"></td>
            </tr>
            <tr>
                <td>Parti des Edouard</td>
                <td>1</td>
                <td class="radio"><input type="radio" name="selectParti" onclick="
                document.getElementById('parti_modifierBtn').disabled=false;
                document.getElementById('parti_supprimerBtn').disabled=false"></td>
            </tr>
        </table>
        <br>

        <div class="center">
            <button id="parti_modifierBtn" disabled onclick="document.getElementById('modifParti').style.display='block'">Modifier</button>
            <button id="parti_supprimerBtn" disabled>Supprimer</button>
            <button onclick="document.getElementById('ajoutParti').style.display='block'">Ajouter</button>
        </div>

        <div id="ajoutParti" class="modal">
            <form class="modal-content">
                <div class="form_container">
                    <label for="ajoutParti_nom">Nom</label><br>
                    <input type="text" id="ajoutParti_nom"><br>
                    <br>
                    <div class="center">
                        <button type="submit">Ajouter</button>
                        <button type="button" onclick="document.getElementById('ajoutParti').style.display='none'">Annuler</button>
                    </div>
                </div>
            </form>
        </div>

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