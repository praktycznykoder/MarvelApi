/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.model.services;

import pl.praktycznykoder.marvelapi.model.domain.Comics;
import pl.praktycznykoder.marvelapi.model.repositories.ComicsAbstractRepositoryImpl;
import pl.praktycznykoder.marvelapi.model.repositories.Repository;

/**
 *
 * @author praktycznykoder.pl
 */
public class ComicsAbstractServiceImpl 
        extends AbstractService<Comics> {

    private final ComicsAbstractRepositoryImpl repository = 
            new ComicsAbstractRepositoryImpl();
    
    @Override
    protected Repository getRepository() {
        return repository;
    }

    @Override
    public String[] getOrderByParamNodes() {
        return Comics.ORDERBY_PARAM_NAMES;
    }
    
    public String[] getFormatParamNodes() {
        return Comics.FORMAT_PARAM_NAMES;
    }
    
    public String[] getFormatTypeParamNodes() {
        return Comics.FORMAT_TYPE_PARAM_NAMES;
    }
    
    public String[] getDateDescriptorParamNodes() {
        return Comics.DATE_DESCRIPTOR_PARAM_NAMES;
    }
    
}
