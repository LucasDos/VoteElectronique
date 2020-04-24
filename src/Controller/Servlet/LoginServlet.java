package Controller.Servlet;

import Controller.DAO.VotantDAO;
import Model.Votant;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginServlet extends HttpServlet
{
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        try
        {
            if(login(req)) {
                String redirectURI = req.getParameter("redirectURI");

                if(redirectURI != null) {
                    res.sendRedirect(redirectURI);
                }
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

    private boolean login(HttpServletRequest req) throws SQLException
    {
        String pseudo = req.getParameter("pseudo");
        String mdp = req.getParameter("mdp");
        ArrayList<Votant> votants = VotantDAO.getAllVotant();

        boolean succes = false;

        for (Votant votant : votants)
        {
            if(pseudo.equals(votant.getPseudo()) && mdp.equals(votant.getMdp())) {
                HttpSession session = req.getSession(true);
                session.setAttribute("pseudo", pseudo);
                session.setAttribute("logged", Boolean.TRUE);
                succes = true;
            }
        }

        return succes;
    }
}
