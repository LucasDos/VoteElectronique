<%--
  Created by IntelliJ IDEA.
  User: clapo
  Date: 13/04/2020
  Time: 16:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vote</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class = "main_container">
        <h1>Vote</h1>

        <table id="">
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
                <td class="radio"><input type="radio" name="voteCandidat" onclick="
                    document.getElementById('voteBtn').disabled=false"></td>
            </tr>
            <tr>
                <td>Jean</td>
                <td>Paul</td>
                <td>Parti des Paul</td>
                <td class="radio"><input type="radio" name="voteCandidat" onclick="
                    document.getElementById('voteBtn').disabled=false"></td>
            </tr>
            <tr>
                <td>Jean</td>
                <td>Pierre</td>
                <td>Parti des Pierre</td>
                <td class="radio"><input type="radio" name="voteCandidat" onclick="
                    document.getElementById('voteBtn').disabled=false"></td>
            </tr>
            <tr>
                <td>Jean</td>
                <td>Edouard</td>
                <td>Parti des Edouard</td>
                <td class="radio"><input type="radio" name="voteCandidat" onclick="
                    document.getElementById('voteBtn').disabled=false"></td>
            </tr>
        </table>
        <br>

        <div class="center">
            <button id="voteBtn" disabled onclick="document.getElementById('confirmVote').style.display='block'">Voter</button>
        </div>

        <div id="confirmVote" class="modal">
            <form class="modal-content">
                <div class="form_container">
                    <div class="center">
                        Vous êtes sur le point de voter pour :<br>
                        <br>
                        <b>Jean Michel</b><br>
                        <br>
                        <button type="submit">Confirmer</button>
                        <button onclick="document.getElementById('confirmVote').style.display='none'">Annuler</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</body>
</html>
