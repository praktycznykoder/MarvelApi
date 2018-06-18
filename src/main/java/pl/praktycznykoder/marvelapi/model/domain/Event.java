/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.model.domain;

import pl.praktycznykoder.marvelapi.model.domain.basic.Url;
import pl.praktycznykoder.marvelapi.model.domain.basic.Image;
import pl.praktycznykoder.marvelapi.model.domain.wraper.DomainWraper;
import pl.praktycznykoder.marvelapi.model.domain.wraper.DomainListWraper;

/**
 *
 * @author praktycznykoder.pl
 */
public class Event implements Domain {
    
    public final static String[] ORDERBY_PARAM_NAMES = {
        "name", "startDate", "modified"
    };
    
    private int id;
    private String title;
    private String description;
    private String modified;
    private String resourceURI;
    private String start;
    private String end;
    private Image thumbnail;
    private Url[] urls;
    private DomainWraper previous;
    private DomainWraper next;
    private DomainListWraper comics;
    private DomainListWraper stories;
    private DomainListWraper series;
    private DomainListWraper characters;
    private DomainListWraper creators;

    public Event(int id, String title, String description, String modified, 
        String resourceURI, String start, String end, Image thumbnail, 
        Url[] urls, DomainWraper previous, DomainWraper next, 
        DomainListWraper comics, DomainListWraper stories, 
        DomainListWraper series, DomainListWraper characters, 
        DomainListWraper creators) {
        
        this.id = id;
        this.title = title;
        this.description = description;
        this.modified = modified;
        this.resourceURI = resourceURI;
        this.start = start;
        this.end = end;
        this.thumbnail = thumbnail;
        this.urls = urls;
        this.previous = previous;
        this.next = next;
        this.comics = comics;
        this.stories = stories;
        this.series = series;
        this.characters = characters;
        this.creators = creators;
    }
    
    @Override
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
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

    public DomainWraper getPrevious() {
        return previous;
    }

    public void setPrevious(DomainWraper previous) {
        this.previous = previous;
    }

    public DomainWraper getNext() {
        return next;
    }

    public void setNext(DomainWraper next) {
        this.next = next;
    }

    public DomainListWraper getComics() {
        return comics;
    }

    public void setComics(DomainListWraper comics) {
        this.comics = comics;
    }

    public DomainListWraper getStories() {
        return stories;
    }

    public void setStories(DomainListWraper stories) {
        this.stories = stories;
    }

    public DomainListWraper getSeries() {
        return series;
    }

    public void setSeries(DomainListWraper series) {
        this.series = series;
    }

    public DomainListWraper getCharacters() {
        return characters;
    }

    public void setCharacters(DomainListWraper characters) {
        this.characters = characters;
    }

    public DomainListWraper getCreators() {
        return creators;
    }

    public void setCreators(DomainListWraper creators) {
        this.creators = creators;
    }
}
