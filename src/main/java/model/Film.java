/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author FITIA ARIVONY
 */
@Entity(name="film")
public class Film implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idfilm")
    private String id;

     @Column(name="nomfilm")
    String nomfilm;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomfilm() {
        return nomfilm;
    }

    public void setNomfilm(String nomfilm) {
        this.nomfilm = nomfilm;
    }
    
    
}
