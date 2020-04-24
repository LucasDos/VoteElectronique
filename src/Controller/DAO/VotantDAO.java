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
                    rs.getString("ville"), rs.getString("dateNaissance"), rs.getInt("aVoter"),
                    rs.getString("mdp")));
        }

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
                rs.getString("ville"), rs.getString("dateNaissance"), rs.getInt("aVoter"), rs.getString("mdp"));

        return votant;
    }

    public static void addVotant(Votant votant) throws SQLException {
        String SQL = "INSERT INTO `votant`(`nom`, `prenom`, `ville`, `dateNaissance`, `mdp`) " +
                "VALUES ('"+ votant.getNom() +"','"+ votant.getPrenom() +"','"+ votant.getVille() +"'" +
                ",'"+ votant.getDateNaissance() +"', '"+ votant.getMdp() +"');";

        int exec = DBConnection.exec(SQL);
    }

    public static void removeVotant(int idVotant) throws SQLException {
        int exec = DBConnection.exec("DELETE FROM `votant` WHERE idVotant=" + idVotant + ";");
    }
}
