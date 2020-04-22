package Controller.DAO;

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

        return votes;
    }
}
