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

    public DomainListWraper(String avaliable, String collectionURI, DomainWraper[] items, String returned) {
        this.avaliable = avaliable;
        this.collectionURI = collectionURI;
        this.items = items;
        this.returned = returned;
    }

    public String getAvaliable() {
        return avaliable;
    }
    public void setAvaliable(String avaliable) {
        this.avaliable = avaliable;
    }
    public String getCollectionURI() {
        return collectionURI;
    }
    public void setCollectionURI(String collectionURI) {
        this.collectionURI = collectionURI;
    }
    public DomainWraper[] getItems() {
        return items;
    }
    public void setItems(DomainWraper[] items) {
        this.items = items;
    }
    public String getReturned() {
        return returned;
    }
    public void setReturned(String returned) {
        this.returned = returned;
    }    
}