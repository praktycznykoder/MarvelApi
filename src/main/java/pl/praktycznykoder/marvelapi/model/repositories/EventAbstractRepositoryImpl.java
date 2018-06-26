/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.model.repositories;

import pl.praktycznykoder.marvelapi.client.response.EventMarvelApiResponse;

/**
 *
 * @author praktycznykoder.pl
 */
public class EventAbstractRepositoryImpl  extends AbstractRepository<EventMarvelApiResponse> {

    private final String path = "v1/public/events";

    /**
     *
     * @return
     */
    @Override
    protected String getPath() {
        return path;
    }

    /**
     *
     * @return
     */
    @Override
    protected Class<?> getClazz() {
        return EventMarvelApiResponse.class;
    }
    
}
