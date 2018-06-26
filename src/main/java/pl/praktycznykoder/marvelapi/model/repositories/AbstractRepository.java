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
package pl.praktycznykoder.marvelapi.model.repositories;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pl.praktycznykoder.api.domain.Param;
import pl.praktycznykoder.marvelapi.client.MarvelApiClient;

/**
 *
 * @author praktycznykoder.pl
 * @param <RESPONSE_TYPE>
 */
public abstract class AbstractRepository<RESPONSE_TYPE> implements Repository<RESPONSE_TYPE> {
    
    
    private final MarvelApiClient client = new MarvelApiClient();
    
    /**
     *
     * @return
     */
    protected MarvelApiClient getClient() {
        return client;
    }
    
    /**
     *
     * @return
     */
    protected abstract String getPath();

    /**
     *
     * @return
     */
    protected abstract Class<?> getClazz();
    
    /**
     *
     * @param resultLimit
     */
    public void setResultLimit(int resultLimit){
        getClient().setRESULT_LIMIT(resultLimit);
    }
    
    /**
     *
     * @param params
     * @param page
     * @return
     * @throws NoSuchAlgorithmException
     * @throws URISyntaxException
     * @throws IOException
     */
    @Override
    public RESPONSE_TYPE getObjects(List params,int page)
            throws NoSuchAlgorithmException, URISyntaxException,IOException {
        return (RESPONSE_TYPE) getClient().getObjectFromJsonString(
                getClient().getPaggingResponseFromMarvelApi(
                        getPath(), false, params, page), getClazz());
    }

    /**
     *
     * @param id
     * @return
     * @throws NoSuchAlgorithmException
     * @throws URISyntaxException
     * @throws IOException
     */
    @Override
    public RESPONSE_TYPE getObjectWithId(String id) 
            throws NoSuchAlgorithmException, URISyntaxException,IOException{ 
        String path = getPath()+"/"+id;
        try {
            return (RESPONSE_TYPE) getClient().getObjectFromJsonString(
                getClient().getPaggingResponseFromMarvelApi(
                        path, false, null, 0), getClazz());
        } catch (NoSuchAlgorithmException | URISyntaxException | IOException ex) {
            Logger.getLogger(ComicsAbstractRepositoryImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     *
     * @param url
     * @param params
     * @return
     * @throws NoSuchAlgorithmException
     * @throws URISyntaxException
     * @throws IOException
     */
    @Override
    public RESPONSE_TYPE getObjectWithUrl(String url, List<Param> params) 
            throws NoSuchAlgorithmException, URISyntaxException,IOException{
        try {
            return (RESPONSE_TYPE) getClient().getObjectFromJsonString(
                getClient().getPaggingResponseFromMarvelApi(
                        url, true, null, 0), getClazz());
        } catch (NoSuchAlgorithmException | URISyntaxException | IOException ex) {
            Logger.getLogger(ComicsAbstractRepositoryImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     *
     * @param url
     * @return
     * @throws IOException
     */
    @Override
    public BufferedImage getImage(String url) throws IOException {
        return getClient().getImage(url);
    }
    
}
