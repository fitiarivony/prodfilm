/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author FITIA ARIVONY
 */
@Entity(name="perso_scene")
public class Perso_scene {
    
    @Column(name="idscene")
    String idscene;
    @Id
    @Column(name="idpersonnage")
    String idpersonnage;
    @Column(name="nom")
     String nomscene;
    @Column(name="nompersonnage")
    String nomperso;
    @Column(name="prenom")
    String prenom;
    @Column(name="datenaissance")
    Date datenaissance;
//    @Column(name="idacteur")
//    String idacteur;
//    String idplateau;
//    String idfilm;

    public String getIdscene() {
        return idscene;
    }

    public void setIdscene(String idscene) {
        this.idscene = idscene;
    }

    public String getIdpersonnage() {
        return idpersonnage;
    }

    public void setIdpersonnage(String idpersonnage) {
        this.idpersonnage = idpersonnage;
    }

    public String getNomscene() {
        return nomscene;
    }

    public void setNomscene(String nomscene) {
        this.nomscene = nomscene;
    }

    public String getNomperso() {
        return nomperso;
    }

    public void setNomperso(String nomperso) {
        this.nomperso = nomperso;
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

    @Override
    public String toString() {
        return "Perso_scene{" + "idscene=" + idscene + ", idpersonnage=" + idpersonnage + ", nomscene=" + nomscene + ", nomperso=" + nomperso + ", prenom=" + prenom + ", datenaissance=" + datenaissance + '}';
    }
    
    
}
