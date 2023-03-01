/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author FITIA ARIVONY
 */
@Entity(name="action")
public class Action{
    @Column(name="idaction")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    String idaction;
    @Column(name="evenement")
    String evenement;
    @Column(name="ordre")
    Integer ordre;
    @Column(name="idscene")
    String idscene;
    @Column(name="idpersonnage")
    String idpersonnage;
    @Column(name="expression")
    String expression;

    public String getIdaction() {
        return idaction;
    }

    public void setIdaction(String idaction) {
        this.idaction = idaction;
    }

    public String getEvenement() {
        return evenement;
    }

    public void setEvenement(String evenement) {
        this.evenement = evenement;
    }

    public Integer getOrdre() {
        return ordre;
    }

    public void setOrdre(Integer ordre) {
        this.ordre = ordre;
    }

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

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        if(expression!=null && expression.equals(""))this.expression=null;
        this.expression = expression;
    }

    @Override
    public String toString() {
        return "Action{" + "idaction=" + idaction + ", evenement=" + evenement + ", ordre=" + ordre + ", idscene=" + idscene + ", idpersonnage=" + idpersonnage + ", expression=" + expression + '}';
    }
    
}
