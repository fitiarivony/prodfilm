/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import java.text.ParseException;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import jve.bootstrap.DefaultForm;
import jve.gen.Forms;
import jve.html.tag.specific.Form;
import model.Action;
import model.Film;
import model.Perso_scene;
import model.Plateau;
import model.Scene;
import model.helper.Scene2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import service.ActionService;
import terminal.HandleDate;


/**
 *
 * @author FITIA ARIVONY
 */
@Controller
public class ActionController {
      @Autowired
    private ActionService service;

    public ActionService getService() {
        return service;
    }

    public void setService(ActionService service) {
        this.service = service;
    }
    
     @GetMapping(path="chargeact")
    public String charge(@ModelAttribute Action action,Model model) throws Exception{
        ArrayList<Object>liste=this.getService().listScene();
      model.addAttribute("scenes",liste);
      Perso_scene pers=new Perso_scene();
      pers.setIdscene(((Scene)liste.get(0)).getIdscene());
      model.addAttribute("perso_scene",this.getService().personnageScene(pers));

      return "insertact";
    }
    @PostMapping("createact")
    public String createact(HttpServletRequest req) throws Exception{
        int maxordre=this.getService().getLastOrdre(req.getParameter("idscene"));
        int nb=Integer.parseInt(req.getParameter("nb"));
        Action[]acts=new Action[nb];
        System.out.println(nb);
        for(int i=1,j=0;i<=nb;i++,j++){
           Action act=new Action();
           act.setEvenement(req.getParameter("evenement"+i));
            act.setExpression(req.getParameter("expression"+i));
           act.setIdpersonnage(req.getParameter("perso_scene"+i));
           act.setIdscene(req.getParameter("idscene"));
           act.setOrdre(i+maxordre);
           acts[j]=act;
            System.out.println(act);
        }
       this.getService().save(acts);
        return "redirect:/chargeact";
    }
    
    //     ajax
     @GetMapping("/perso_scene")
     @ResponseBody
     public HashMap<String,Object> getPersoScene(@RequestParam String idscene) throws Exception{
         Perso_scene pers=new Perso_scene();
         pers.setIdscene(idscene);
         ArrayList<Object>liste=this.getService().personnageScene(pers);
         HashMap<String,Object>map=new HashMap<>();
         map.put("perso",liste);
       return map;
     }
     
  
    
}
