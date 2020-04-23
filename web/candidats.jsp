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
                        </tr>
                    </c:forEach>
                </tbody>

            </table>
            <br>

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
    </div>
</body>
</html>
