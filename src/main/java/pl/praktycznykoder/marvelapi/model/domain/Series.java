/*
 * Copyright (C) 2018 praktycznykoder.pl
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
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
    
    /**
     *
     */
    public final static String[] ORDERBY_PARAM_NAMES = {
        "title", "modified", "startYear",
    };
    
    /**
     *
     */
    public final static String[] SERIES_TYPES = {
        "", "collection", "one shot", "limited", "ongoing"
    };
    
    /**
     *
     */
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

    /**
     *
     * @param id
     * @param title
     * @param description
     * @param resourceURI
     * @param startYear
     * @param endYear
     * @param rating
     * @param type
     * @param modified
     * @param thumbnail
     * @param urls
     * @param comics
     * @param characters
     * @param stories
     * @param creators
     * @param events
     * @param previous
     * @param next
     */
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
    public String getStartYear() {
        return startYear;
    }

    /**
     *
     * @param startYear
     */
    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    /**
     *
     * @return
     */
    public String getEndYear() {
        return endYear;
    }

    /**
     *
     * @param endYear
     */
    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

    /**
     *
     * @return
     */
    public String getRating() {
        return rating;
    }

    /**
     *
     * @param rating
     */
    public void setRating(String rating) {
        this.rating = rating;
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
}