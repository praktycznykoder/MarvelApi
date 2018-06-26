/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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