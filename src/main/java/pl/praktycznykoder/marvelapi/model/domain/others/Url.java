/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.model.domain.others;

import pl.praktycznykoder.marvelapi.model.domain.remote.RemoteResource;

/**
 *
 * @author praktycznykoder.pl
 */
public class Url implements RemoteResource{

    private String type;	
    private String url;

    public Url(String type, String url) {
        this.type = type;
        this.url = url;
    }
    
    @Override
    public String toString() {
            return url+"."+type;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
