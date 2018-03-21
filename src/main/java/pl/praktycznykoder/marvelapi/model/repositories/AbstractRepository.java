/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import pl.praktycznykoder.marvelapi.client.response.ComicsMarvelApiResponse;

/**
 *
 * @author praktycznykoder.pl
 * @param <RESPONSE_TYPE>
 */
public abstract class AbstractRepository<RESPONSE_TYPE> implements Repository<RESPONSE_TYPE> {
    
    
    private final MarvelApiClient client = new MarvelApiClient();
    
    protected MarvelApiClient getClient() {
        return client;
    }
    
    protected abstract String getPath();
    protected abstract Class<?> getClazz();
    
    public void setResultLimit(int resultLimit){
        getClient().setRESULT_LIMIT(resultLimit);
    }
    
    
    
     @Override
    public RESPONSE_TYPE getObjects(List params,int page) {
        try {
            return (RESPONSE_TYPE) getClient().getObjectFromJsonString(
                getClient().getPaggingResponseFromMarvelApi(
                        getPath(), false, params, page), getClazz());
        } catch (NoSuchAlgorithmException | URISyntaxException | IOException ex) {
            Logger.getLogger(ComicsAbstractRepositoryImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public RESPONSE_TYPE getObjectWithId(String id) { 
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

    @Override
    public RESPONSE_TYPE getObjectWithUrl(String url, List<Param> params) {
        try {
            return (RESPONSE_TYPE) getClient().getObjectFromJsonString(
                getClient().getPaggingResponseFromMarvelApi(
                        url, true, null, 0), ComicsMarvelApiResponse.class);
        } catch (NoSuchAlgorithmException | URISyntaxException | IOException ex) {
            Logger.getLogger(ComicsAbstractRepositoryImpl.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public BufferedImage getImage(String url) {
        return getClient().getImage(url);
    }
    
}
