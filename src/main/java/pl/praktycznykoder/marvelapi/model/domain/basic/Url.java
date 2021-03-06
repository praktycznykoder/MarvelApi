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
package pl.praktycznykoder.marvelapi.model.domain.basic;

import pl.praktycznykoder.marvelapi.model.domain.wraper.ResourceWraper;

/**
 *
 * @author praktycznykoder.pl
 */
public class Url implements ResourceWraper{

    private String type;	
    private String url;

    /**
     *
     * @param type
     * @param url
     */
    public Url(String type, String url) {
        this.type = type;
        this.url = url;
    }
    
    @Override
    public String toString() {
            return url+"."+type;
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
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }
}
