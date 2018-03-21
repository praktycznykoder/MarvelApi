/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.model.domain;

import pl.praktycznykoder.marvelapi.model.domain.others.Url;
import pl.praktycznykoder.marvelapi.model.domain.others.Image;
import pl.praktycznykoder.marvelapi.model.domain.remote.RemoteDomainList;

/**
 *
 * @author praktycznykoder.pl
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

    public Character(int id, String name, String decription, String modified, 
            String resourceURI, Image thumbnail, Url[] urls, 
            RemoteDomainList comics, RemoteDomainList series, 
            RemoteDomainList events, RemoteDomainList stories) {
        
        this.id = id;
        this.name = name;
        this.decription = decription;
        this.modified = modified;
        this.resourceURI = resourceURI;
        this.thumbnail = thumbnail;
        this.urls = urls;
        this.comics = comics;
        this.series = series;
        this.events = events;
        this.stories = stories;
    }
    
    @Override
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
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

    public RemoteDomainList getComics() {
        return comics;
    }

    public void setComics(RemoteDomainList comics) {
        this.comics = comics;
    }

    public RemoteDomainList getSeries() {
        return series;
    }

    public void setSeries(RemoteDomainList series) {
        this.series = series;
    }

    public RemoteDomainList getEvents() {
        return events;
    }

    public void setEvents(RemoteDomainList events) {
        this.events = events;
    }

    public RemoteDomainList getStories() {
        return stories;
    }

    public void setStories(RemoteDomainList stories) {
        this.stories = stories;
    }
    
}