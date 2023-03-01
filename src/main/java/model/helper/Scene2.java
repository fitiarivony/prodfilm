/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.helper;

import com.vladmihalcea.hibernate.type.interval.PostgreSQLIntervalType;
import java.io.Serializable;
import java.time.Duration;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

/**
 *
 * @author FITIA ARIVONY
 */
@Entity(name = "scene")
@TypeDefs({@TypeDef(name="pgsql_interval", typeClass=Duration.class)})
public class Scene2 implements Serializable {
    @Id
    @Column(name = "idscene")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idscene;

    
    @Column(name = "idplateau")
    private String plateau;

    
    @Column(name = "idfilm")
    private String film;

    @Column(name = "nom")
    private String nom;

    
   @Column(name = "duree")
    @Type(type = "com.vladmihalcea.hibernate.type.interval.PostgreSQLIntervalType")
    private Duration duree;

    public String getIdscene() {
        return idscene;
    }

    public void setIdscene(String idscene) {
        this.idscene = idscene;
    }

    public String getPlateau() {
        return plateau;
    }

    public void setPlateau(String plateau) {
        this.plateau = plateau;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Duration getDuree() {
        return duree;
    }

    public void setDuree(Duration duree) {
        this.duree = duree;
    }



    @Override
    public String toString() {
        return "Scene{" + "idscene=" + idscene + ", plateau=" + plateau + ", film=" + film + ", nom=" + nom + ", duree=" + duree + '}';
    }
}
