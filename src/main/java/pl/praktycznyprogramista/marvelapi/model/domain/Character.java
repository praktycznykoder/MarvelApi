/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznyprogramista.marvelapi.model.domain;

import pl.praktycznyprogramista.marvelapi.model.domain.remote.RemoteDomain;
import pl.praktycznyprogramista.marvelapi.model.domain.remote.RemoteDomainList;

/**
 *
 * @author User
 */
public class Character implements Domain {

    private int id;
    private String name;
    private String decription;
    private String modified;
    private String resourceURI;
    private Image thumbnail;
    private Url[] urls;
    private RemoteDomainList comics;
    private RemoteDomainList series;
    private RemoteDomainList events;
    private RemoteDomainList stories;
    
    @Override
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDecription() {
        return decription;
    }
    public void setDecription(String decription) {
        this.decription = decription;
    }
    public String getModified() {
        return modified;
    }
    public void setModified(String modified) {
        this.modified = modified;
    }
    public String getResourceURI() {
        return resourceURI;
    }
    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }
    public Image getThumbnail() {
        return thumbnail;
    }
    public void setThumbnail(Image thumbnail) {
        this.thumbnail = thumbnail;
    }
    public Url[] getUrls() {
        return urls;
    }
    public void setUrls(Url[] urls) {
        this.urls = urls;
    }    
}