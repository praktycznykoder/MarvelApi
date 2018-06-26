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
package pl.praktycznykoder.marvelapi.model.domain.wraper;

/**
 * @author praktycznykoder.pl
 * Służy do pobrania listy obiektów 
 * @see pl.praktycznykoder.marvelapi.model.domain.wraper.DomainWraper
 */
public class DomainListWraper {
    
    private String avaliable;
    private String collectionURI;
    private DomainWraper[] items;
    private String returned;

    /**
     *
     * @param avaliable
     * @param collectionURI
     * @param items
     * @param returned
     */
    public DomainListWraper(String avaliable, String collectionURI, DomainWraper[] items, String returned) {
        this.avaliable = avaliable;
        this.collectionURI = collectionURI;
        this.items = items;
        this.returned = returned;
    }

    /**
     *
     * @return
     */
    public String getAvaliable() {
        return avaliable;
    }

    /**
     *
     * @param avaliable
     */
    public void setAvaliable(String avaliable) {
        this.avaliable = avaliable;
    }

    /**
     *
     * @return
     */
    public String getCollectionURI() {
        return collectionURI;
    }

    /**
     *
     * @param collectionURI
     */
    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }

    /**
     *
     * @return
     */
    public DomainWraper[] getItems() {
        return items;
    }

    /**
     *
     * @param items
     */
    public void setItems(DomainWraper[] items) {
        this.items = items;
    }

    /**
     *
     * @return
     */
    public String getReturned() {
        return returned;
    }

    /**
     *
     * @param returned
     */
    public void setReturned(String returned) {
        this.returned = returned;
    }    
}