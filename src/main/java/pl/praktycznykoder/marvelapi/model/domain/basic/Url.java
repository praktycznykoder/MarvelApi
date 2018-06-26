/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.model.domain.basic;

import pl.praktycznykoder.marvelapi.model.domain.wraper.ResourceWraper;

/**
 *
 * @author praktycznykoder.pl
 */
public class Url implements ResourceWraper{

    private String type;	
    private String url;

    /**
     *
     * @param type
     * @param url
     */
    public Url(String type, String url) {
        this.type = type;
        this.url = url;
    }
    
    @Override
    public String toString() {
            return url+"."+type;
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
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
