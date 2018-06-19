/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.model.services;

import pl.praktycznykoder.marvelapi.model.domain.Series;
import pl.praktycznykoder.marvelapi.model.repositories.Repository;
import pl.praktycznykoder.marvelapi.model.repositories.SeriesAbstractRepositoryImpl;

/**
 *
 * @author praktycznykoder.pl
 */
public class SeriesAbstractServiceImpl extends AbstractService<Series> {

    private final SeriesAbstractRepositoryImpl repository = 
            new SeriesAbstractRepositoryImpl();
    
    @Override
    protected Repository getRepository() {
        return repository;
    }

    @Override
    public String[] getOrderByParamNodes() {
        return Series.ORDERBY_PARAM_NAMES;
    }
    
    public String[] getContains() {
        return Series.CONTAINS;
    }
}
