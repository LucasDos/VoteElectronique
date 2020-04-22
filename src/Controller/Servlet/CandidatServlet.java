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

        // Création d'un tableau
        out.println("<html><body> <table>");

        // Nom des colonnes
        out.println("<tr> <th>Nom</th> <th>Prénom</th> <th>Parti</th> </tr>");

        // Rempliassage du tableau
        for(Candidat candidat : candidats){
            out.println("<tr><td>" + candidat.getNom() + "</td> <td>" + candidat.getPrenom() + "</td>");

            for(Parti parti : partis) {
                if (candidat.getIdParti() == parti.getId()) {
                    out.println("<td>" + parti.getNom() + "</td></tr>");
                }
            }
        }

        out.println("</body></html/>");

    }
}
