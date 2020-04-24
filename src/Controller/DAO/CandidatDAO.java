package Controller.DAO;

import Controller.Servlet.ResultatsServlet;
import Model.Candidat;
import Model.Parti;
import Model.Resultat;

import java.util.ArrayList;
import java.sql.*;

public class CandidatDAO {
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
        ResultSet rs = DBConnection.query("SELECT  * FROM candidat WHERE idCandidat = '" + ID + "';");
        rs.next();
        Candidat candidat = new Candidat(rs.getInt("idCandidat"), rs.getInt("idParti"), rs.getString("nom"), rs.getString("prenom"));

        return candidat;
    }

    /**
     * Ajoute un candidat a la BDD
     * @param candidat à ajouter
     */
    public static void addCandidat(Candidat candidat) throws SQLException {
        String sql = "INSERT INTO `candidat`(`idParti`, `nom`, `prenom`) " +
                "VALUES (" + candidat.getIdParti() + ",\"" + candidat.getNom() + "\",\"" + candidat.getPrenom() + "\");";

        // Ajoute un candidat à la BDD
        int exec = DBConnection.exec(sql);

        // Incrémente le nombre d'inscrit dans un parti
        Parti parti = PartiDAO.getPartiByID(candidat.getIdParti());
        PartiDAO.modifyNbInscrit(parti.getId(), parti.getNbInscrit()+1);

        // Ajout du candidat dans la table résultat
        DBConnection.exec("INSERT INTO `resultat`(`idCandidat`, `nbVote`) VALUES (" + candidat.getId() + ", 0)");
    }

    public static void removeCandidat(int idCandidat) throws SQLException {
        Candidat candidat = getCandidatByID(idCandidat);
        Parti parti = PartiDAO.getPartiByID(candidat.getIdParti());
        PartiDAO.modifyNbInscrit(parti.getId(), parti.getNbInscrit()-1);

        int exec = DBConnection.exec("DELETE FROM `candidat` WHERE `idCandidat`=" + idCandidat + ";");
    }

    public static void modifyCandidat(Candidat modif) throws SQLException {
        int exec = DBConnection.exec("UPDATE `candidat` SET " +
                "`idParti`="+ modif.getIdParti() +",`nom`='"+ modif.getNom() +"',`prenom`='"+ modif.getPrenom() +"' WHERE idCandidat=" + modif.getId()+";");
    }
}
