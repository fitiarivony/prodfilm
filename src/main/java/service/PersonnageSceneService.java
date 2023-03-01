/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.HibernateDAO;
import dao.InterfaceDAO;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import model.Action;
import model.Perso_scene;
import model.Personnage;
import model.PersonnageScene;
import model.Scene;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author FITIA ARIVONY
 */
@Service
public class PersonnageSceneService {
    @Autowired
    @Qualifier("hibernate")
   private InterfaceDAO dao;
    
    public InterfaceDAO getDao() {
        return dao;
    }

    public void setDao(InterfaceDAO dao) {
        this.dao = dao;
    }
    public void save(PersonnageScene ps) throws Exception{
            this.getDao().save(ps);
    }
    public ArrayList<Scene>listScene() throws Exception{
        Criteria crit=((HibernateDAO)this.getDao()).getSession().createCriteria(Scene.class);
        crit.addOrder(Order.asc("idscene"));
       return new ArrayList<Scene>(crit.list());
     }
    public ArrayList<Personnage> listPersoNotInPersoScene(String idscene)throws Exception{
        Session session=((HibernateDAO)this.getDao()).getSession();
        
     DetachedCriteria subquery = DetachedCriteria.forClass(Perso_scene.class)
    .add(Restrictions.eq("idscene", idscene))
    .setProjection(Projections.property("idpersonnage"));

    Criteria criteria = session.createCriteria(Personnage.class)
    .add(Subqueries.propertyNotIn("idpersonnage", subquery));

        return new ArrayList<Personnage>(criteria.list());
        
    }
     public void insert(PersonnageScene o) throws Exception{
        this.getDao().save(o);
    }
}
