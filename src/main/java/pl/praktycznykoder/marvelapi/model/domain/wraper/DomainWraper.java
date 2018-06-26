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