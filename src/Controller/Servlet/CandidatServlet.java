package Controller.Servlet;

import Controller.DAO.CandidatDAO;
import Controller.DAO.PartiDAO;
import Model.Candidat;
import Model.Parti;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

public class CandidatServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        //test
        HttpSession session = req.getSession(false);
        if(session.getAttribute("logged") == Boolean.TRUE) {
            System.out.println(session.getAttribute("pseudo"));
        } else {
            System.out.println("non connecté");
        }

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

        req.getRequestDispatcher("/candidats.jsp").forward(req,res);
    }
}
