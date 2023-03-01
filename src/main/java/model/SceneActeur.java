package model;

/**
 *
 * @author Hart
 */
import javax.persistence.*;

@Entity(name = "scene_acteur")
public class SceneActeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "idacteur")
    private String acteur;

    @Column(name = "idscene")
    private String scene;

    // Constructorstters, and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActeur() {
        return acteur;
    }

    public void setActeur(String acteur) {
        this.acteur = acteur;
    }
    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }
    

}
