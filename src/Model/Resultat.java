package Model;

public class Resultat {
    private int id;
    private Candidat candidat;
    private int nbVote;

    /** Constructors */
    public Resultat(){
        this.id = 0;
        this.candidat = new Candidat();
        this.nbVote = 0;
    }

    public Resultat(int id, Candidat candidat, int nbVote) {
        this.id = id;
        this.candidat = candidat;
        this.nbVote = nbVote;
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

    public int getNbVote() {
        return nbVote;
    }

    public void setNbVote(int nbVote) {
        this.nbVote = nbVote;
    }
}
