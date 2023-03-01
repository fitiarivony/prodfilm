/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;



import generic.utils.GenericHelper;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.persistence.Id;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;



/**
 *
 * @author FITIA ARIVONY
 */
//@Component("hibernate")
public class HibernateDAO implements InterfaceDAO{
    private  SessionFactory sessionFactory;
    
    public  SessionFactory getSessionFactory() {
        return sessionFactory;
    }
   

    public  void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
    public  Session getSession() {
      
        return this.getSessionFactory().openSession();
	}
    @Override
    public void save(Object object) throws Exception {
        Session s=this.getSession();
        Transaction tx = null;
        try{
             tx = s.beginTransaction();
             
             s.save(object);
             s.flush();
             tx.commit();
        }catch(Exception e){
            if (tx!=null) tx.rollback();
            throw e;
        }
        finally{
            tx=null;
            s.close();
           
        }
    }

    @Override
    public void delete(Object object) throws Exception {
         Session s=this.getSession();
         Transaction tx = null;
        try{
             tx = s.beginTransaction();
            s.delete(object);
              tx.commit();
        }catch(Exception e){
            if (tx!=null) tx.rollback();
            throw e;
        }finally{
            tx=null;
            s.close();
             
        }
    }
    
     public static Field getPrimary(Object o){
          Field[]fields=o.getClass().getDeclaredFields();
          for(int i=0;i<fields.length;i++){
            Id id=(Id)fields[i].getAnnotation(Id.class);
                 if(id!=null)return fields[i];
                    
          }
          return null;
    }
      public static Serializable getValue(Object o,Field field)throws Exception{
             field.setAccessible(true);
        return (Serializable)field.get(o);
    }
    
    

    @Override
    public void update(Object object) throws Exception {
           Session s=this.getSession();
            Transaction tx = null;
        try{
             tx = s.beginTransaction();
             System.out.println("Zaho efa niovaaa----------------");
             System.out.println(object.getClass()+"---------");
             Object myEntity = s.get(object.getClass(),HibernateDAO.getValue(object,HibernateDAO.getPrimary(object)));
               ArrayList<Field>fields=GenericHelper.getNonull(object);
               for(Field e:fields){
                   GenericHelper.setValeur(myEntity, e, GenericHelper.get(object,e.getName()));
               }
            s.update(myEntity);
              tx.commit();
        }catch(Exception e){
            if (tx!=null) tx.rollback();
            throw e;
        }finally{
             tx=null;
            s.close();
           
            
        }
    }
    
   
    @Override
    public Object getById(Object object) throws Exception {
           Session s=this.getSession();
            Transaction tx = null;
            Object myEntity =new Object();
        try{
             tx = s.beginTransaction();
             System.out.println("Zaho efa niovaaa----------------");
             System.out.println(object.getClass()+"---------");
             myEntity = s.get(object.getClass(), HibernateDAO.getValue(object,HibernateDAO.getPrimary(object)));
            
            
              tx.commit();
        }catch(Exception e){
            if (tx!=null) tx.rollback();
            throw e;
        }finally{
             tx=null;
            s.close();
           
            
        }
        return myEntity;
    }

    @Override
    public ArrayList<Object> selectAll(Object object) throws Exception {
       Session s=this.getSession();
      
        Transaction tx = null;
        try{
             tx = s.beginTransaction();
            List objects = s.createCriteria(object.getClass()).list(); 
                
              tx.commit();
              
            return new ArrayList<>(objects);
        }catch(Exception e){
            if (tx!=null) tx.rollback();
            throw e;
        }finally{
            tx=null;
            s.close();
           
        }
        
        
    }
  
//    public Controller selectById(Controller object) throws Exception {
//       Session s=object.getSession().openSession();
//        Transaction tx = null;
//        try{
//             tx = s.beginTransaction();
//            Controller result =(Controller) s.get(object.getClass(),10);
//              tx.commit();
//            return result;
//        }catch(Exception e){
//            if (tx!=null) tx.rollback();
//            throw e;
//        }finally{
//            tx=null;
//            s.close();
//        }
//        
//        
//    }
//    

    @Override
    public ArrayList<Object> getByIds(Object object) throws Exception {
       
       Session s=this.getSession();
        Transaction tx = null;
        try{
             tx = s.beginTransaction();
              Criteria criteria=this.getSession().createCriteria(object.getClass());
            getCriteria(criteria,object);
            List<Object>liste=criteria.list();
            // result =(Controller) s.get(object.getClass(),10);
              tx.commit();
            return new ArrayList<Object>(liste);
        }catch(Exception e){
            if (tx!=null) tx.rollback();
            throw e;
        }finally{
            tx=null;
            s.close();
           
        }
    }
     public static void getCriteria(Criteria crit,Object object)throws Exception{
         ArrayList<Field>fields=GenericHelper.getNonull(object);
          HashMap<Field,Object>valeurs=new HashMap<Field,Object>();
        for(int i=0;i<fields.size();i++)valeurs.put(fields.get(i),GenericHelper.instanceNoNull(object,fields.get(i).getName()));
            for(int i=0;i<fields.size();i++)valeurs.put(fields.get(i),GenericHelper.get(object,fields.get(i).getName()));
         for(int i=0;i<fields.size();i++){
             crit.add(Restrictions.eq(GenericHelper.hibernateAttribut(fields.get(i)).name(), valeurs.get(fields.get(i))));
         }
       
     }

    @Override
    public ArrayList<Object> paginer(Object object,int offset,int limit) throws Exception {
    Session s=this.getSession();
      
        Transaction tx = null;
        try{
             tx = s.beginTransaction();
            List objects = s.createCriteria(object.getClass())
                    .setFirstResult(offset)
                    .setMaxResults(limit)
                    .list(); 
                
              tx.commit();
              
            return new ArrayList<>(objects);
        }catch(Exception e){
            if (tx!=null) tx.rollback();
            throw e;
        }finally{
            tx=null;
            s.close();
           
        }
    }
        
     
}
