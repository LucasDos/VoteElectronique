package Controller.DAO;

import Model.Candidat;
import Model.Resultat;
import Model.Votant;
import Model.Vote;

import java.sql.*;
import java.util.ArrayList;

public class VoteDAO {
    /**
     * Récupère la liste de tout les votes
     * @return Liste de tout les votes
     * @throws SQLException
     */
    public ArrayList<Vote> getAllVote() throws SQLException {
        ResultSet rs = DBConnection.query("SELECT  * FROM vote;");

        ArrayList<Vote> votes = new ArrayList<Vote>();
        while(rs.next()){
            votes.add(new Vote(rs.getInt("idVote"), rs.getInt("idCandidat"), rs.getInt("idVotant")));
        }

        DBConnection.closeConnection(rs);
        return votes;
    }

    public void addVote(Votant votant, Candidat candidat) throws SQLException {
        if(votant.getaVoter() == 0){
            DBConnection.exec("INSERT INTO `vote`(`idCandidat`, `idVotant`) VALUES (" + candidat.getId() + "," + votant.getId() + ")");
            DBConnection.exec("UPDATE `votant` SET `aVoter`=1 WHERE idVotant=" + votant.getId());
            ResultatDAO res = new ResultatDAO();
            res.addVote(candidat.getId());
        }
        else{
            //popup déjà voté !
        }
    }
}
