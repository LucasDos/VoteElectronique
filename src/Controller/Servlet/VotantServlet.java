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
}
