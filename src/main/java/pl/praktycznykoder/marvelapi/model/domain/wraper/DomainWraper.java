/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.model.domain.wraper;

/**
 * @author praktycznykoder.pl
 * Służy do pobrania podstawowych informacji o obiekcie
 * podrzędnym oraz umożliwia pobranie go, dzięki zawartemu adresowi Url
 * prowadzącego do danego zasobu
 */
public class DomainWraper implements ResourceWraper{
    
    private String name;
    private String type;
    private String role;
    private String resourceURI;

    /**
     *
     * @param name
     * @param type
     * @param role
     * @param resourceURI
     */
    public DomainWraper(String name, String type, String role, String resourceURI) {
        this.name = name;
        this.type = type;
        this.role = role;
        this.resourceURI = resourceURI;
    }

    @Override
    public String toString() {
        return name;
    }

//    @Override
//    public String toString() {
//        return "DomainWraper{" + "name=" + name + ", type=" + type + ", role=" + role + ", resourceURI=" + resourceURI + '}';
//    }
//    
    
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
    public String getRole() {
        return role;
    }

    /**
     *
     * @param role
     */
    public void setRole(String role) {
        this.role = role;
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
    @Override
    public String getUrl() {
        return this.getResourceURI();
    }
}