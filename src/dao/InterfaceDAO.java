/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import java.util.ArrayList;

/**
 *
 * @author FITIA ARIVONY
 */
public interface InterfaceDAO {
    public void save(Object object)throws Exception;
    public void delete(Object object)throws Exception;
    public void update(Object object)throws Exception;
    public ArrayList<Object>selectAll(Object object)throws Exception;
    public  ArrayList<Object>getByIds(Object object)throws Exception;
    public ArrayList<Object>paginer(Object object,int offset,int limit)throws Exception;
     public Object getById(Object object)throws Exception;
}
