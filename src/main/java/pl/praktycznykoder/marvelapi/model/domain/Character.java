/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.model.domain;

import pl.praktycznykoder.marvelapi.model.domain.basic.Url;
import pl.praktycznykoder.marvelapi.model.domain.basic.Image;
import pl.praktycznykoder.marvelapi.model.domain.wraper.DomainListWraper;

/**
 *
 * @author praktycznykoder.pl
 */
public class Character implements Domain {
    
    public final static String[] ORDERBY_PARAM_NAMES = {
        "name", "modified"
    };

    private int id;
    private String name;
    private String description;
    private String modified;
    private String resourceURI;
    private Image thumbnail;
    private Url[] urls;
    private DomainListWraper comics;
    private DomainListWraper series;
    private DomainListWraper events;
    private DomainListWraper stories;

    public Character(int id, String name, String description, String modified, 
            String resourceURI, Image thumbnail, Url[] urls, 
            DomainListWraper comics, DomainListWraper series, 
            DomainListWraper events, DomainListWraper stories) {
        
        this.id = id;
        this.name = name;
        this.description = description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public DomainListWraper getComics() {
        return comics;
    }

    public void setComics(DomainListWraper comics) {
        this.comics = comics;
    }

    public DomainListWraper getSeries() {
        return series;
    }

    public void setSeries(DomainListWraper series) {
        this.series = series;
    }

    public DomainListWraper getEvents() {
        return events;
    }

    public void setEvents(DomainListWraper events) {
        this.events = events;
    }

    public DomainListWraper getStories() {
        return stories;
    }

    public void setStories(DomainListWraper stories) {
        this.stories = stories;
    }
    
}