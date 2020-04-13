package Model;

public class Resultat {
    private int id;
    private int idCandidat;
    private int nbVote;

    /** Constructors */
    public Resultat(){
        this.id = 0;
        this.idCandidat = 0;
        this.nbVote = 0;
    }

    public Resultat(int id, int idCandidat, int nbVote) {
        this.id = id;
        this.idCandidat = idCandidat;
        this.nbVote = nbVote;
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

    public int getNbVote() {
        return nbVote;
    }

    public void setNbVote(int nbVote) {
        this.nbVote = nbVote;
    }
}
