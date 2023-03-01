package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import service.ServicePlan;


/**
 *
 * @author Hart
 */

@Controller
public class PlanController {
    @Autowired
    ServicePlan sp;
    
    @GetMapping(value="/plan")
    public String toSearch(Model model) throws Exception{
        model.addAttribute("plan", sp.getPlanning());
        return "affichePlan";
    }
}
