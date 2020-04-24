package Controller.Servlet;

import Controller.DAO.VotantDAO;
import Model.Votant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

public class VotantServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        try {
            // Récupère les votant de la BDD
            ArrayList<Votant> votants = VotantDAO.getAllVotant();

            req.setAttribute("votant", votants);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        req.getRequestDispatcher("/votantsAdmin.jsp").forward(req,res);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        res.setContentType("text/html");

        switch(req.getParameter("action")){
            case "ajouterVotant":
                addVotant(req, res);
                break;
            case "supprimerVotant":
                removeVotant(req, res);
                break;
        }

        res.sendRedirect("/VoteElectronique_war_exploded/votants");
    }

    public void addVotant(HttpServletRequest req, HttpServletResponse res){
        Votant votant = new Votant(-1, req.getParameter("nomVotant"), req.getParameter("prenomVotant"), req.getParameter("villeVotant"),
                req.getParameter("dateNaissVotant"), 0,  req.getParameter("mdpVotant"));

        try {
            VotantDAO.addVotant(votant);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeVotant(HttpServletRequest req, HttpServletResponse res){
        int idVotant = Integer.parseInt(req.getParameter("selectVotantSuppr"));
        try {
            VotantDAO.removeVotant(idVotant);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
