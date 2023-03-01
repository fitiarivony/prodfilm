package model;

import java.io.Serializable;
import java.time.Duration;
import java.util.Date;
import javax.persistence.*;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
/**
 *
 * @author Hart
 */
@Entity(name = "V_scene")
@TypeDefs({@TypeDef(name="pgsql_interval", typeClass=Duration.class)})
public class Scene implements Serializable {

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
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date duree;

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

    public Date getDuree() {
        return duree;
    }

    public void setDuree(Date duree) {
        this.duree = duree;
    }

    @Override
    public String toString() {
        return "Scene{" + "idscene=" + idscene + ", plateau=" + plateau + ", film=" + film + ", nom=" + nom + ", duree=" + duree + '}';
    }

    
    
    
}
