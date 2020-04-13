package Controller;

import Model.Resultat;

import java.sql.*;
import java.util.ArrayList;

public class ResultatDAO {
    static Connection con;
    static Statement stmt;

    /**
     * Récupère la liste de tout les résultats par candidat
     * @return Liste de tout les résultats
     * @throws SQLException
     */
    public ArrayList<Resultat> getAllResultat() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost/vote_electronique?serverTimezone=UTC", "root", "");
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT  * FROM resultat;");

        ArrayList<Resultat> resultats = new ArrayList<Resultat>();
        while(rs.next()){
            resultats.add(new Resultat(rs.getInt("idResultat"), rs.getInt("idCandidat"), rs.getInt("nbVote")));
        }

        stmt.close();
        con.close();

        return resultats;
    }

    /**
     * Récupère les resultats d'un candidat
     * @param idCandidat : id du candidat dont on veut les résultats
     * @return Résultat du candidat
     * @throws SQLException
     */
    public Resultat getResultatByCandidat(int idCandidat) throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost/vote_electronique?serverTimezone=UTC", "root", "");
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT  * FROM resultat WHERE idCandidat='" + idCandidat + "';");

        Resultat resultat = new Resultat(rs.getInt("idResultat"), rs.getInt("idCandidat"), rs.getInt("nbVote"));

        stmt.close();
        con.close();

        return resultat;
    }

}
