/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.model.services;

import pl.praktycznykoder.marvelapi.model.domain.Story;
import pl.praktycznykoder.marvelapi.model.repositories.Repository;
import pl.praktycznykoder.marvelapi.model.repositories.StoryAbstractRepositoryImpl;

/**
 *
 * @author praktycznykoder.pl
 */
public class StoryAbstractServiceImpl extends AbstractService<Story> {

    private final StoryAbstractRepositoryImpl repository = 
            new StoryAbstractRepositoryImpl();
    
    @Override
    protected Repository getRepository() {
        return repository;
    }

    @Override
    public String[] getOrderByParamNodes() {
        return Story.ORDERBY_PARAM_NAMES;
    }
    
}
