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
    private String addressPattern = "\\d+[ ](?:[A-Za-z0-9.-]+[ ]?)+(?:Avenue|Parade|Lane|Road|Boulevard|Drive|Street|Ave|Dr|Rd|Blvd|Ln|St)\\.?";
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
    
    public boolean validateShipmentAddress (String shipmentAddress) {
        return validate(addressPattern, shipmentAddress);
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
    
   
    
    
    
    public void clear(HttpSession session) {
        session.setAttribute("dateErr", "dd/mm/yyyy");
        session.setAttribute("addressErr", null);
        session.setAttribute("postcodeErr", null);
        
    }


}