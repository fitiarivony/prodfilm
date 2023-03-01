package model;

import java.time.Duration;
/**
 *
 * @author Hart
 */import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import org.hibernate.annotations.Immutable;

@Entity(name = "v_scene_optim")
@Immutable
public class VSceneOptim {
    @Id
    @Column(name = "idscene")
    private String idScene;

    @Column(name = "nbperso")
    private Integer nbPerso;

 
    // getters and setters

    public String getIdScene() {
        return idScene;
    }

    public void setIdScene(String idScene) {
        this.idScene = idScene;
    }

   
    public Integer getNbPerso() {
        return nbPerso;
    }

    public void setNbPerso(Integer nbPerso) {
        this.nbPerso = nbPerso;
    }

    

   
    

    
    
}
