package model;

import javax.persistence.*;

/**
 *
 * @author Hart
 */@Entity(name = "plateau")
public class Plateau {

    @Id
    @Column(name = "idplateau")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String idplateau;

    @Column(name = "nomplateau")
    private String nomplateau;

    @Column(name = "description")
    private String description;

    // getters and setters

    public String getIdplateau() {
        return idplateau;
    }

    public void setIdplateau(String idplateau) {
        this.idplateau = idplateau;
    }

    public String getNomplateau() {
        return nomplateau;
    }

    public void setNomplateau(String nomplateau) {
        this.nomplateau = nomplateau;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
