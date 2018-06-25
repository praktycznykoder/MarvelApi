/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.model.repositories;

import pl.praktycznykoder.marvelapi.client.response.StoryMarvelApiResponse;

/**
 *
 * @author praktycznykoder.pl
 */
public class StoryAbstractRepositoryImpl  extends AbstractRepository<StoryMarvelApiResponse> {

    private final String path = "v1/public/stories";
    @Override
    protected String getPath() {
        return path;
    }

    @Override
    protected Class<?> getClazz() {
        return StoryMarvelApiResponse.class;
    }
    
}
