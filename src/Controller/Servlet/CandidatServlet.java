package Controller.Servlet;

import Controller.DAO.CandidatDAO;
import Controller.DAO.PartiDAO;
import Model.Candidat;
import Model.Parti;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

public class CandidatServlet extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");
        ArrayList<Candidat> candidats = null;
        ArrayList<Parti> partis = null;
        try {
            candidats = CandidatDAO.getAllCandidat();
            partis = PartiDAO.getAllParti();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        PrintWriter out = res.getWriter();
        out.println("<head>\n" +
                "    <title>Candidats</title>\n" +
                "    <link rel=\"stylesheet\" href=\"styles.css\">\n" +
                "</head>");

        // Création du tableau des candidats
        out.println("<html><body><h1>Liste des candidats</h1>");
        out.println("<table> <tr> <th>Nom</th> <th>Prénom</th> <th>Parti</th> </tr>");

        // Rempliassage du tableau
        for(Candidat candidat : candidats){
            out.println("<tr><td>" + candidat.getNom() + "</td> <td>" + candidat.getPrenom() + "</td>");

            for(Parti parti : partis) {
                if (candidat.getIdParti() == parti.getId()) {
                    out.println("<td>" + parti.getNom() + "</td></tr>");
                }
            }
        }
        out.println("</table>");

        //Création du tableau des partis
        out.println("</table><br>" +
                "<h1>Liste des partis</h1>" +
                "<table>" +
                "<tr>" +
                "<th>Nom</th>" +
                "<th>Nombre de candidats</th>" +
                "<th>Siège</>");

        for(Parti parti : partis) {
            out.println("<tr><td>" + parti.getNom() + "</td> <td>" + parti.getNbInscrit() + "</td> <td>" +  parti.getSiege() + "</td></tr>");
        }
        out.println("</table>");

        out.println("</body></html/>");

    }
}
