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
import java.util.Objects;

public class LoginServlet extends HttpServlet
{
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException
    {
        try {
            String redirectURI = req.getParameter("redirectURI");
            String logType = req.getParameter("logType");

            if (logType.equals("in")) {
                HttpSession session = req.getSession(true);
                if (req.getParameter("pseudo").equals("Admin.Admin") && req.getParameter("mdp").equals("password")) {
                    session.setAttribute("pseudo", req.getParameter("pseudo"));
                    session.setAttribute("logged", Boolean.TRUE);
                    session.setAttribute("wrongLogin", Boolean.FALSE);
                    session.setAttribute("admin", Boolean.TRUE);
                    res.sendRedirect("http://localhost:8081/VoteElectronique_war_exploded/candidatsAdmin");
                } else if (login(req)) {
                    session.setAttribute("pseudo", req.getParameter("pseudo"));
                    session.setAttribute("logged", Boolean.TRUE);
                    session.setAttribute("wrongLogin", Boolean.FALSE);
                    session.setAttribute("admin", Boolean.FALSE);
                    res.sendRedirect(Objects.requireNonNullElse(redirectURI, "http://localhost:8081/VoteElectronique_war_exploded/candidats"));
                } else {
                    session.setAttribute("pseudo", "");
                    session.setAttribute("logged", Boolean.FALSE);
                    session.setAttribute("wrongLogin", Boolean.TRUE);
                    session.setAttribute("admin", Boolean.FALSE);
                    res.sendRedirect("http://localhost:8081/VoteElectronique_war_exploded/candidats");
                }
            } else if (logType.equals("out")) {
                HttpSession session = req.getSession();
                session.invalidate();
                res.sendRedirect(Objects.requireNonNullElse(redirectURI, "http://localhost:8081/VoteElectronique_war_exploded/candidats"));
            }
        } catch (SQLException e) {
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
                succes = true;
            }
        }

        return succes;
    }
}
