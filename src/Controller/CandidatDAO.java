package Controller;

import Model.Candidat;
import java.sql.*;
import java.util.ArrayList;

public class CandidatDAO {
    static Connection con;
    static Statement stmt;

    public ArrayList<Candidat> getAllCandidat() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost/vote_electronique?serverTimezone=UTC", "root", "");
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT * FROM candidat;");

        ArrayList<Candidat> candidats = new ArrayList<Candidat>();
        while(rs.next()){
            candidats.add(new Candidat(rs.getInt("idCandidat"), rs.getInt("idParti"),
                    rs.getString("nom"), rs.getString("prenom")));
        }

        con.close();
        stmt.close();

        return candidats;
    }

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
