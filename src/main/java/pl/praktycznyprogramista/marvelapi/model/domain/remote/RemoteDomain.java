/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznyprogramista.marvelapi.model.domain.remote;

/**
 * @author praktycznyprogramista.pl
 * Służy do pobrania podstawowych informacji o obiekcie
 * podrzędnym oraz umożliwia pobranie go, dzięki zawartemu adresowi Url
 * prowadzącego do danego zasobu
 */
public class RemoteDomain {
    
    private String name;
    private String type;
    private String role;
    private String resourceURI;

    public RemoteDomain(String name, String type, String role, String resourceURI) {
        this.name = name;
        this.type = type;
        this.role = role;
        this.resourceURI = resourceURI;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public String getResourceURI() {
        return resourceURI;
    }
    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }
}