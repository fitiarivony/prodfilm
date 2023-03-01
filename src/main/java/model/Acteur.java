package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;

/**
 *
 * @author Hart
 */
@Entity(name = "acteur")
public class Acteur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idacteur")
    private String idacteur;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "datenaissance")
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datenaissance;

    public String getIdacteur() {
        return idacteur;
    }

    public void setIdacteur(String idacteur) {
        this.idacteur = idacteur;
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

    public Date getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(Date datenaissance) {
        this.datenaissance = datenaissance;
    }

    
}
