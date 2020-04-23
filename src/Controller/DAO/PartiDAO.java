package Controller.DAO;

import Model.Parti;

import java.sql.*;
import java.util.ArrayList;

public class PartiDAO {

    /**
     * Recupère la liste de tout les partis
     * @return Liste des partis
     * @throws SQLException
     */
    public static ArrayList<Parti> getAllParti() throws SQLException {
        ResultSet rs = DBConnection.query("SELECT  * FROM parti;");

        ArrayList<Parti> parties = new ArrayList<Parti>();
        while(rs.next()){
            parties.add(new Parti(rs.getInt("idParti"), rs.getString("nom"),
                    rs.getString("siege"), rs.getInt("nbInscrit")));
        }

        return parties;
    }

    /**
     * Récupère un parti avec son id
     * @param ID : id du parti
     * @return Parti recherché
     * @throws SQLException
     */
    public static Parti getPartiByID(int ID) throws SQLException {
        ResultSet rs = DBConnection.query("SELECT  * FROM parti WHERE idParti = '" + ID +"';");

        Parti parti = new Parti(rs.getInt("idParti"), rs.getString("nom"),
                rs.getString("siege"), rs.getInt("nbInscrit"));
        DBConnection.closeConnection(rs);

        return parti;
    }

    public static void addParti(Parti parti) throws SQLException {
        String sql = "INSERT INTO `parti`(`nom`, `siege`, `nbInscrit`) VALUES (\""
                + parti.getNom() + "\",\"" + parti.getSiege() + "\"," + parti.getNbInscrit() +");";

        int exec = DBConnection.exec(sql);
    }

    public static void modifyNbInscrit(int id, int nbInscrit) throws SQLException {
        int exec = DBConnection.exec("UPDATE `parti` SET `nbInscrit`=" + nbInscrit + " WHERE idParti=" + id +");");
    }
}
