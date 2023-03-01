/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.HibernateDAO;
import dao.InterfaceDAO;
import java.util.ArrayList;
import java.util.List;
import model.Action;
import model.Perso_scene;
import model.Scene;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author FITIA ARIVONY
 */
@Service
public class ActionService {
     @Autowired
    @Qualifier("hibernate")
   private InterfaceDAO dao;

    public InterfaceDAO getDao() {
        return dao;
    }

    public void setDao(InterfaceDAO dao) {
        this.dao = dao;
    }
    public void save(Action[]actions) throws Exception{
        for(Action a:actions){
            this.getDao().save(a);
        }
    }
   
     public ArrayList<Object>listScene() throws Exception{
       return this.getDao().selectAll(new Scene());
     }
     public ArrayList<Object>personnageScene(Perso_scene scene) throws Exception{
         return this.getDao().getByIds(scene);
     }
     public int getLastOrdre(String idscene){
         Session s=((HibernateDAO)this.getDao()).getSession();
          Criteria criteria = s.createCriteria(Action.class);
           criteria.add(Restrictions.eq("idscene", idscene));
           ArrayList<Action>liste=new  ArrayList<Action>(criteria
                .addOrder(Order.desc("ordre"))
                .list());
           if(liste.isEmpty())return 0;
           return liste.get(0).getOrdre();  
     }
}
