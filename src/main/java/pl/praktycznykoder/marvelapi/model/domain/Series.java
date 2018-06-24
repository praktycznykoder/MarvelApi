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
public class Series implements Domain {
    
    public final static String[] ORDERBY_PARAM_NAMES = {
        "title", "modified", "startYear",
    };
    
    public final static String[] SERIES_TYPES = {
        "", "collection", "one shot", "limited", "ongoing"
    };
    
    public final static String[] CONTAINS = {
        "", "comic", "magazine", "startYear", "trade paperback", "hardcover",
        "digest", "graphic novel", "digital comic", "infinite comic"
    };
    
    private int id;
    private String title;
    private String description;
    private String resourceURI;
    private String startYear;
    private String endYear;
    private String rating;
    private String type;    
    private String modified;
    private Image thumbnail;

    private Url[] urls;    
    
    private DomainListWraper comics;
    private DomainListWraper characters;
    private DomainListWraper stories;
    private DomainListWraper creators;
    private DomainListWraper events;

    private DomainWraper previous;
    private DomainWraper next;

    public Series(int id, String title, String description, 
        String resourceURI, String startYear, String endYear, String rating, 
        String type, String modified, Image thumbnail, Url[] urls, 
        DomainListWraper comics, DomainListWraper characters, 
        DomainListWraper stories, DomainListWraper creators, 
        DomainListWraper events, DomainWraper previous, DomainWraper next){
        
        this.id = id;
        this.title = title;
        this.description = description;
        this.resourceURI = resourceURI;
        this.startYear = startYear;
        this.endYear = endYear;
        this.rating = rating;
        this.type = type;
        this.modified = modified;
        this.thumbnail = thumbnail;
        this.urls = urls;
        this.comics = comics;
        this.characters = characters;
        this.stories = stories;
        this.creators = creators;
        this.events = events;
        this.previous = previous;
        this.next = next;
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

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
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

    public DomainListWraper getCharacters() {
        return characters;
    }

    public void setCharacters(DomainListWraper characters) {
        this.characters = characters;
    }

    public DomainListWraper getStories() {
        return stories;
    }

    public void setStories(DomainListWraper stories) {
        this.stories = stories;
    }

    public DomainListWraper getCreators() {
        return creators;
    }

    public void setCreators(DomainListWraper creators) {
        this.creators = creators;
    }

    public DomainListWraper getEvents() {
        return events;
    }

    public void setEvents(DomainListWraper events) {
        this.events = events;
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
}