/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.model.services;

import pl.praktycznykoder.marvelapi.model.repositories.Repository;
import pl.praktycznykoder.marvelapi.model.domain.Event;
import pl.praktycznykoder.marvelapi.model.repositories.EventAbstractRepositoryImpl;

/**
 *
 * @author praktycznykoder.pl
 */
public class EventAbstractServiceImpl extends AbstractService<Event> {

    private final EventAbstractRepositoryImpl repository = 
            new EventAbstractRepositoryImpl();
    
    /**
     *
     * @return
     */
    @Override
    protected Repository getRepository() {
        return repository;
    }

    /**
     *
     * @return
     */
    @Override
    public String[] getOrderByParamNodes() {
        return Event.ORDERBY_PARAM_NAMES;
    }
    
}
