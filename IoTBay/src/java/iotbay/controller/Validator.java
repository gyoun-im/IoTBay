/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iotbay.controller;

import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.HttpSession;

/**
 *
 * @author David Guntoro
 */
public class Validator  implements Serializable {
    private String statePattern = "";
    private String postcodePattern ="^[0-9]{4}$";
    private String datePattern="^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";


    public Validator() {
    }

    public boolean validate (String pattern, String input) {
        Pattern regEx = Pattern.compile(pattern);
        Matcher match = regEx.matcher(input);
        return match.matches();
    }
    
    public boolean validateShipmentDate (String date){
       return validate(datePattern, date);
    }
    
    public boolean validateInt (String pattern, int input) {
        Pattern regEx = Pattern.compile(pattern);
        String i = Integer.toString(input);
        Matcher match = regEx.matcher(i);
        return match.matches();
    }
    
    public boolean validatePostcode (int postcode) {
        return validateInt(postcodePattern, postcode);
    }
    
    public boolean validateState (String state) {
        return false;
    }
    
    
    
    public void clear(HttpSession session) {
        session.setAttribute("dateErr", "dd/mm/yyyy");
        session.setAttribute("stateErr", "");
        session.setAttribute("postcodeErr", "");
    }


}