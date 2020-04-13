package Model;

public class Vote {
    private int id;
    private int idCandidat;
    private int idVotant;

    /** Constructors */
    public Vote(){
        this.id = 0;
        this.idCandidat = 0;
        this.idVotant = 0;
    }

    public Vote(int id, int idCandidat, int idVotant) {
        this.id = id;
        this.idCandidat = idCandidat;
        this.idVotant = idVotant;
    }

    /** Getters and Setters */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCandidat() {
        return idCandidat;
    }

    public void setIdCandidat(int idCandidat) {
        this.idCandidat = idCandidat;
    }

    public int getIdVotant() {
        return idVotant;
    }

    public void setIdVotant(int idVotant) {
        this.idVotant = idVotant;
    }
}
