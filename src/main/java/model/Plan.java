package model;


import model.Horaire;
import dao.HibernateDAO;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Hart
 */
public class Plan {
    Scene scene;
    Date daty;

    public Plan(Scene scene, Date daty) {
        this.scene = scene;
        this.daty = daty;
    }

    public Plan() {
    }

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    
  
    public Date getDaty() {
        return daty;
    }

    public void setDaty(Date daty) {
        this.daty = daty;
    }
    public static ArrayList<Plan> getPlanning(HibernateDAO dao) throws Exception{
        ArrayList<Plan> res= new ArrayList<>();
        ArrayList listSceneOptim=dao.selectAll(new VSceneOptim());
        ArrayList listScene=dao.selectAll(new Scene());
        ArrayList sceneActeur=dao.selectAll(new SceneActeur());
        ArrayList horaire=dao.selectAll(new Horaire());
        
        
        for (Object object : listSceneOptim) {
            //date début calcul
            Date datePrediction=new Date();
            datePrediction.setDate(datePrediction.getDate()+1);
            Horaire heure=(Horaire) horaire.get(0);
            datePrediction.setHours(heure.getHeureDebut().getHours());
            datePrediction.setMinutes(heure.getHeureDebut().getMinutes());
            datePrediction.setSeconds(heure.getHeureDebut().getSeconds());
            
            VSceneOptim optimised=(VSceneOptim) object;
            Scene currScene=null;
            // get scene
            for (Object object1 : listScene) {
                Scene temp=(Scene) object1;
                if(temp.getIdscene().equals(optimised.getIdScene())){
                    currScene=temp;
                    System.out.println("scene tadiavina "+currScene.getIdscene());
                    break;
                }
            }
            // boolean test raha misy miasa ireo olona sy malalaka ny plateau
            boolean efaAo=true;
            while(efaAo){
                
            // parcourir efa ao saody efa nisy anaka le toerana
                efaAo=true;
                while(efaAo){
                    efaAo=false;
                    for (Plan re : res) {
                        if(re.getScene().getPlateau().equals(currScene.getPlateau())){
                            
                            Date finPrediction=new Date(datePrediction.getTime()+currScene.getDuree().getTime());
                            Date finOccupationPlateau=new Date(re.getDaty().getTime()+re.getScene().getDuree().getSeconds()); 
                            
                            finPrediction=new Date(datePrediction.getTime()+currScene.getDuree().getTime());
                            finPrediction.setHours(finPrediction.getHours()+3);
                            finOccupationPlateau=new Date(re.getDaty().getTime()+re.getScene().getDuree().getTime()); 
                            finOccupationPlateau.setHours(finOccupationPlateau.getHours()+3);
                                        
                            if(datePrediction.before(finOccupationPlateau) && re.getDaty().before(finPrediction)){
                                efaAo=true;
                                System.out.println("occupe "+re.getScene().getPlateau()+" a "+datePrediction.toLocaleString());
                                Date firavana=new Date(finOccupationPlateau.getTime());
                                firavana.setHours(heure.getHeureFin().getHours());
                                firavana.setMinutes(heure.getHeureFin().getMinutes());
                                if(finOccupationPlateau.before(firavana))
                                    datePrediction=finOccupationPlateau;
                                else{
                                    datePrediction.setDate(datePrediction.getDate()+1);
                                    datePrediction.setHours(heure.getHeureDebut().getHours());
                                    datePrediction.setMinutes(heure.getHeureDebut().getMinutes());
                                }
                                    
                                break;
                            }
                        }
                    }
                }

                if(!efaAo){
                    //get liste acteur
                    for (Object object1 : sceneActeur) {
                        SceneActeur temp=(SceneActeur) object1;
                        
                        if(temp.getScene().equals(currScene.getIdscene())){
                            System.out.println(temp.getActeur()+" joue dans "+temp.getScene());
                        //parcourir scene efa misy mitady raha efa nitourne le acteur
                            for (Plan plan : res) {
                                for (Object object2 : sceneActeur) {
                                    SceneActeur aVerifier=(SceneActeur) object2;
                                    if(aVerifier.getActeur().equals(temp.getActeur()) && aVerifier.getScene().equals(plan.getScene().getIdscene())){
                                        
                                        Date finPrediction=new Date(datePrediction.getTime()+currScene.getDuree().getTime());
                                        finPrediction.setHours(finPrediction.getHours()+3);
                                        Date finOccupationPlateau=new Date(plan.getDaty().getTime()+plan.getScene().getDuree().getTime()); 
                                        finOccupationPlateau.setHours(finOccupationPlateau.getHours()+3);
                                        
                                        System.out.println(datePrediction.toLocaleString()+" a "+finPrediction.toLocaleString());
                                        System.out.println(plan.getDaty().toLocaleString()+" a "+finOccupationPlateau.toLocaleString());
                                        if(datePrediction.before(finOccupationPlateau) && plan.getDaty().before(finPrediction)){
                                            efaAo=true;
                                            System.out.println("occupe "+aVerifier.getActeur()+" a "+datePrediction.toLocaleString());
                                            Date firavana=new Date(finOccupationPlateau.getTime());
                                            firavana.setHours(heure.getHeureFin().getHours());
                                            firavana.setMinutes(heure.getHeureFin().getMinutes());
                                            if(finOccupationPlateau.before(firavana))
                                                datePrediction=finOccupationPlateau;
                                            else{
                                                datePrediction.setDate(datePrediction.getDate()+1);
                                                datePrediction.setHours(heure.getHeureDebut().getHours());
                                                datePrediction.setMinutes(heure.getHeureDebut().getMinutes());
                                            }
                                            break;
                                        }
                                    }
                                }
                                if(efaAo)
                                    break;
                            }
                        }
                        if(efaAo)
                            break;
                    }
                    if(!efaAo){
                        System.out.println(currScene.getIdscene()+ " ajoute a "+datePrediction.toGMTString());
                        res.add(new Plan(currScene,datePrediction));
                    }
                }
            }
        }
        
        
        return res;
    }
}
