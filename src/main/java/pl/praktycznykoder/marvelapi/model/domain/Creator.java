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
    
    @Override
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public DomainListWraper getEvents() {
        return events;
    }

    public void setEvents(DomainListWraper events) {
        this.events = events;
    }
}