package Controller.DAO;

import Model.Candidat;
import java.util.ArrayList;
import java.sql.*;

public class CandidatDAO {
    static Connection con;
    static Statement stmt;

    /**
     * Recupère la liste de tout les candidats
     * @return Liste des candidats
     * @throws SQLException
     */
    public static ArrayList<Candidat> getAllCandidat() throws SQLException {
        ResultSet rs = DBConnection.query("SELECT * FROM candidat;");

        ArrayList<Candidat> candidats = new ArrayList<Candidat>();
        while(rs.next()){
            candidats.add(new Candidat(rs.getInt("idCandidat"), rs.getInt("idParti"),
                    rs.getString("nom"), rs.getString("prenom")));
        }

        return candidats;
    }

    /**
     * Recupère un candidat avec son ID
     * @param ID : id du candidat
     * @return Candidat recherché
     * @throws SQLException
     */
    public static Candidat getCandidatByID(int ID) throws SQLException{
        con = DriverManager.getConnection("jdbc:mysql://localhost:8080/vote_electronique?serverTimezone=UTC", "root", "");
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT  * FROM candidat WHERE idCandidat = '" + ID + "';");
        Candidat candidat = new Candidat(rs.getInt("idCandidat"), rs.getInt("idParti"), rs.getString("nom"), rs.getString("prenom"));

        con.close();
        stmt.close();

        return candidat;
    }
}
