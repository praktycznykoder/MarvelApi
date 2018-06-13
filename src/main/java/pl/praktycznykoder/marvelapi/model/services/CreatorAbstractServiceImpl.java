/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.model.services;

import pl.praktycznykoder.marvelapi.model.repositories.Repository;
import pl.praktycznykoder.marvelapi.model.domain.Creator;
import pl.praktycznykoder.marvelapi.model.repositories.CreatorAbstractRepositoryImpl;

/**
 *
 * @author praktycznykoder.pl
 */
public class CreatorAbstractServiceImpl extends AbstractService<Creator> {

    private final CreatorAbstractRepositoryImpl repository = 
            new CreatorAbstractRepositoryImpl();
    
    @Override
    protected Repository getRepository() {
        return repository;
    }

    @Override
    public String[] getOrderByParamNodes() {
        return Creator.ORDERBY_PARAM_NAMES;
    }
    
}