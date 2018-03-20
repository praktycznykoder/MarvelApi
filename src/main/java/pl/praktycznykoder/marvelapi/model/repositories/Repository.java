/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.praktycznykoder.marvelapi.model.repositories;

import java.util.List;
import pl.praktycznykoder.api.domain.Param;
import pl.praktycznykoder.marvelapi.client.response.MarvelApiResponse;

/**
 *
 * @author praktycznykoder.pl
 */
public interface Repository<Type> {
    MarvelApiResponse<Type> getObjects(List<Param> params, int page);
    MarvelApiResponse<Type> getObjectWithId(String id);
    MarvelApiResponse<Type> getObjectWithUrl(String url, List<Param> params);
}
