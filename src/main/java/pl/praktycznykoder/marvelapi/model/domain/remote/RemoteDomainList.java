/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.model.domain.remote;

/**
 * @author praktycznykoder.pl
 * Służy do pobrania listy obiektów 
 * @see pl.praktycznykoder.marvelapi.model.domain.remote.RemoteDomain
 */
public class RemoteDomainList {
    
    private String avaliable;
    private String collectionURI;
    private RemoteDomain[] items;
    private String returned;

    public RemoteDomainList(String avaliable, String collectionURI, RemoteDomain[] items, String returned) {
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
    public RemoteDomain[] getItems() {
        return items;
    }
    public void setItems(RemoteDomain[] items) {
        this.items = items;
    }
    public String getReturned() {
        return returned;
    }
    public void setReturned(String returned) {
        this.returned = returned;
    }    
}