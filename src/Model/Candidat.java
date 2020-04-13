package Model;

public class Candidat {
    private int id;
    private int idParti;
    private String nom;
    private String prenom;

    /** Construors*/
    public Candidat() {
        this.id = 0;
        this.idParti = 0;
        this.nom = "";
        this.prenom = "";
    }

    public Candidat(int id, int idParti, String nom, String prenom) {
        this.id = id;
        this.idParti = idParti;
        this.nom = nom;
        this.prenom = prenom;
    }

    /** Getters and Setters */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdParti() {
        return idParti;
    }

    public void setIdParti(int idParti) {
        this.idParti = idParti;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
