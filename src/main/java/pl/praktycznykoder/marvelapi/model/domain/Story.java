/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.model.domain;

import pl.praktycznykoder.marvelapi.model.domain.others.Image;
import pl.praktycznykoder.marvelapi.model.domain.remote.RemoteDomain;
import pl.praktycznykoder.marvelapi.model.domain.remote.RemoteDomainList;

/**
 *
 * @author praktycznykoder.pl
 */
public class Story implements Domain {

    private int id;
    private String title;
    private String type;
    private String description;
    private String modified;
    private String resourceURI;
    private Image thumbnail;
    private RemoteDomain originalIssue;
    private RemoteDomainList comics;
    private RemoteDomainList series;
    private RemoteDomainList events;
    private RemoteDomainList characters;
    private RemoteDomainList creators;

    public Story(int id, String title, String type, String description, String modified, String resourceURI, Image thumbnail, RemoteDomain originalIssue, RemoteDomainList comics, RemoteDomainList series, RemoteDomainList events, RemoteDomainList characters, RemoteDomainList creators) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.description = description;
        this.modified = modified;
        this.resourceURI = resourceURI;
        this.thumbnail = thumbnail;
        this.originalIssue = originalIssue;
        this.comics = comics;
        this.series = series;
        this.events = events;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public RemoteDomain getOriginalIssue() {
        return originalIssue;
    }

    public void setOriginalIssue(RemoteDomain originalIssue) {
        this.originalIssue = originalIssue;
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
