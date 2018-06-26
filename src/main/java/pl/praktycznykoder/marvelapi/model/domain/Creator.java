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
public class Creator implements Domain {
    
    /**
     *
     */
    public final static String[] ORDERBY_PARAM_NAMES = {
        "lastName", "firstName", "middleName", "suffix",
        "modifiede"
    };
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    private String fullName;
    private String modified;
    private String resourceURI;
    private Image thumbnail;
    private Url[] urls;
    private DomainListWraper comics;
    private DomainListWraper stories;
    private DomainListWraper series;
    private DomainListWraper events;

    /**
     *
     * @param id
     * @param firstName
     * @param middleName
     * @param lastName
     * @param suffix
     * @param fullName
     * @param modified
     * @param resourceURI
     * @param thumbnail
     * @param urls
     * @param comics
     * @param stories
     * @param series
     * @param events
     */
    public Creator(int id, String firstName, String middleName, String lastName, String suffix, String fullName, String modified, String resourceURI, Image thumbnail, Url[] urls, DomainListWraper comics, DomainListWraper stories, DomainListWraper series, DomainListWraper events) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.suffix = suffix;
        this.fullName = fullName;
        this.modified = modified;
        this.resourceURI = resourceURI;
        this.thumbnail = thumbnail;
        this.urls = urls;
        this.comics = comics;
        this.stories = stories;
        this.series = series;
        this.events = events;
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
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     *
     * @param middleName
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     *
     * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return
     */
    public String getSuffix() {
        return suffix;
    }

    /**
     *
     * @param suffix
     */
    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    /**
     *
     * @return
     */
    public String getFullName() {
        return fullName;
    }

    /**
     *
     * @param fullName
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
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
}