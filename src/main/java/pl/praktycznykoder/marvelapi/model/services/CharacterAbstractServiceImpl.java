/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.model.services;

import pl.praktycznykoder.marvelapi.model.repositories.CharactersAbstractRepositoryImpl;
import pl.praktycznykoder.marvelapi.model.repositories.Repository;

/**
 *
 * @author User
 */
public class CharacterAbstractServiceImpl extends AbstractService<Character> {

    private final CharactersAbstractRepositoryImpl repository = 
            new CharactersAbstractRepositoryImpl();
    
    @Override
    protected Repository getRepository() {
        return repository;
    }
    
}