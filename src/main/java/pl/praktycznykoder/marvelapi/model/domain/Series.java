/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.model.domain;

import pl.praktycznykoder.marvelapi.model.domain.others.Url;
import pl.praktycznykoder.marvelapi.model.domain.others.Image;
import pl.praktycznykoder.marvelapi.model.domain.remote.RemoteDomain;
import pl.praktycznykoder.marvelapi.model.domain.remote.RemoteDomainList;

/**
 *
 * @author praktycznykoder.pl
 */
public class Series implements Domain {

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
    
    private RemoteDomainList comics;
    private RemoteDomainList characters;
    private RemoteDomainList stories;
    private RemoteDomainList creators;
    private RemoteDomainList events;

    private RemoteDomain previous;
    private RemoteDomain next;

    public Series(int id, String title, String description, 
        String resourceURI, String startYear, String endYear, String rating, 
        String type, String modified, Image thumbnail, Url[] urls, 
        RemoteDomainList comics, RemoteDomainList characters, 
        RemoteDomainList stories, RemoteDomainList creators, 
        RemoteDomainList events, RemoteDomain previous, RemoteDomain next){
        
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

    public RemoteDomainList getComics() {
        return comics;
    }

    public void setComics(RemoteDomainList comics) {
        this.comics = comics;
    }

    public RemoteDomainList getCharacters() {
        return characters;
    }

    public void setCharacters(RemoteDomainList characters) {
        this.characters = characters;
    }

    public RemoteDomainList getStories() {
        return stories;
    }

    public void setStories(RemoteDomainList stories) {
        this.stories = stories;
    }

    public RemoteDomainList getCreators() {
        return creators;
    }

    public void setCreators(RemoteDomainList creators) {
        this.creators = creators;
    }

    public RemoteDomainList getEvents() {
        return events;
    }

    public void setEvents(RemoteDomainList events) {
        this.events = events;
    }

    public RemoteDomain getPrevious() {
        return previous;
    }

    public void setPrevious(RemoteDomain previous) {
        this.previous = previous;
    }

    public RemoteDomain getNext() {
        return next;
    }

    public void setNext(RemoteDomain next) {
        this.next = next;
    }
}