package model;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Hart
 */@Entity(name = "personnage")
public class Personnage {

    @Id
    @Column(name = "idpersonnage")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idpersonnage;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "datenaissance")
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datenaissance;

    
    @Column(name = "idacteur")
    private String acteur;

    
    @Column(name = "idfilm")
    private String film;

    // getters and setters

    public String getIdpersonnage() {
        return idpersonnage;
    }

    public void setIdpersonnage(String idpersonnage) {
        this.idpersonnage = idpersonnage;
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

    public String getActeur() {
        return acteur;
    }

    public void setActeur(String acteur) {
        this.acteur = acteur;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    @Override
    public String toString() {
        return "Personnage{" + "idpersonnage=" + idpersonnage + ", nom=" + nom + ", prenom=" + prenom + ", datenaissance=" + datenaissance + ", acteur=" + acteur + ", film=" + film + '}';
    }
    
}

