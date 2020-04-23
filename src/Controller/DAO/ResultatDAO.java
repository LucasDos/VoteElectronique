package Controller.DAO;

import Model.Resultat;

import java.sql.*;
import java.util.ArrayList;

public class ResultatDAO {

    /**
     * Récupère la liste de tout les résultats par candidat
     * @return Liste de tout les résultats
     * @throws SQLException
     */
    public static ArrayList<Resultat> getAllResultat() throws SQLException {
        ResultSet rs = DBConnection.query("SELECT  * FROM resultat;");

        ArrayList<Resultat> resultats = new ArrayList<Resultat>();
        while(rs.next()){
            resultats.add(new Resultat(rs.getInt("idResultat"), rs.getInt("idCandidat"), rs.getInt("nbVote")));
        }

        DBConnection.closeConnection(rs);

        return resultats;
    }

    /**
     * Récupère les resultats d'un candidat
     * @param idCandidat : id du candidat dont on veut les résultats
     * @return Résultat du candidat
     * @throws SQLException
     */
    public Resultat getResultatByCandidat(int idCandidat) throws SQLException {
        ResultSet rs = DBConnection.query("SELECT  * FROM resultat WHERE idCandidat='" + idCandidat + "';");
        Resultat resultat = new Resultat(rs.getInt("idResultat"), rs.getInt("idCandidat"),
                rs.getInt("nbVote"));

        DBConnection.closeConnection(rs);
        return resultat;
    }

    public void addVote(int idCandidat) throws SQLException {
        ResultSet rs = DBConnection.query("SELECT nbVote FROM resultat WHERE idCandidat=" + idCandidat);
        int nbVote = rs.getInt("nbVote");
        rs.close();

        int res = DBConnection.exec("UPDATE `resultat` SET `nbVote`=" + nbVote+1 + " WHERE idCandidat=" + idCandidat);
    }
}
