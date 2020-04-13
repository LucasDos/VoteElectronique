package Controller;

import Model.Votant;

import java.sql.*;
import java.util.ArrayList;

public class VotantDAO {
    static Connection con;
    static Statement stmt;

    /**
     * Récupère la liste de tout les votants
     * @return Liste de tout les votants
     * @throws SQLException
     */
    public ArrayList<Votant> getAllVotant() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost/vote_electronique?serverTimezone=UTC", "root", "");
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT  * FROM votant;");

        ArrayList<Votant> votants = new ArrayList<Votant>();
        while(rs.next()){
            votants.add(new Votant(rs.getInt("idVotant"), rs.getString("nom"), rs.getString("prenom"),
                    rs.getString("ville"), rs.getDate("dateNaissance"), rs.getInt("aVoter")));
        }

        stmt.close();
        con.close();

        return votants;
    }

    /**
     * Récupère un votant
     * @param idVotant : id du votant
     * @return Votant recherché
     * @throws SQLException
     */
    public Votant getVotantByID(int idVotant) throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost/vote_electronique?serverTimezone=UTC", "root", "");
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT  * FROM votant WHERE idVotant='" + idVotant + "';");

        Votant votant = new Votant(rs.getInt("idVotant"), rs.getString("nom"), rs.getString("prenom"),
                rs.getString("ville"), rs.getDate("dateNaissance"), rs.getInt("aVoter"));

        stmt.close();
        con.close();

        return votant;
    }
}
