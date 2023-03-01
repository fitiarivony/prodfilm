package service;

import dao.HibernateDAO;
import java.util.ArrayList;
import model.Plan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Hart
 */
@Component
public class ServicePlan {
    @Autowired
    HibernateDAO dao;
    public ArrayList<Plan> getPlanning() throws Exception{
        return Plan.getPlanning(dao);
     
    }

}
