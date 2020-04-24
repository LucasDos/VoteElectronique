package Controller.Servlet;

import Controller.DAO.CandidatDAO;
import Controller.DAO.PartiDAO;
import Controller.DAO.ResultatDAO;
import Controller.DAO.VotantDAO;
import Model.Candidat;
import Model.Parti;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class VoteServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            // Récupère les candidats et partis de la BDD
            ArrayList<Candidat> candidats = CandidatDAO.getAllCandidat();
            ArrayList<Parti> partis = PartiDAO.getAllParti();

            req.setAttribute("candidat", candidats);
            req.setAttribute("parti", partis);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("/vote.jsp").forward(req,res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        HttpSession session = req.getSession(false);
        int idCandidat = Integer.parseInt(req.getParameter("selectCandidat"));
        int idVotant = (int) session.getAttribute("id");


        try {
            ResultatDAO.addVote(idCandidat);
            VotantDAO.aVoterSwap(idVotant);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        res.sendRedirect("/VoteElectronique_war_exploded/candidats");
    }
}
