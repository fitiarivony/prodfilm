/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generic.utils;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author FITIA ARIVONY
 */
public final class Connect implements Serializable {
    Connection connect;
    boolean ouvert;
    boolean willbeused;
    int numberusing;
    String url;
    String username;
    String password;

    public boolean isWillbeused() {
        return willbeused;
    }

    public void setWillbeused(boolean willbeused) {
        this.willbeused = willbeused;
    }

    public String getUrl() {
        if(url==null)this.setUrl("jdbc:postgresql://localhost:8089/framework");
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        if(username==null)this.setUsername("societe");
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
          if(password==null)this.setPassword("mdp");
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public int getNumberusing() {
        return numberusing;
    }

    public void setNumberusing(int numberusing) {
        this.numberusing = numberusing;
    }
    

    public boolean Willbeused() {
        return willbeused;
    }

    public void setuses(boolean willbeused) {
        this.willbeused = willbeused;
    }

    public Connection getConnect() {
        return connect;
    }

    public void setConnect(Connection connect) {
        this.connect = connect;
    }

    public boolean isOuvert() {
        return ouvert;
    }

    public void setOuvert(boolean ouvert) {
        this.ouvert = ouvert;
    }
    public void close() throws SQLException{
        this.setOuvert(false);
      //  System.out.println(this.Willbeused());
        if(this.getConnect()!=null  && !this.Willbeused())this.getConnect().close();
    }
    public void commit() throws SQLException{
        if(this.getConnect()!=null){
            this.getConnect().commit();
            this.close();
        }
        
    }
     public void rollback() throws SQLException{
        if(this.getConnect()!=null){
            this.getConnect().rollback();
            this.close();
        }
    }
    public void setAutoCommit(boolean autocommit) throws SQLException{
        this.getConnect().setAutoCommit(autocommit);
    }
    public boolean getAutoCommit() throws SQLException{
        return this.getConnect().getAutoCommit();
    }
    public Connect() throws Exception{ 
        this.setOuvert(false);
        this.setuses(false);
    //    this.getConnection();
    }
   public boolean isNull() throws SQLException{
       if(this.getConnect()==null || this.isClosed())return true;
       return false;
   }
   public boolean isClosed() throws SQLException{
       return this.getConnect().isClosed();
   }
   public PreparedStatement prepareStatement(String sql) throws Exception{
       this.getConnection();
       return this.getConnect().prepareStatement(sql);
   }
     public  void getConnection()throws ClassNotFoundException,SQLException{
         
         if(this.isNull() || this.isClosed() || !this.Willbeused()){
             Class.forName("org.postgresql.Driver");
              this.setConnect(DriverManager.getConnection(this.getUrl(),this.getUsername(),this.getPassword()));
         }
    }
    public void forceClose() throws SQLException{
        this.setuses(false);
        this.close();
    }
    @Override
    public String toString() {
        return "Connect{" + "connect=" + connect + ", ouvert=" + ouvert + '}';
    }
   
     
    
}
