/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Perso_scene;
import model.Personnage;
import model.PersonnageScene;
import model.Scene;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import service.ActionService;
import service.PersonnageSceneService;

/**
 *
 * @author FITIA ARIVONY
 */

@Controller
public class PersonnageSceneController {
   @Autowired
    private PersonnageSceneService service;

    public PersonnageSceneService getService() {
        return service;
    }

    public void setService(PersonnageSceneService service) {
        this.service = service;
    }
    @GetMapping(path="chargepersoscene")
   public String chargepersoscene(Model model,@ModelAttribute PersonnageScene perso) throws Exception{
       ArrayList<Scene>scenes=this.getService().listScene();
       ArrayList<Personnage>persos=this.getService().listPersoNotInPersoScene(((Scene)scenes.get(0)).getIdscene());
       model.addAttribute("listscene",scenes);
       model.addAttribute("listperso",persos);
       return "Personnage";
   }
 @RequestMapping("insertpersonnagescene")
    public String insertpersoscene(Model model,HttpServletRequest request, HttpServletResponse response) throws Exception{
           
            ArrayList listscene = this.getService().listScene();
            String idscene = "";
            if(listscene.size() != 0){
                idscene = ((Scene) listscene.get(0)).getIdscene();
            }
            System.out.println("tsy niova-------"+idscene);
            if(request.getParameter("idscene")!=null){
                System.out.println("------------ito");
                idscene = request.getParameter("idscene");
            }
            //insert perso_scene
            if(request.getParameter("idperso") != null){                
                // Insert perso_scene 
                PersonnageScene ps = new PersonnageScene();
                ps.setPersonnage(request.getParameter("idperso"));
                ps.setScene(idscene);
                this.getService().insert(ps);
            }
            
            //list personnage not in personnage_scene where idscene
            
            ArrayList listperso = this.getService().listPersoNotInPersoScene(idscene);
       
            model.addAttribute("idscene",idscene);
            model.addAttribute("listscene",listscene);
            model.addAttribute("listperso",listperso);
         
       return "Personnage";   
    }
     
     
}
