/*
 * Copyright (C) 2018 praktycznykoder.pl
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
package pl.praktycznykoder.marvelapi.model.domain.basic;

import java.text.SimpleDateFormat;

/**
 *
 * @author praktycznykoder.pl
 */
public class Date {
    	
    /**
     *
     */
    public final static String DATE_FORMAT = "yyyy-MM-dd";

    /**
     *
     * @param date
     * @return
     */
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

    /**
     *
     * @param type
     * @param date
     */
    public Date(String type, String date) {
        this.type = type;
        this.date = date;
    }

    @Override
    public String toString() {
        return type + " : " + getDate();
    }
    
    /**
     *
     * @return
     */
    public String getType() {
            return type;
    }

    /**
     *
     * @param type
     */
    public void setType(String type) {
            this.type = type;
    }

    /**
     *
     * @return
     */
    public String getDate() {
            return dateConvert(date);
    }

    /**
     *
     * @param date
     */
    public void setDate(String date) {
            this.date = date;
    }   
}
