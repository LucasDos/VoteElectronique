package Controller;

import Model.Parti;

import java.sql.*;
import java.util.ArrayList;

public class PartiDAO {
    static Connection con;
    static Statement stmt;

    public ArrayList<Parti> getAllParti() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost/vote_electronique?serverTimezone=UTC", "root", "");
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT  * FROM parti;");

        ArrayList<Parti> partis = new ArrayList<Parti>();
        while(rs.next()){
            partis.add(new Parti(rs.getInt("idParti"), rs.getString("nom"),
                    rs.getString("siege"), rs.getInt("nbInscrit")));
        }

        con.close();
        stmt.close();

        return partis;
    }

    public Parti getPartiByID(int ID) throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost/vote_electronique?serverTimezone=UTC", "root", "");
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT  * FROM parti WHERE idParti = '" + ID +"';");
        Parti parti = new Parti(rs.getInt("idParti"), rs.getString("nom"), rs.getString("siege"), rs.getInt("nbInscrit"));

        con.close();
        stmt.close();

        return parti;
    }
}
