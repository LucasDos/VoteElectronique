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

public class CandidatAdminServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        try {
            // Récupère les candidats et partis de la BDD
            ArrayList<Candidat> candidats = CandidatDAO.getAllCandidat();
            ArrayList<Parti> partis = PartiDAO.getAllParti();

            req.setAttribute("candidat", candidats);
            req.setAttribute("parti", partis);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/candidatsAdmin.jsp").forward(req,res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");

        switch(req.getParameter("action")){
            case "ajouter":
                addCandidat(req, res);
                break;
        }

        res.sendRedirect("/VoteElectronique_war_exploded/candidatsAdmin");
    }

    public void addCandidat(HttpServletRequest req, HttpServletResponse res){
        String nomCandidat = req.getParameter("nomCandidat");
        String prenomCandidat = req.getParameter("prenomCandidat");
        int idParti = Integer.parseInt(req.getParameter("partiCandidat"));

        Candidat candidat = new Candidat(-1, idParti, nomCandidat, prenomCandidat);

        try {
            CandidatDAO.addCandidat(candidat);
            PrintWriter out = res.getWriter();
            out.println("Candidat ajouté avec succés !");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

}
