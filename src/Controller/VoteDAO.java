package Controller;

import Model.Vote;

import java.sql.*;
import java.util.ArrayList;

public class VoteDAO {
    static Connection con;
    static Statement stmt;

    /**
     * Récupère la liste de tout les votes
     * @return Liste de tout les votes
     * @throws SQLException
     */
    public ArrayList<Vote> getAllVote() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost/vote_electronique?serverTimezone=UTC", "root", "");
        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = stmt.executeQuery("SELECT  * FROM vote;");

        ArrayList<Vote> votes = new ArrayList<Vote>();
        while(rs.next()){
            votes.add(new Vote(rs.getInt("idVote"), rs.getInt("idCandidat"), rs.getInt("idVotant")));
        }

        stmt.close();
        con.close();

        return votes;
    }
}
