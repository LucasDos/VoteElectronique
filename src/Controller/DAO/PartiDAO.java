package Controller.DAO;

import Model.Parti;

import java.sql.*;
import java.util.ArrayList;

public class PartiDAO {
    static Connection con;
    static Statement stmt;

    /**
     * Recupère la liste de tout les partis
     * @return Liste des partis
     * @throws SQLException
     */
    public static ArrayList<Parti> getAllParti() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost/vote_electronique?serverTimezone=UTC", "root", "");
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT  * FROM parti;");

        ArrayList<Parti> parties = new ArrayList<Parti>();
        while(rs.next()){
            parties.add(new Parti(rs.getInt("idParti"), rs.getString("nom"),
                    rs.getString("siege"), rs.getInt("nbInscrit")));
        }

        con.close();
        stmt.close();

        return parties;
    }

    /**
     * Récupère un parti avec son id
     * @param ID : id du parti
     * @return Parti recherché
     * @throws SQLException
     */
    public static Parti getPartiByID(int ID) throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost/vote_electronique?serverTimezone=UTC", "root", "");
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT  * FROM parti WHERE idParti = '" + ID +"';");
        Parti parti = new Parti(rs.getInt("idParti"), rs.getString("nom"), rs.getString("siege"), rs.getInt("nbInscrit"));

        stmt.close();
        con.close();

        return parti;
    }
}
