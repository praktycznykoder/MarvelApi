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
import pl.praktycznykoder.marvelapi.model.domain.wraper.DomainListWraper;

/**
 *
 * @author praktycznykoder.pl
 */
public class Character implements Domain {
    
    /**
     *
     */
    public final static String[] ORDERBY_PARAM_NAMES = {
        "name", "modified"
    };

    private int id;
    private String name;
    private String description;
    private String modified;
    private String resourceURI;
    private Image thumbnail;
    private Url[] urls;
    private DomainListWraper comics;
    private DomainListWraper series;
    private DomainListWraper events;
    private DomainListWraper stories;

    /**
     *
     * @param id
     * @param name
     * @param description
     * @param modified
     * @param resourceURI
     * @param thumbnail
     * @param urls
     * @param comics
     * @param series
     * @param events
     * @param stories
     */
    public Character(int id, String name, String description, String modified, 
            String resourceURI, Image thumbnail, Url[] urls, 
            DomainListWraper comics, DomainListWraper series, 
            DomainListWraper events, DomainListWraper stories) {
        
        this.id = id;
        this.name = name;
        this.description = description;
        this.modified = modified;
        this.resourceURI = resourceURI;
        this.thumbnail = thumbnail;
        this.urls = urls;
        this.comics = comics;
        this.series = series;
        this.events = events;
        this.stories = stories;
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
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
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
    
}