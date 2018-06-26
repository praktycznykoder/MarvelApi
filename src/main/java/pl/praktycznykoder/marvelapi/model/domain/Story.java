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

    /**
     *
     */
    public final static String[] ORDERBY_PARAM_NAMES = {
        "id", "modified"
    };
    
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

    /**
     *
     * @param id
     * @param title
     * @param type
     * @param description
     * @param modified
     * @param resourceURI
     * @param thumbnail
     * @param originalIssue
     * @param comics
     * @param series
     * @param events
     * @param characters
     * @param creators
     */
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
    
    /**
     *
     * @return
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public String getModified() {
        return modified;
    }

    /**
     *
     * @param modified
     */
    public void setModified(String modified) {
        this.modified = modified;
    }

    /**
     *
     * @return
     */
    public String getResourceURI() {
        return resourceURI;
    }

    /**
     *
     * @param resourceURI
     */
    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    /**
     *
     * @return
     */
    public Image getThumbnail() {
        return thumbnail;
    }

    /**
     *
     * @param thumbnail
     */
    public void setThumbnail(Image thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     *
     * @return
     */
    public DomainWraper getOriginalIssue() {
        return originalIssue;
    }

    /**
     *
     * @param originalIssue
     */
    public void setOriginalIssue(DomainWraper originalIssue) {
        this.originalIssue = originalIssue;
    }

    /**
     *
     * @return
     */
    public DomainListWraper getComics() {
        return comics;
    }

    /**
     *
     * @param comics
     */
    public void setComics(DomainListWraper comics) {
        this.comics = comics;
    }

    /**
     *
     * @return
     */
    public DomainListWraper getSeries() {
        return series;
    }

    /**
     *
     * @param series
     */
    public void setSeries(DomainListWraper series) {
        this.series = series;
    }

    /**
     *
     * @return
     */
    public DomainListWraper getEvents() {
        return events;
    }

    /**
     *
     * @param events
     */
    public void setEvents(DomainListWraper events) {
        this.events = events;
    }

    /**
     *
     * @return
     */
    public DomainListWraper getCharacters() {
        return characters;
    }

    /**
     *
     * @param characters
     */
    public void setCharacters(DomainListWraper characters) {
        this.characters = characters;
    }

    /**
     *
     * @return
     */
    public DomainListWraper getCreators() {
        return creators;
    }

    /**
     *
     * @param creators
     */
    public void setCreators(DomainListWraper creators) {
        this.creators = creators;
    }
    
    
    
}
