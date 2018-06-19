/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.model.repositories;

import pl.praktycznykoder.marvelapi.client.response.EventMarvelApiResponse;
import pl.praktycznykoder.marvelapi.client.response.SeriesMarvelApiResponse;

/**
 *
 * @author praktycznykoder.pl
 */
public class SeriesAbstractRepositoryImpl  extends AbstractRepository<EventMarvelApiResponse> {

    private final String path = "v1/public/series";
    @Override
    protected String getPath() {
        return path;
    }

    @Override
    protected Class<?> getClazz() {
        return SeriesMarvelApiResponse.class;
    }
    
}
