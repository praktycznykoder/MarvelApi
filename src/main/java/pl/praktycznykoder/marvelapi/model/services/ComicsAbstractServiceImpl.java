/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.model.services;

import pl.praktycznykoder.marvelapi.client.response.MarvelApiResponse;
import pl.praktycznykoder.marvelapi.model.domain.Comics;
import pl.praktycznykoder.marvelapi.model.repositories.ComicsAbstractRepositoryImpl;
import pl.praktycznykoder.marvelapi.model.repositories.Repository;

/**
 *
 * @author User
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
