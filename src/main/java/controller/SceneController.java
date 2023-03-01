/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.text.ParseException;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import jve.bootstrap.DefaultForm;
import jve.gen.Forms;
import jve.html.tag.specific.Form;
import model.Film;
import model.Plateau;
import model.Scene;
import model.helper.Scene2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import service.ActionService;
import service.SceneService;

/**
 *
 * @author FITIA ARIVONY
 */
@Controller
public class SceneController {
     @Autowired
    private SceneService service;

    public SceneService getService() {
        return service;
    }
     
    @GetMapping("/")
    public String gotoacceuil(){
        return "index";
    }
    
      @GetMapping("/scene")
     public String chargescene(Model mod) throws Exception{
         Forms form=new Forms(new Scene(),"nom","plateau","film","duree");
         form.getChamp("plateau").setData(this.getService().listPlateau().toArray(), "nomplateau", "idplateau");
         form.getChamp("film").setData(this.getService().listFilm().toArray(), "nomfilm", "id");
         Form f=DefaultForm.defaultForm(form, "lasa", "POST");
         mod.addAttribute("form", f.getTag());
//         Scene sc=new Scene();
//         
//         sc.setDuree(new Date());
//         sc.setFilm("FIL1");
//         sc.setNom("Anarana");
//         sc.setPlateau("PLA1");
//          
//         this.getService().getDao().save(sc);
         return "ins";
     }
     
     @PostMapping("/lasa")
     public String insertscene(Model mod,String nom,String plateau,String film,String duree) throws ParseException, Exception{
         Scene2 sc=new Scene2();
         sc.setNom(nom);
         sc.setFilm(film);
         System.out.println(duree);
         DateTimeFormatter formater=DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
         TemporalAccessor accessor = formater.parse(duree);
         Duration duration = Duration.ofHours(accessor.get(ChronoField.HOUR_OF_DAY))
                 .plusMinutes(accessor.get(ChronoField.MINUTE_OF_HOUR))
                 .plusSeconds(accessor.get(ChronoField.SECOND_OF_MINUTE));
         sc.setDuree(duration);
         sc.setPlateau(plateau);
         this.getService().getDao().save(sc);
         return "redirect:/insertpersonnagescene";
     }
}
