/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.model.domain.basic;

import java.text.SimpleDateFormat;

/**
 *
 * @author praktycznykoder.pl
 */
public class Date {
    	
    public final static String DATE_FORMAT = "yyyy-MM-dd";
    public final static String dateConvert(String date){
        try {
            date = date.substring(0, DATE_FORMAT.length());
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            return sdf.format(date);
        } catch(java.lang.IllegalArgumentException e) {
            return "";
        } catch(java.lang.NullPointerException e) {
            System.err.println(e.getMessage());
            return "";
        }
    }	
    private String type;
    private String date;

    public Date(String type, String date) {
        this.type = type;
        this.date = date;
    }

    @Override
    public String toString() {
        return type + " : " + getDate();
    }
    
    public String getType() {
            return type;
    }

    public void setType(String type) {
            this.type = type;
    }

    public String getDate() {
            return dateConvert(date);
    }

    public void setDate(String date) {
            this.date = date;
    }   
}