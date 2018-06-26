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
package pl.praktycznykoder.marvelapi.model.services;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import pl.praktycznykoder.api.domain.Param;
import pl.praktycznykoder.marvelapi.client.response.Data;

/**
 *
 * @author praktycznykoder.pl
 * @param <OBJECT_TYPE>
 */
public interface Service<OBJECT_TYPE> {

    /**
     *
     * @param params
     * @param page
     * @return
     * @throws NoSuchAlgorithmException
     * @throws URISyntaxException
     * @throws IOException
     */
    Data getData(List<Param> params, int page)
            throws NoSuchAlgorithmException, URISyntaxException,IOException;
    
//    Pagging getPaggingFromData(Data data);
//    List<OBJECT_TYPE> getObjectsFromData(Data data);

    /**
     *
     * @param id
     * @return
     * @throws NoSuchAlgorithmException
     * @throws URISyntaxException
     * @throws IOException
     */
    
    OBJECT_TYPE getObjectWithId(String id)
            throws NoSuchAlgorithmException, URISyntaxException,IOException;

    /**
     *
     * @param url
     * @param params
     * @return
     * @throws NoSuchAlgorithmException
     * @throws URISyntaxException
     * @throws IOException
     */
    OBJECT_TYPE getObjectWithUrl(String url, List<Param> params)
            throws NoSuchAlgorithmException, URISyntaxException,IOException;

    /**
     *
     * @param url
     * @return
     * @throws IOException
     */
    BufferedImage getImage(String url) throws IOException;

    /**
     *
     * @return
     */
    String[] getOrderByParamNodes();

    /**
     *
     * @return
     */
    String[] getThreeBooleanState();
    
    
}
