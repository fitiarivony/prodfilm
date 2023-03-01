/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package advisor;

/**
 *
 * @author FITIA ARIVONY
 */

import helper.CustomTimestampEditor;
import java.sql.Timestamp;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice("controller")
public class ClientAdvisor {

   @InitBinder
public void initBinder(WebDataBinder binder) {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
    dateFormat.setLenient(false);
    binder.registerCustomEditor(Timestamp.class, new CustomTimestampEditor(dateFormat, true));
}



    
    
     @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleProduitException(Exception e, Model model) {
        e.printStackTrace();
        model.addAttribute("message", e.getMessage());
        return "error/produiterror";
    }
}