package Model;

public class Vote {
    private int id;
    private Candidat candidat;
    private Votant votant;

    /** Constructors */
    public Vote(){
        this.id = 0;
        this.candidat = new Candidat();
        this.votant = new Votant();
    }

    public Vote(int id, Candidat candidat, Votant votant) {
        this.id = id;
        this.candidat = candidat;
        this.votant = votant;
    }

    /** Getters and Setters */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

    public Votant getVotant() {
        return votant;
    }

    public void setVotant(Votant votant) {
        this.votant = votant;
    }
}
