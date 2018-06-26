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
    
    /**
     *
     */
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

    /**
     *
     * @param id
     * @param title
     * @param description
     * @param modified
     * @param resourceURI
     * @param start
     * @param end
     * @param thumbnail
     * @param urls
     * @param previous
     * @param next
     * @param comics
     * @param stories
     * @param series
     * @param characters
     * @param creators
     */
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
    public String getStart() {
        return start;
    }

    /**
     *
     * @param start
     */
    public void setStart(String start) {
        this.start = start;
    }

    /**
     *
     * @return
     */
    public String getEnd() {
        return end;
    }

    /**
     *
     * @param end
     */
    public void setEnd(String end) {
        this.end = end;
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
    public Url[] getUrls() {
        return urls;
    }

    /**
     *
     * @param urls
     */
    public void setUrls(Url[] urls) {
        this.urls = urls;
    }

    /**
     *
     * @return
     */
    public DomainWraper getPrevious() {
        return previous;
    }

    /**
     *
     * @param previous
     */
    public void setPrevious(DomainWraper previous) {
        this.previous = previous;
    }

    /**
     *
     * @return
     */
    public DomainWraper getNext() {
        return next;
    }

    /**
     *
     * @param next
     */
    public void setNext(DomainWraper next) {
        this.next = next;
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
    public DomainListWraper getStories() {
        return stories;
    }

    /**
     *
     * @param stories
     */
    public void setStories(DomainListWraper stories) {
        this.stories = stories;
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
