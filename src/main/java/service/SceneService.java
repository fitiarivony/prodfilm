/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.HibernateDAO;
import java.util.ArrayList;
import model.Film;
import model.Plateau;
import model.Scene;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author FITIA ARIVONY
 */
@Service
public class SceneService {
    @Autowired
    HibernateDAO dao;

    public HibernateDAO getDao() {
        return dao;
    }

    public void setDao(HibernateDAO dao) {
        this.dao = dao;
    }
    
     public ArrayList<Object>listFilm() throws Exception{
       return this.getDao().selectAll(new Film());
     }
      public ArrayList<Object>listPlateau() throws Exception{
       return this.getDao().selectAll(new Plateau());
     }
}
