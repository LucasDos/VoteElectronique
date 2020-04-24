package Controller.DAO;

import Model.Votant;

import java.sql.*;
import java.util.ArrayList;

public class VotantDAO {
    /**
     * Récupère la liste de tout les votants
     * @return Liste de tout les votants
     * @throws SQLException
     */
    public static ArrayList<Votant> getAllVotant() throws SQLException {
        ResultSet rs = DBConnection.query("SELECT  * FROM votant;");
        ArrayList<Votant> votants = new ArrayList<Votant>();
        while(rs.next()){
            votants.add(new Votant(rs.getInt("idVotant"), rs.getString("nom"), rs.getString("prenom"),
                    rs.getString("ville"), rs.getDate("dateNaissance"), rs.getInt("aVoter"), rs.getString("mdp")));
        }

        DBConnection.closeConnection(rs);
        return votants;
    }

    /**
     * Récupère un votant
     * @param idVotant : id du votant
     * @return Votant recherché
     * @throws SQLException
     */
    public Votant getVotantByID(int idVotant) throws SQLException {
        ResultSet rs =DBConnection.query("SELECT  * FROM votant WHERE idVotant='" + idVotant + "';");
        Votant votant = new Votant(rs.getInt("idVotant"), rs.getString("nom"), rs.getString("prenom"),
                rs.getString("ville"), rs.getDate("dateNaissance"), rs.getInt("aVoter"), rs.getString("mdp"));

        DBConnection.closeConnection(rs);
        return votant;
    }
}
