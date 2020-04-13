package Controller;

import Model.Candidat;
import java.sql.*;
import java.util.ArrayList;

public class CandidatDAO {
    static Connection con;
    static Statement stmt;

    /**
     * Recupère la liste de tout les candidats
     * @return Liste des candidats
     * @throws SQLException
     */
    public ArrayList<Candidat> getAllCandidat() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost/vote_electronique?serverTimezone=UTC", "root", "");
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT * FROM candidat;");

        ArrayList<Candidat> candidats = new ArrayList<Candidat>();
        while(rs.next()){
            candidats.add(new Candidat(rs.getInt("idCandidat"), rs.getInt("idParti"),
                    rs.getString("nom"), rs.getString("prenom")));
        }

        stmt.close();
        con.close();

        return candidats;
    }

    /**
     * Recupère un candidat avec son ID
     * @param ID : id du candidat
     * @return Candidat recherché
     * @throws SQLException
     */
    public Candidat getCandidatByID(int ID) throws SQLException{
        con = DriverManager.getConnection("jdbc:mysql://localhost/vote_electronique?serverTimezone=UTC", "root", "");
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT  * FROM candidat WHERE idCandidat = '" + ID + "';");
        Candidat candidat = new Candidat(rs.getInt("idCandidat"), rs.getInt("idParti"), rs.getString("nom"), rs.getString("prenom"));

        con.close();
        stmt.close();

        return candidat;
    }
}
