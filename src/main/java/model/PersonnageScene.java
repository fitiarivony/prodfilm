package model;

/**
 *
 * @author Hart
 */
import javax.persistence.*;

@Entity(name = "personnage_scene")
public class PersonnageScene {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "idpersonnage")
    private String personnage;

    @Column(name = "idscene")
    private String scene;

    // Constructorstters, and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersonnage() {
        return personnage;
    }

    public void setPersonnage(String personnage) {
        this.personnage = personnage;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }
    

}
