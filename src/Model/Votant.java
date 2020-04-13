package Model;

import java.util.Date;

public class Votant {
    private int id;
    private String nom;
    private String prenom;
    private String ville;
    private Date dateNaissance;

    /** Constructors */
    public Votant(){
        this.id = 0;
        this.nom = "";
        this.prenom = "";
        this.ville = "";
        this.dateNaissance = new Date();
    }

    public Votant(int id, String nom, String prenom, String ville, Date dateNaissance) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.ville = ville;
        this.dateNaissance = dateNaissance;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
}
