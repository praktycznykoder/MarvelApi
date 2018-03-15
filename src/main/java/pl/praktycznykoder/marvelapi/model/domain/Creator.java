/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.model.domain;

import pl.praktycznykoder.marvelapi.model.domain.others.Url;
import pl.praktycznykoder.marvelapi.model.domain.others.Image;
import pl.praktycznykoder.marvelapi.model.domain.remote.RemoteDomainList;

/**
 *
 * @author praktycznykoder.pl
 */
public class Creator implements Domain {

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
    private RemoteDomainList comics;
    private RemoteDomainList stories;
    private RemoteDomainList series;
    private RemoteDomainList events;

    public Creator(int id, String firstName, String middleName, String lastName, String suffix, String fullName, String modified, String resourceURI, Image thumbnail, Url[] urls, RemoteDomainList comics, RemoteDomainList stories, RemoteDomainList series, RemoteDomainList events) {
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

    public RemoteDomainList getEvents() {
        return events;
    }

    public void setEvents(RemoteDomainList events) {
        this.events = events;
    }
}