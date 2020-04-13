package Model;

public class Parti {
    private int id;
    private String nom;
    private String siege;
    private int nbInscrit;

    /** Constructors */
    public Parti() {
        this.id = 0;
        this.nom = "";
        this.siege = "";
        this.nbInscrit = 0;
    }

    /** Getters and Setters */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSiege() {
        return siege;
    }

    public void setSiege(String siege) {
        this.siege = siege;
    }

    public int getNbInscrit() {
        return nbInscrit;
    }

    public void setNbInscrit(int nbInscrit) {
        this.nbInscrit = nbInscrit;
    }
}
