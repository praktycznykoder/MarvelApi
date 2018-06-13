/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.model.domain;

import pl.praktycznykoder.marvelapi.model.domain.basic.Image;
import pl.praktycznykoder.marvelapi.model.domain.wraper.DomainWraper;
import pl.praktycznykoder.marvelapi.model.domain.wraper.DomainListWraper;

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
    private DomainWraper originalIssue;
    private DomainListWraper comics;
    private DomainListWraper series;
    private DomainListWraper events;
    private DomainListWraper characters;
    private DomainListWraper creators;

    public Story(int id, String title, String type, String description, String modified, String resourceURI, Image thumbnail, DomainWraper originalIssue, DomainListWraper comics, DomainListWraper series, DomainListWraper events, DomainListWraper characters, DomainListWraper creators) {
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

    public DomainWraper getOriginalIssue() {
        return originalIssue;
    }

    public void setOriginalIssue(DomainWraper originalIssue) {
        this.originalIssue = originalIssue;
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
