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
public class Event implements Domain {

    private int id;
    private String title;
    private String description;
    private String modified;
    private String resourceURI;
    private String start;
    private String end;
    private Image thumbnail;
    private Url[] urls;
    private RemoteDomain previous;
    private RemoteDomain next;
    private RemoteDomainList comics;
    private RemoteDomainList stories;
    private RemoteDomainList series;
    private RemoteDomainList characters;
    private RemoteDomainList creators;

    public Event(int id, String title, String description, String modified, 
        String resourceURI, String start, String end, Image thumbnail, 
        Url[] urls, RemoteDomain previous, RemoteDomain next, 
        RemoteDomainList comics, RemoteDomainList stories, 
        RemoteDomainList series, RemoteDomainList characters, 
        RemoteDomainList creators) {
        
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

    public RemoteDomainList getComics() {
        return comics;
    }

    public void setComics(RemoteDomainList comics) {
        this.comics = comics;
    }

    public RemoteDomainList getStories() {
        return stories;
    }

    public void setStories(RemoteDomainList stories) {
        this.stories = stories;
    }

    public RemoteDomainList getSeries() {
        return series;
    }

    public void setSeries(RemoteDomainList series) {
        this.series = series;
    }

    public RemoteDomainList getCharacters() {
        return characters;
    }

    public void setCharacters(RemoteDomainList characters) {
        this.characters = characters;
    }

    public RemoteDomainList getCreators() {
        return creators;
    }

    public void setCreators(RemoteDomainList creators) {
        this.creators = creators;
    }
}
