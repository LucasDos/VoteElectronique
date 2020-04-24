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
            case "ajouterCandidat":
                addCandidat(req, res);
                break;
            case "modifierCandidat":
                modifyCandidat(req, res);
                break;
            case "supprimerCandidat":
                removeCandidat(req, res);
                break;
            case "ajouterParti":
                addParti(req, res);
                break;
            case "modifierParti":
                modifyParti(req, res);
                break;
            case "supprimerParti":
                removeParti(req, res);
                break;

        }

        res.sendRedirect("/VoteElectronique_war_exploded/candidatsAdmin");
    }

    public void addCandidat(HttpServletRequest req, HttpServletResponse res){
        Candidat candidat = new Candidat(-1, Integer.parseInt(req.getParameter("partiCandidat")),
                req.getParameter("nomCandidat"), req.getParameter("prenomCandidat"));

        try {
            CandidatDAO.addCandidat(candidat);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifyCandidat(HttpServletRequest req, HttpServletResponse res){
        int idCandidat = Integer.parseInt(req.getParameter("selectCandidatsModify"));

        try {
            Candidat newCandidat = CandidatDAO.getCandidatByID(idCandidat);
            if(req.getParameter("selectPartiModif") != "") { newCandidat.setIdParti(Integer.parseInt(req.getParameter("selectPartiModif"))); }
            if(req.getParameter("modifCandidat_nom") != "") { newCandidat.setNom(req.getParameter("modifCandidat_nom")); }
            if(req.getParameter("modifCandidat_prenom") != "") { newCandidat.setPrenom(req.getParameter("modifCandidat_prenom")); }

            CandidatDAO.modifyCandidat(newCandidat);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeCandidat(HttpServletRequest req, HttpServletResponse res) {
        int idCandidat = Integer.parseInt(req.getParameter("selectCandidatsSuppr"));
        System.out.println(req.getParameter("selectCandidatsSuppr"));
        try {
            CandidatDAO.removeCandidat(idCandidat);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addParti(HttpServletRequest req, HttpServletResponse res){
        Parti parti = new Parti(-1, req.getParameter("nomParti"),
                req.getParameter("siegeParti"), 0);

        try {
            PartiDAO.addParti(parti);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifyParti(HttpServletRequest req, HttpServletResponse res){
        int idParti = Integer.parseInt(req.getParameter("selectPartiModify"));

        try {
            Parti newParti = PartiDAO.getPartiByID(idParti);
            if(req.getParameter("modifParti_nom") != ""){
                newParti.setNom(req.getParameter("modifParti_nom"));
            }
            if(req.getParameter("modifParti_siege") != ""){
                newParti.setSiege(req.getParameter("modifParti_siege"));
            }
            PartiDAO.modifyParti(newParti);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeParti(HttpServletRequest req, HttpServletResponse res){
        int idParti = Integer.parseInt(req.getParameter("selectPartiSuppr"));

        try {
            PartiDAO.removeParti(idParti);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
