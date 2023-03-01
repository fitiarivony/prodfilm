package model;

import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Hart
 */
@Entity(name = "horaire")
public class Horaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idhoraire")
    private String idhoraire;

    @Column(name = "ouverture")
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date heureDebut;

    @Temporal(javax.persistence.TemporalType.TIME)
    @Column(name = "fermeture")
    private Date heureFin;

    public String getIdhoraire() {
        return idhoraire;
    }

    public void setIdhoraire(String idhoraire) {
        this.idhoraire = idhoraire;
    }

    

    public Date getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(Date heureDebut) {
        this.heureDebut = heureDebut;
    }

    public Date getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(Date heureFin) {
        this.heureFin = heureFin;
    }
    
    
}
