/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.model.services;

import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;
import pl.praktycznykoder.api.domain.Param;
import pl.praktycznykoder.marvelapi.client.response.MarvelApiResponse;
import pl.praktycznykoder.marvelapi.model.repositories.Repository;

/**
 *
 * @author praktycznykoder.pl
 * @param <OBJECT_TYPE>
 */
public abstract class AbstractService<OBJECT_TYPE> implements Service<OBJECT_TYPE> {

    protected abstract Repository<MarvelApiResponse> getRepository();
    
    @Override
    public OBJECT_TYPE getObjectWithUrl(String url, List<Param> params){
        MarvelApiResponse mar = getRepository().getObjectWithUrl(url, params);
        return (OBJECT_TYPE) mar.getData().getResults()[0];
    }

    @Override
    public OBJECT_TYPE getObjectWithId(String id){
        MarvelApiResponse mar = getRepository().getObjectWithId(id);
        return (OBJECT_TYPE) mar.getData().getResults()[0];
    }

    @Override
    public List<OBJECT_TYPE> getObjects(List<Param> params, int page){
        MarvelApiResponse mar = getRepository().getObjects(params, 0);
        return (List<OBJECT_TYPE>) Arrays.asList(mar.getData().getResults());
    }

    @Override
    public BufferedImage getImage(String url){
        return getRepository().getImage(url);
    }
    
}
