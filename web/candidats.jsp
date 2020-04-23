<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Candidats</title>
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
                        <th>Parti</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="candidat" items="${candidats}">
                        <tr>
                            <td>
                                <c:out value="${candidats.getNom}">
                                    ${candidats.getNom}
                                </c:out>
                            </td>
                            <td>
                                <c:out value="${candidats.getPrenom}">
                                    ${candidats.getPrenom()}
                                </c:out>
                            </td>
                            <td>
                                <c:out value="${candidats.getParti()}">
                                    ${candidats.getParti()}
                                </c:out>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>

            </table>
            <br>

            <h1>Liste des partis</h1>

            <table>
                <tr>
                    <th>Nom</th>
                    <th>Nombre de candidats</th>
                </tr>
                <!-- VALEURS TEST -->
                <tr>
                    <td>Parti des Michel</td>
                    <td>1</td>
                </tr>
                <tr>
                    <td>Parti des Paul</td>
                    <td>1</td>
                </tr>
                <tr>
                    <td>Parti des Pierre</td>
                    <td>1</td>
                </tr>
                <tr>
                    <td>Parti des Edouard</td>
                    <td>1</td>
                </tr>
            </table>
    </div>
</body>
</html>
