package Controller.Servlet;

import Controller.DAO.CandidatDAO;
import Controller.DAO.PartiDAO;
import Controller.DAO.ResultatDAO;
import Model.Candidat;
import Model.Parti;
import Model.Resultat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResultatsServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        try {
            // Récupère les candidats et resultats de la BDD
            ArrayList<Candidat> candidats = CandidatDAO.getAllCandidat();
            ArrayList<Parti> partis = PartiDAO.getAllParti();
            ArrayList<Resultat> resultats = ResultatDAO.getAllResultat();

            req.setAttribute("candidat", candidats);
            req.setAttribute("parti", partis);
            req.setAttribute("resultat", resultats);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("/resultats.jsp").forward(req,res);
    }
}
